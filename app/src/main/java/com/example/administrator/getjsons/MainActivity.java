package com.example.administrator.getjsons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button getjson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        init();


    }

    public void init(){
        getjson= (Button) findViewById(R.id.getjson);

        getjson.setOnClickListener(this);
    }

     @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.getjson:
                  sendRequestWithokhttp();
                 break;

          }
    }

    private void sendRequestWithokhttp(){
        RequestQueue queue= Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.POST, "http://169.254.171.105:8080/travel/queryintroductionList.htmlx", new Response.Listener<String>() {
            String king="";
            @Override
            public void onResponse(String s) {
                try {
                    king= URLDecoder.decode(s,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
               // System.out.println("返回值++++++===="+king);
                parseJSONWithJSONObjict(king);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(request);
    }

    private void parseJSONWithJSONObjict(String jsons){
        try {
            JSONArray jsonArray= new JSONArray(jsons);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                String id=jsonObject.getString("id");
                String txsrc=jsonObject.getString("txsrc");
                String content=jsonObject.getString("content");
                String theme=jsonObject.getString("theme");
                System.out.println("*"+id+"**"+txsrc+"***"+content+"****"+theme);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


}
