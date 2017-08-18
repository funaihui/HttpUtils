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
 * desc   :
 * version: 1.0
 */
public interface ApiService {
    @POST
    Observable<BaseResponse<String>> executePost(@Url String url, @Body Map<String,String> maps);
}
