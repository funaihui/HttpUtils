package com.example.wizardev.retrofitandrxjava.http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/21
 * desc   :
 * version: 1.0
 */
class MyRequestBodyConverter<T> implements Converter<T, RequestBody> {


    private static final MediaType MEDIA_TYPE = MediaType
            .parse("application/json; charset=UTF-8");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    final Gson gson;
    final TypeAdapter<T> adapter;

    MyRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
        System.out.println("#IRequestBodyConverter初始化#");
    }

    // 接口如果这样定义 void doPost(@Body by); \才会执行到这里,
    @Override
    public RequestBody convert(T value) throws IOException {
        String json = value.toString();
        return RequestBody.create(MEDIA_TYPE, json);
    }


}
