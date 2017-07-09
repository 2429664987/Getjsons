package com.example.administrator.getjsons.fragment;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.getjsons.R;

/**
 * Created by 123 on 2017/4/8.
 */

public class Fragment2 extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment2,container,false);




        return view;
    }
}
