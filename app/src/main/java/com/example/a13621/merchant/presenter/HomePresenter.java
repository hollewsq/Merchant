package com.example.a13621.merchant.presenter;

import com.example.a13621.merchant.contract.HomeContract;
import com.example.a13621.merchant.net.PMCallback;

public class HomePresenter extends HomeContract.IPresenter {
    @Override
    public void jumpHome() {
        modle.onModelHome(new PMCallback() {
            @Override
            public void onFail(Object msg) {
                view.onFailHome(msg);
            }

            @Override
            public void onSuccess(Object reg) {
                view.onSuccessHome(reg);
            }
        });
    }

    @Override
    public void jumpBanner() {
        modle.onModelBanner(new PMCallback() {
            @Override
            public void onFail(Object msg) {
                view.onFailBanner(msg);
            }

            @Override
            public void onSuccess(Object reg) {
                view.onSuccessBanner(reg);
            }
        });
    }
}
