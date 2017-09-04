package com.example.wizardev.retrofitandrxjava.http;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/21
 * desc   :
 * version: 1.0
 */
class MyResponseBodyConverter implements Converter<ResponseBody, String> {
    @Override
    public String convert(ResponseBody value) throws IOException {
        String string = value.string();
        return string;
    }
}
