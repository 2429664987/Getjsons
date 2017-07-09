package com.example.administrator.getjsons.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.adapter.F1adapter;

/**
 * Created by 123 on 2017/4/8.
 */

public class Fragment4 extends Fragment{
    private ImageView imageView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment4,container,false);

        return view;
    }
    public void init(){
        imageView= (ImageView) view.findViewById(R.id.imgg);


    }


}
