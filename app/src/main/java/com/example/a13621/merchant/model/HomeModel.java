package com.example.a13621.merchant.model;

import android.annotation.SuppressLint;

import com.example.a13621.merchant.api.Api;
import com.example.a13621.merchant.contract.HomeContract;
import com.example.a13621.merchant.entity.BannerBean;
import com.example.a13621.merchant.entity.HomeBean;
import com.example.a13621.merchant.net.PMCallback;
import com.example.a13621.merchant.service.XBannerService;
import com.example.a13621.merchant.service.HomeService;
import com.example.lib_network.network.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.IModel {
    @SuppressLint("CheckResult")
    @Override
    public void onModelHome(final PMCallback pmCallback) {
        RetrofitUtils.getInstance().createService(HomeService.class)
                .getHome(Api.HOME_URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        String status = homeBean.getStatus();
                        if (status.equals("0000")){
                            pmCallback.onSuccess(homeBean);
                        }else {
                            pmCallback.onFail(homeBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("HomeModel层有异常:"+throwable);
                    }
                });
    }

    @SuppressLint("CheckResult")
    @Override
    public void onModelBanner(final PMCallback pmCallback) {
        RetrofitUtils.getInstance().createService(XBannerService.class)
                .getBanner(Api.BANNER_URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        String status = bannerBean.getStatus();
                        if (status.equals("0000")){
                            pmCallback.onSuccess(bannerBean);
                        }else {
                            pmCallback.onFail(bannerBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("BannerModel层有异常:"+throwable);
                    }
                });
    }
}
