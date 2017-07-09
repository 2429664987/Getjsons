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

import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.entity.Txintroduction;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import org.apache.http.Header;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

public class F4adapter  extends BaseAdapter {
    private List<Txintroduction> oList;
    private Context ocontext;           //联系上下文
    private LayoutInflater oInflater;
    private Bitmap bitmap;

    public F4adapter(List<Txintroduction> oList,Context ocontext){
        this.oList=oList;
        this.ocontext=ocontext;
        this.oInflater=LayoutInflater.from(ocontext);
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
        F4adapter.ViewHoulder ohoulder=null;
        if(view==null){
            ohoulder=new F4adapter.ViewHoulder();
            view=oInflater.inflate(R.layout.item,null);
            ohoulder.txsrc= (ImageView) view.findViewById(R.id.txsrc);
            view.setTag(ohoulder);
        }else{
            ohoulder= (F4adapter.ViewHoulder) view.getTag();
        }
        //获取图片
        Bitmap bitmaps=AsynClints();
        ohoulder.txsrc.setImageBitmap(bitmaps);
        return view;
    }
    class ViewHoulder{
        ImageView txsrc;

    }

    public  Bitmap  AsynClints(){
        //System.out.println("++++++++====---"+imgsrc);
        AsyncHttpClient client=new AsyncHttpClient();
        //BinaryHttpResponseHandler是一个封装好的处理二进制数据接收的接口
        client.get("http://169.254.161.52:8080/travel/imgs/ktv.png", new BinaryHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //测试 来接收一张图片 ,Bitmap是一个图对象，可以填充imageView
                bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            }
        });
        return bitmap;
    }

}
