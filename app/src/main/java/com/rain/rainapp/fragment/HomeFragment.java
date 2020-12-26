package com.rain.rainapp.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rain.rainapp.R;
import com.rain.rainapp.common.GlideImageLoader;
import com.rain.rainapp.entity.BannerList;
import com.rain.rainapp.fragment.home.LeftFragment;
import com.rain.rainapp.fragment.home.RightFragment;
import com.rain.rainapp.utils.HttpUrl;
import com.rain.rainapp.utils.OkHttpUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    private String content;
    Banner banner;

    List<String> listImg;

    TextView home_left;
    TextView home_right;

    private FragmentManager fManager;

    private LeftFragment leftFragment;
    private RightFragment rightFragment;
    private FrameLayout ly_content;


    public HomeFragment(String content) {
        this.content = content;
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                banner();
            } else if (msg.what == 2) {
                banner();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        home_left = view.findViewById(R.id.home_left);

        home_right = view.findViewById(R.id.home_right);

        banner = view.findViewById(R.id.banner);


        fManager = getFragmentManager();

        getAdvert();

        return view;
    }

    private void setSelected() {
        home_right.setSelected(false);
        home_left.setSelected(false);
    }


    public void getAdvert() {
        OkHttpUtil.getAdvert(HttpUrl.host, HttpUrl.bannerUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                System.out.println(res);
                Gson gson = new Gson();
                BannerList list = gson.fromJson(res, BannerList.class);
                if (list.getStatus() == 100) {
                    listImg = new ArrayList<>();
                    for (BannerList.DataBean bean:list.getData()){
                        listImg.add(bean.getImage());
                    }
                    Message msg = handler.obtainMessage();
                    msg.what = 1;
                    msg.obj = listImg;
                    handler.sendMessage(msg);

                } else {
                    listImg = new ArrayList<>();
                    listImg.add("http://ww4.sinaimg.cn/large/610dc034jw1f6ipaai7wgj20dw0kugp4.jpg");
                    listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f6gcxc1t7vj20hs0hsgo1.jpg");
                    listImg.add("http://ww4.sinaimg.cn/large/610dc034jw1f6f5ktcyk0j20u011hacg.jpg");
                    listImg.add("http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg");
                    listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg");
                    listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f69c9e22xjj20u011hjuu.jpg");
                    Message msg = handler.obtainMessage();
                    msg.what = 2;
                    msg.obj = listImg;
                    handler.sendMessage(msg);
                }
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        home_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideFragment(fTransaction);
                setSelected();
                home_left.setSelected(true);
                if (leftFragment == null) {
                    leftFragment = new LeftFragment("归还记录");
                    fTransaction.add(R.id.home_layout, leftFragment);
                } else {
                    fTransaction.show(leftFragment);
                }
                fTransaction.commit();
            }
        });

        home_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fTransaction = fManager.beginTransaction();
                hideFragment(fTransaction);
                setSelected();
                home_right.setSelected(true);
                if (rightFragment == null) {
                    rightFragment = new RightFragment("借出记录");

                    fTransaction.add(R.id.home_layout, rightFragment);
                } else {
                    fTransaction.show(rightFragment);
                }
                fTransaction.commit();
            }
        });

        home_left.performClick();
    }

    //隐藏
    public void hideFragment(FragmentTransaction fragmentTransaction) {
        if (leftFragment != null) {
            fragmentTransaction.hide(leftFragment);
        }
        if (rightFragment != null) {


            fragmentTransaction.hide(rightFragment);
        }

    }


    /**
     * 顶部轮播图
     */
    private void banner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(listImg);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        // banner.setBannerTitles(Util.showListTitle());
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
} 