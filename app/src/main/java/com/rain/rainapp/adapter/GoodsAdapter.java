package com.rain.rainapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rain.rainapp.R;
import com.rain.rainapp.entity.GoodsEntity;

import java.util.List;

public class GoodsAdapter extends BaseAdapter {

    List<GoodsEntity.DataBean> goodsEntityList;

    private LayoutInflater mInflater;

    public GoodsAdapter(Context context,List<GoodsEntity.DataBean> goodsEntityList) {
        this.mInflater=LayoutInflater.from(context);
        this.goodsEntityList = goodsEntityList;

    }

    @Override
    public int getCount() {
        return goodsEntityList.size();
    }

    @Override
    public GoodsEntity.DataBean getItem(int i) {
        return goodsEntityList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        GoodsEntity.DataBean dataBean=getItem(i);
        if (viewHolder==null){
           view=mInflater.inflate(R.layout.goods_item,null);
           viewHolder=new ViewHolder();
           viewHolder.goods_name=view.findViewById(R.id.goods_name);
           view.setTag(viewHolder);
        }else {
         viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.goods_name.setText(dataBean.getGoodsName());
        return view;
    }

    public class ViewHolder{
        private TextView goods_name;
    }

}