package com.rain.rainapp.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.rain.rainapp.R;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    String content;

    public MyFragment(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        TextView txt_content = view.findViewById(R.id.txt_content);
        txt_content.setText(content);
        return view;
    }
}