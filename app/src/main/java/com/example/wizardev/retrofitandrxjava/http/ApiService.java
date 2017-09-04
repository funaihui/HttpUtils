package com.example.wizardev.retrofitandrxjava.http;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/18
 * desc   : Retrofit网络请求的接口
 * version: 1.0
 */
public interface ApiService {

    String BASE_URL = "http://192.168.0.133:8080/";

      @POST
      Observable<String> executePost(@Url String url, @Body Map<String,String> maps);
}
