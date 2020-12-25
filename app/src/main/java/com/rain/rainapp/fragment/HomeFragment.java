package com.rain.rainapp.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.rain.rainapp.R;
import com.rain.rainapp.common.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class HomeFragment  extends Fragment {

    private String content;
    Banner banner;

    List<String> listImg;

    TextView home_left;
    TextView home_right;



    public HomeFragment(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_fragment,container,false);
        home_left=view.findViewById(R.id.home_left);

        home_right=view.findViewById(R.id.home_right);

        banner=view.findViewById(R.id.banner);

        listImg=new ArrayList<>();

        listImg.add("http://ww4.sinaimg.cn/large/610dc034jw1f6ipaai7wgj20dw0kugp4.jpg");
        listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f6gcxc1t7vj20hs0hsgo1.jpg");
        listImg.add("http://ww4.sinaimg.cn/large/610dc034jw1f6f5ktcyk0j20u011hacg.jpg");
        listImg.add("http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg");
        listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg");
        listImg.add("http://ww3.sinaimg.cn/large/610dc034jw1f69c9e22xjj20u011hjuu.jpg");

        banner();

        return view;
    }

    private void setSelected(){
        home_right.setSelected(false);
        home_left.setSelected(false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        home_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected();
                home_left.setSelected(true);
                System.out.println("点击1");
            }
        });

        home_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected();
                home_right.setSelected(true);
                System.out.println("点击2");
            }
        });

        home_left.performClick();
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