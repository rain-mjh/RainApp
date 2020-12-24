package com.rain.rainapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.rain.rainapp.fragment.MyFragment;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView txt_topbar;
    private TextView txt_home;
    private TextView txt_find;
    private TextView txt_me;

    private FrameLayout ly_content;

    private MyFragment fg1,fg2,fg3;

    private FragmentManager fManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        initView();
        txt_home.performClick();
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
        if (fg1!=null){
            fragmentTransaction.hide(fg1);
        }
        if (fg2!=null){
            fragmentTransaction.hide(fg2);
        }
        if (fg3!=null){
            fragmentTransaction.hide(fg3);
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
              if(fg1 == null){
                  fg1 = new MyFragment("第一个Fragment");
                  fTransaction.add(R.id.ly_content,fg1);

              }else{
                  fTransaction.show(fg1);
              }
              break;
          case R.id.txt_find:
              setSelected();
              txt_find.setSelected(true);
              txt_topbar.setText("发现");
              if(fg2 == null){
                  fg2 = new MyFragment("第二个Fragment");
                  fTransaction.add(R.id.ly_content,fg2);
              }else{
                  fTransaction.show(fg2);
              }
              break;
          case R.id.txt_me:
              setSelected();
              txt_me.setSelected(true);
              txt_topbar.setText("我的");
              if(fg3 == null){
                  fg3 = new MyFragment("第三个Fragment");
                  fTransaction.add(R.id.ly_content,fg3);
              }else{
                  fTransaction.show(fg3);
              }
              break;
      }
        fTransaction.commit();
    }
}