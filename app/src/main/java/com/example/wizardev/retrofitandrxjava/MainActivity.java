package com.example.wizardev.retrofitandrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.wizardev.retrofitandrxjava.http.BaseObserver;
import com.example.wizardev.retrofitandrxjava.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData();
            }
        });
    }

    private void requestData(){
        Map<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("size", "10");
      RetrofitClient.getInstance(MainActivity.this)
                .createBaseApi().post("news/getNewsList", map, new BaseObserver() {
          @Override
          protected void onHandleSuccess(String t) {
              Log.i(TAG, "onHandleSuccess: "+t );
          }
      });
    }
}
