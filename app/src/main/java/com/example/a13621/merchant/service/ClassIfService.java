package com.example.a13621.merchant.service;

import com.example.a13621.merchant.entity.ClassIfBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ClassIfService {
    @GET
    Observable<ClassIfBean> getClassIf(@Url String url, @QueryMap HashMap<String, String> params);
}
