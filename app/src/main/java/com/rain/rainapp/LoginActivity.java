package com.rain.rainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rain.rainapp.entity.UserInfo;
import com.rain.rainapp.utils.HttpUrl;
import com.rain.rainapp.utils.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_pwd;
    private TextView tv_tip;
    private Button login_btn;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            } else if (msg.what == 2) {
                tv_tip.setText("账号或密码有误!");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        tv_tip = findViewById(R.id.tv_tip);
        login_btn = findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_btn:
                loginTap();
                break;
        }
    }

    public void loginTap() {
        String userName = et_name.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        if (userName.equals("") || pwd.equals("")) {
            Toast.makeText(LoginActivity.this, "输入不能空!", Toast.LENGTH_SHORT).show();
            return;
        }
        OkHttpUtil.login(HttpUrl.host1, HttpUrl.loginUrl, userName, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string().trim();
                System.out.println(res);
                Gson gson = new Gson();
                UserInfo info = gson.fromJson(res, UserInfo.class);
                Message msg = handler.obtainMessage();

                if (info.getStatus() == 200) {
                    msg.what = 1;
                    saveUserInfo(res);
                } else {
                    msg.what = 2;
                    msg.obj=info.getErrMsg();
                }
                handler.sendMessage(msg);
            }
        });
    }

    public void saveUserInfo(String res) {
        SharedPreferences.Editor editor = getSharedPreferences("userInfo", MODE_PRIVATE).edit();
        editor.putString("user", res);
        editor.apply();
    }
}