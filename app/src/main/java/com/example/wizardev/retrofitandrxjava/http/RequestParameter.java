package com.example.wizardev.retrofitandrxjava.http;

import java.util.HashMap;
import java.util.Map;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/21
 * desc   :
 * version: 1.0
 */
public class RequestParameter {
    private Map<String, String> stringParams;

    public void putString(String key, String value) {
        if (stringParams == null) {
            stringParams = new HashMap<String, String>();
        }
        stringParams.put(key, value);
    }
}
