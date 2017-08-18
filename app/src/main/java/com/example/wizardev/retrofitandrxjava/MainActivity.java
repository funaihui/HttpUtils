package com.example.wizardev.retrofitandrxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.wizardev.retrofitandrxjava.http.ApiService;
import com.example.wizardev.retrofitandrxjava.http.BaseObserver;
import com.example.wizardev.retrofitandrxjava.http.BaseResponse;
import com.example.wizardev.retrofitandrxjava.http.LoggingInterceptor;
import com.example.wizardev.retrofitandrxjava.http.RxSchedulers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new LoggingInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    private static ApiService retrofitService = new Retrofit.Builder()
            .baseUrl("http://192.168.0.133:8080/")
            .client(httpClient)
            // 添加Gson转换器
            .addConverterFactory(GsonConverterFactory.create())
            // 添加Retrofit到RxJava的转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService.class);

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
        Observable<BaseResponse<String>> observable = retrofitService.executePost("news/getNewsList",map);

        observable.compose(RxSchedulers.<BaseResponse<String>>compose()).subscribe(new BaseObserver<String>(MainActivity.this) {
            @Override
            protected void onHandleSuccess(String s) {
                Log.i(TAG, "onHandleSuccess: "+s);
            }
        });


    }


}
