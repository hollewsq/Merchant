package com.example.a13621.merchant.service;

import com.example.a13621.merchant.entity.DetailsBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface DetailsService {
    @GET
    Observable<DetailsBean> getDetails(@Url String url, @QueryMap HashMap<String, String> params);
}
