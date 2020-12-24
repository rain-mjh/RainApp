package com.rain.rainapp.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.rain.rainapp.R;

@SuppressLint("ValidFragment")
public class FindFragment extends Fragment {

    String content;

    public FindFragment(String content) {
        this.content=content;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.find_fragment,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}