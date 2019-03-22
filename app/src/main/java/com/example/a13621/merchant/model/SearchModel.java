package com.example.a13621.merchant.model;

import android.annotation.SuppressLint;

import com.example.a13621.merchant.api.Api;
import com.example.a13621.merchant.contract.SearchContract;
import com.example.a13621.merchant.entity.SearchBean;
import com.example.a13621.merchant.net.PMCallback;
import com.example.a13621.merchant.service.SearchService;
import com.example.lib_network.network.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchModel implements SearchContract.IModel {
    @SuppressLint("CheckResult")
    @Override
    public void onModel(HashMap<String, String> params, final PMCallback pmCallback) {
        RetrofitUtils.getInstance().createService(SearchService.class)
                .getSearch(Api.SEARCH_URL, params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<SearchBean>() {
                    @Override
                    public void accept(SearchBean searchBean) throws Exception {
                        if (searchBean.getStatus().equals("0000")){
                            pmCallback.onSuccess(searchBean);
                        }else {
                            pmCallback.onFail(searchBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("SearchModel层异常："+throwable);
                    }
                });
    }
}
