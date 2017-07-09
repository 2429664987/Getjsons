package com.example.administrator.getjsons;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.administrator.getjsons.fragment.Fragment1;
import com.example.administrator.getjsons.fragment.Fragment2;
import com.example.administrator.getjsons.fragment.Fragment3;
import com.example.administrator.getjsons.fragment.Fragment4;

public class CenterActivity extends AppCompatActivity  implements View.OnClickListener{
    private ImageButton image1,image2,image3,image4;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        initView();//加载UI
    }
    /**
     * 加载UI
     */
    public void initView(){
        image1= (ImageButton) findViewById(R.id.image1);
        image2= (ImageButton) findViewById(R.id.image2);
        image3= (ImageButton) findViewById(R.id.image3);
        image4= (ImageButton) findViewById(R.id.image4);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        fragmentManager=getFragmentManager();
        skipFrag1();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.image1:
                normal();
                image1.setBackgroundResource(R.drawable.main_index_home_pressed);
                skipFrag1();
                break;
            case R.id.image2:
                normal();
                image2.setBackgroundResource(R.drawable.main_index_tuan_pressed);
                skipFrag2();
                break;
            case R.id.image3:
                normal();
                image3.setBackgroundResource(R.drawable.main_index_search_pressed);
                skipFrag3();
                break;
            case R.id.image4:
                normal();
                image4.setBackgroundResource(R.drawable.main_index_my_pressed);
                skipFrag4();
                break;
        }
    }

    /**
     * 所有图片都切换为不选中时状态
     */
    public void normal(){
        image1.setBackgroundResource(R.drawable.main_index_home_normal);
        image2.setBackgroundResource(R.drawable.main_index_tuan_normal);
        image3.setBackgroundResource(R.drawable.main_index_search_normal);
        image4.setBackgroundResource(R.drawable.main_index_my_normal);
    }

    /**
     * 跳转fragment1页面
     */
    public void skipFrag1(){
        transaction=fragmentManager.beginTransaction();
        hide(transaction);
        if(fragment1==null){
            fragment1=new Fragment1();
            transaction.add(R.id.frag,fragment1);
        }
        transaction.show(fragment1);
        transaction.commit();
    }

    /**
     * 跳转fragment2页面
     */
    public void skipFrag2(){
        transaction=fragmentManager.beginTransaction();
        hide(transaction);
        if(fragment2==null){
            fragment2=new Fragment2();
            transaction.add(R.id.frag,fragment2);
        }
        transaction.show(fragment2);
        transaction.commit();
    }

    /**
     * 跳转fragment3页面
     */
    public void skipFrag3(){
        transaction=fragmentManager.beginTransaction();
        hide(transaction);
        if(fragment3==null){
            fragment3=new Fragment3();
            transaction.add(R.id.frag,fragment3);
        }
        transaction.show(fragment3);
        transaction.commit();
    }

    /**
     * 跳转fragment4页面
     */
    public void skipFrag4(){
        transaction=fragmentManager.beginTransaction();
        hide(transaction);
        if(fragment4==null){
            fragment4=new Fragment4();
            transaction.add(R.id.frag,fragment4);
        }
        transaction.show(fragment4);
        transaction.commit();
    }

    /**
     * 隐藏所有界面
     * @param transaction
     */
    public void hide(FragmentTransaction transaction){
        if(fragment1!=null){
            transaction.hide(fragment1);
        }
        if(fragment2!=null){
            transaction.hide(fragment2);
        }
        if(fragment3!=null){
            transaction.hide(fragment3);
        }
        if(fragment4!=null){
            transaction.hide(fragment4);
        }

    }




}
