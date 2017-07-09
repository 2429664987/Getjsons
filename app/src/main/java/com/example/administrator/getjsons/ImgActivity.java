package com.example.administrator.getjsons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.toolbox.StringRequest;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import org.apache.http.Header;

public class ImgActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        imageView= (ImageView) findViewById(R.id.imges);
        //获取图片
        //AsynClints();
        System.out.println("yunixng");
    }
    public void AsynClints(View view){
        System.out.println("阿道夫");
        AsyncHttpClient client=new AsyncHttpClient();
        //BinaryHttpResponseHandler是一个封装好的处理二进制数据接收的接口   http://169.254.161.52:8080/travel/android.png
        System.out.println("俺的份国人提供");

        client.get("http://169.254.161.52:8080/travel/ktv.png", new BinaryHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //测试 来接收一张图片 //Bitmap是一个图对象，可以填充imageView
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                imageView.setImageBitmap(bitmap);
                System.out.println("成功");
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                System.out.println("失败");
            }
        });
    }

}
