package com.rain.rainapp.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rain.rainapp.LoginActivity;
import com.rain.rainapp.R;
import com.rain.rainapp.adapter.GoodsAdapter;
import com.rain.rainapp.entity.GoodsEntity;
import com.rain.rainapp.utils.HttpUrl;
import com.rain.rainapp.utils.OkHttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@SuppressLint("ValidFragment")
public class FindFragment extends Fragment {

    String content;

    GoodsAdapter adapter;

    ListView listView;
    TextView textView;

    private ProgressDialog progressDialog;

    List<GoodsEntity.DataBean> dataBeanList;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                listView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                adapter=new GoodsAdapter(getActivity(),dataBeanList);
                listView.setAdapter(adapter);
            } else if (msg.what == 2) {
                listView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("无数据显示");
            }
        }
    };


    public FindFragment(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);
        textView = view.findViewById(R.id.txt_find);
        listView = view.findViewById(R.id.list_goods);

        //textView.setText(content);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getGoodsList();
    }

    public void showProgressDialog(String title, String message) {
        if (progressDialog == null) {
            progressDialog = progressDialog.show(getActivity(), title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }

        progressDialog.show();
    }

    /*
     * 隐藏提示加载
     */
    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void getGoodsList() {
        showProgressDialog("提示", "正在加载数据....");
        OkHttpUtil.goodsList(HttpUrl.host1, HttpUrl.goodsUrl, "", "", 1, 20, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
                hideProgressDialog();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                hideProgressDialog();
                String res = response.body().string();
                System.out.println(res);
                Gson gson = new Gson();
                GoodsEntity entity = gson.fromJson(res, GoodsEntity.class);
                Message msg = handler.obtainMessage();
                if (entity.getCode() == 0) {
                    msg.what = 1;
                    dataBeanList = entity.getData();
                } else {
                    msg.what = 2;
                }
                handler.sendMessage(msg);
            }
        });
    }


}