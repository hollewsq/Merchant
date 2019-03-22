package com.example.a13621.merchant.contract;

import com.example.a13621.merchant.model.HomeModel;
import com.example.a13621.merchant.net.PMCallback;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

public interface HomeContract {
    //V
    interface IView extends IBaseView {
        void onFailHome(Object msg);
        void onFailBanner(Object msg);
        void onSuccessHome(Object reg);
        void onSuccessBanner(Object reg);
    }
    //M
    interface IModel extends IBaseModel {
        void onModelHome(PMCallback pmCallback);
        void onModelBanner(PMCallback pmCallback);
    }
    //P
    abstract class IPresenter extends BasePresenter<IModel, IView> {
        @Override
        public IModel getModule() {
            return new HomeModel();
        }

        public abstract void jumpHome();
        public abstract void jumpBanner();
    }
}
