package com.example.a13621.merchant.presenter;

import com.example.a13621.merchant.contract.SearchContract;
import com.example.a13621.merchant.net.PMCallback;

import java.util.HashMap;

public class SearchPresenter extends SearchContract.IPresenter {
    @Override
    public void jumpSearch(HashMap<String, String> params) {
        modle.onModel(params, new PMCallback() {
            @Override
            public void onFail(Object msg) {
                view.onFailSearch(msg);
            }

            @Override
            public void onSuccess(Object reg) {
                view.onSuccessSearch(reg);
            }
        });
    }
}
