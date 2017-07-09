package com.example.administrator.getjsons.Title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.getjsons.R;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

//自定义标题栏控件
public class TitleLayout extends LinearLayout implements View.OnClickListener{

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        //获取标题栏
        LayoutInflater.from(context).inflate(R.layout.bar1,this);
        Button titleback= (Button) findViewById(R.id.titleback);
        Button titlediter= (Button) findViewById(R.id.titlediter);

        titleback.setOnClickListener(this);
        titlediter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.titleback:
                Toast.makeText(getContext(),"退出按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.titlediter:
                Toast.makeText(getContext(),"编辑按钮",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
