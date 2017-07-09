package com.example.administrator.getjsons.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.adapter.F1adapter;
import com.example.administrator.getjsons.adapter.F3adapter;
import com.example.administrator.getjsons.entity.Txintroduction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/**
 * Created by 123 on 2017/4/8.
 */

public class Fragment1 extends Fragment{
    private F1adapter f1adapter;
    private ListView listView;
    private View view;
    private List<Txintroduction> oList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment1,container,false);
        //加载控件
        init();
        //获悉网络json数据
        sendRequestWithokhttp();
        return view;
    }
    //适配器适配数据
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            f1adapter=new F1adapter(oList,getActivity());
            listView.setAdapter(f1adapter);
        }
    };

    public void init(){
        listView= (ListView) view.findViewById(R.id.txlist);

    }

    //使用okhttp访问网络
    private void sendRequestWithokhttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("http://192.168.43.246:8080/travel/queryintroductionList.htmlx").build();

                    Response response=client.newCall(request).execute();
                    String jsons=response.body().string();
                    //解析json数据
                    parseJSONWithJSONObjict(jsons);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //解析json数据
    private void parseJSONWithJSONObjict(String jsons){
        oList=new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(jsons);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String txsrc=jsonObject.getString("txsrc");
                String content=jsonObject.getString("content");
                String theme=jsonObject.getString("theme");

                Txintroduction txintroduction=new Txintroduction();
                txintroduction.setId(Integer.valueOf(id));
                txintroduction.setTxsrc(txsrc);
                txintroduction.setContent(content);
                txintroduction.setTheme(theme);
                oList.add(txintroduction);

                System.out.println("*"+id+"**"+txsrc+"***"+content+"****"+theme);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        handler.sendEmptyMessage(0);

    }






}
