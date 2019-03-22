package com.example.a13621.merchant.service;

import com.example.a13621.merchant.entity.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HomeService {
    @GET
    Observable<HomeBean> getHome(@Url String url);
}
