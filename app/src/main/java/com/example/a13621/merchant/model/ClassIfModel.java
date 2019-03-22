package com.example.a13621.merchant.model;

import android.annotation.SuppressLint;

import com.example.a13621.merchant.api.Api;
import com.example.a13621.merchant.contract.ClassIfContract;
import com.example.a13621.merchant.entity.ClassIfBean;
import com.example.a13621.merchant.net.PMCallback;
import com.example.a13621.merchant.service.ClassIfService;
import com.example.lib_network.network.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ClassIfModel implements ClassIfContract.IModel {
    @SuppressLint("CheckResult")
    @Override
    public void onModel(HashMap<String, String> params, final PMCallback pmCallback) {
        RetrofitUtils.getInstance().createService(ClassIfService.class)
                .getClassIf(Api.ClassIf_URL, params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ClassIfBean>() {
                    @Override
                    public void accept(ClassIfBean classIfBean) throws Exception {
                        if (classIfBean.getStatus().equals("0000")){
                            pmCallback.onSuccess(classIfBean);
                        }else {
                            pmCallback.onFail(classIfBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("ClassIfModel层异常："+throwable);
                    }
                });
    }
}
