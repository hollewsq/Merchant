package com.example.a13621.merchant.contract;

import com.example.a13621.merchant.model.ClassIfModel;
import com.example.a13621.merchant.net.PMCallback;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.HashMap;

public interface ClassIfContract {
    //V
    interface IView extends IBaseView{
        void onFailClass(Object msg);
        void onSuccessClass(Object reg);
    }
    //M
    interface IModel extends IBaseModel{
        void onModel(HashMap<String, String> params, PMCallback pmCallback);
    }
    //P
    abstract class IPresenter extends BasePresenter<IModel, IView>{
        @Override
        public IModel getModule() {
            return new ClassIfModel();
        }

        public abstract void jumpClass(HashMap<String, String> params);
    }
}
