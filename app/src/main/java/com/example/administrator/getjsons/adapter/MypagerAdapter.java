package com.example.administrator.getjsons.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 123 on 2017/4/8.
 */

public class MypagerAdapter extends PagerAdapter {

    private List<View> viewList;
    public MypagerAdapter(List<View> viewList){
        this.viewList=viewList;
    }

    /**
     * 返回页卡数量
     * @return
     */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     * View是否来自于对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 实例化一个页卡
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
