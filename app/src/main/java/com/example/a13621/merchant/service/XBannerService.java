package com.example.a13621.merchant.service;

import com.example.a13621.merchant.entity.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface XBannerService {
    @GET
    Observable<BannerBean> getBanner(@Url String url);
}
