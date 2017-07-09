package com.example.administrator.getjsons.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.entity.Txintroduction;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.apache.http.Header;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

public class F1adapter extends BaseAdapter {
    private List<Txintroduction> oList;
    private Context ocontext;           //联系上下文
    private LayoutInflater oInflater;
    private ImageLoader imageLoader;    //第二种方法加载网络图片

    public F1adapter(List<Txintroduction> oList,Context ocontext){
        this.oList=oList;
        this.ocontext=ocontext;
        this.oInflater=LayoutInflater.from(ocontext);

        //第二种方法加载网络图片
        imageLoader=ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ocontext));

    }
    @Override
    public int getCount() {
        return oList.size();
    }

    @Override
    public Object getItem(int i) {
        return oList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoulder ohoulder=null;
        if(view==null){
            ohoulder=new ViewHoulder();
            view=oInflater.inflate(R.layout.item,null);
            ohoulder.txsrc= (ImageView) view.findViewById(R.id.txsrc);
            ohoulder.content= (TextView) view.findViewById(R.id.content);
            ohoulder.theme= (TextView) view.findViewById(R.id.theme);
            view.setTag(ohoulder);
        }else{
            ohoulder= (ViewHoulder) view.getTag();
        }
        //第一种获取图片
        //Glide.with(ocontext).load(oList.get(i).getTxsrc()).into(ohoulder.txsrc);

        //第二种方法加载网络图片
        imageLoader.displayImage(oList.get(i).getTxsrc(),ohoulder.txsrc);

        ohoulder.content.setText(oList.get(i).getContent());
        ohoulder.theme.setText(oList.get(i).getTheme());
        return view;
    }
    class ViewHoulder{
        ImageView txsrc;
        TextView content;
        TextView theme;
    }

}
