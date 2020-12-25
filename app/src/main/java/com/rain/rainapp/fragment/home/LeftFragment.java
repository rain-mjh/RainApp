package com.rain.rainapp.fragment.home;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.rain.rainapp.R;

@SuppressLint("ValidFragment")
public class LeftFragment extends Fragment {
    TextView left_txt;

    String content;

    public LeftFragment(String content) {
        this.content=content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.left_home_fragment,container,false);
        left_txt=view.findViewById(R.id.left_txt);
        left_txt.setText(content);

        return view;
    }

}