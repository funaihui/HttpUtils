package com.example.wizardev.retrofitandrxjava.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/21
 * desc   :
 * version: 1.0
 */
public class MyGsonFactory extends Converter.Factory {
    public static MyGsonFactory create() {
        return create(new GsonBuilder().setLenient().create());
    }

    public static MyGsonFactory create(Gson gson) {
        if (gson == null)
            throw new NullPointerException("gson == null");
        return new MyGsonFactory(gson);
    }

    private final Gson gson;

    private MyGsonFactory(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type,
                                                            Annotation[] annotations, Retrofit retrofit) {
        return new MyResponseBodyConverter(); // 响应
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        System.out.println("#发起请求#");
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new MyRequestBodyConverter<>(gson, adapter); // 请求
    }

}
