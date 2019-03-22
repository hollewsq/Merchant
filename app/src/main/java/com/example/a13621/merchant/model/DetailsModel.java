package com.example.a13621.merchant.model;

import android.annotation.SuppressLint;

import com.example.a13621.merchant.api.Api;
import com.example.a13621.merchant.contract.DetailsContract;
import com.example.a13621.merchant.entity.DetailsBean;
import com.example.a13621.merchant.net.PMCallback;
import com.example.a13621.merchant.service.DetailsService;
import com.example.lib_network.network.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailsModel implements DetailsContract.IModel {
    @SuppressLint("CheckResult")
    @Override
    public void onModel(HashMap<String, String> params, final PMCallback pmCallback) {
        RetrofitUtils.getInstance().createService(DetailsService.class)
                .getDetails(Api.DETAILS_URL, params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<DetailsBean>() {
                    @Override
                    public void accept(DetailsBean detailsBean) throws Exception {
                        if (detailsBean.getStatus().equals("0000")){
                            pmCallback.onSuccess(detailsBean);
                        }else {
                            pmCallback.onFail(detailsBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("DetailsModel层有异常："+throwable);
                    }
                });
    }
}
