package com.example.a13621.merchant.presenter;

import com.example.a13621.merchant.contract.DetailsContract;
import com.example.a13621.merchant.net.PMCallback;

import java.util.HashMap;

public class DetailsPresenter extends DetailsContract.IPresenter {
    @Override
    public void jumpClass(HashMap<String, String> params) {
        modle.onModel(params, new PMCallback() {
            @Override
            public void onFail(Object msg) {
                view.onFailDetails(msg);
            }

            @Override
            public void onSuccess(Object reg) {
                view.onSuccessDetails(reg);
            }
        });
    }
}
