package com.rain.rainapp.utils;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtil {

    //物品列表
    public static void goodsList(String host1,String url,String goodsName,String sType, int page, int limit,Callback callback){
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder()
                .add("goodsName", goodsName)
                .add("sType", sType)
                .add("page", String.valueOf(page))
                .add("limit", String.valueOf(limit))
                .build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url(host1+url).post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        okHttpClient.newCall(request).enqueue(callback);
    }


    //登录
    public static void login(String host1,String url,String userName,String password, Callback callback){
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder()
                .add("userName", userName)
                .add("password", password)
                .build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url(host1+url).post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        okHttpClient.newCall(request).enqueue(callback);
    }

    //存件信息
    public static void postStore(String host,String url,String qrCode, Callback callback){
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        RequestBody requestBody = new FormBody.Builder()
                .add("qrCode", qrCode)
                .build();
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url(host+url).post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        okHttpClient.newCall(request).enqueue(callback);
    }

    //get  广告 /Adpictures/Ad_pic
    public static void getAdvert(String host,String url,Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(host+ url)
                .build();  //创建url的请求
        okHttpClient.newCall(request).enqueue(callback);
    }



} 