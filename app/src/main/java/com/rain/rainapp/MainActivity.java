package com.rain.rainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rain.rainapp.entity.UserInfo;
import com.rain.rainapp.fragment.FindFragment;
import com.rain.rainapp.fragment.HomeFragment;
import com.rain.rainapp.fragment.MyFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView txt_topbar;
    private TextView txt_home;
    private TextView txt_find;
    private TextView txt_me;

    private FrameLayout ly_content;

    private MyFragment myFragment;
    private FindFragment findFragment;
    private HomeFragment homeFragment;

    private FragmentManager fManager;

    String code="";

    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        initView();
        txt_home.performClick();

        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        String res=sp.getString("user","");
        if (!res.equals("")){
            System.out.println(res);
            Gson gson=new Gson();
            userInfo=gson.fromJson(res,UserInfo.class);
            code=userInfo.getSuccess().get(0).getvRemarks();
        }
    }

    private void initView() {
        txt_topbar=findViewById(R.id.txt_topbar);
        txt_home=findViewById(R.id.txt_home);
        txt_find=findViewById(R.id.txt_find);
        txt_me=findViewById(R.id.txt_me);

        txt_home.setOnClickListener(this);
        txt_find.setOnClickListener(this);
        txt_me.setOnClickListener(this);
    }

    private void setSelected(){
        txt_home.setSelected(false);
        txt_find.setSelected(false);
        txt_me.setSelected(false);
    }
    //隐藏
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if (homeFragment!=null){
            fragmentTransaction.hide(homeFragment);
        }
        if (findFragment!=null){
            fragmentTransaction.hide(findFragment);
        }
        if (myFragment!=null){
            fragmentTransaction.hide(myFragment);
        }
    }


    @Override
    public void onClick(View view) {
      FragmentTransaction fTransaction = fManager.beginTransaction();
      hideAllFragment(fTransaction);
      switch (view.getId()){
          case R.id.txt_home:
              setSelected();
               txt_home.setSelected(true);
               txt_topbar.setText("首页");
              if(homeFragment == null){
                  homeFragment = new HomeFragment("第一个Fragment");
                  fTransaction.add(R.id.ly_content,homeFragment);

              }else{
                  fTransaction.show(homeFragment);
              }
              break;
          case R.id.txt_find:
              setSelected();
              txt_find.setSelected(true);
              txt_topbar.setText("发现");
              if(findFragment == null){
                  findFragment = new FindFragment("第二个Fragment");
                  fTransaction.add(R.id.ly_content,findFragment);
              }else{
                  fTransaction.show(findFragment);
              }
              break;
          case R.id.txt_me:
              setSelected();
              txt_me.setSelected(true);
              txt_topbar.setText("我的");
              if(myFragment == null){
                  myFragment = new MyFragment(code);
                  fTransaction.add(R.id.ly_content,myFragment);
              }else{
                  fTransaction.show(myFragment);
              }
              break;
      }
        fTransaction.commit();
    }



}