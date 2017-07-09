package com.example.administrator.getjsons.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.getjsons.R;
import com.example.administrator.getjsons.adapter.F3adapter;
import com.example.administrator.getjsons.entity.Txintroduction;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 123 on 2017/4/8.
 */

public class Fragment3 extends Fragment{
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private F3adapter f3adapter;
    RecyclerView recyclerView;
    private View view;

    private List<Txintroduction> oList;
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            f3adapter=new F3adapter(oList,getActivity());

            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(f3adapter);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment3,container,false);
        System.out.println("*==*onCreateView");
        //加载控件
        init();
        //加载json数据
        sendRequestWithokhttp();
        return view;
    }

    public void init(){
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);

    }

    //使用okhttp访问网络
    private void sendRequestWithokhttp(){
        System.out.println("*==*sendRequestWithokhttp");
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
        System.out.println("*==*parseJSONWithJSONObjict");
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

                System.out.println("*==*"+id+"**==**"+txsrc+"***==***"+content+"****==****"+theme);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println("*==*进入适配器");
        handler.sendEmptyMessage(0);

    }

}
