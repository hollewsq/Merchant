package com.example.a13621.merchant.contract;

import com.example.a13621.merchant.model.SearchModel;
import com.example.a13621.merchant.net.PMCallback;
import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;

import java.util.HashMap;

public interface SearchContract {
    //V
    interface IView extends IBaseView{
        void onFailSearch(Object msg);
        void onSuccessSearch(Object reg);
    }
    //M
    interface IModel extends IBaseModel{
        void onModel(HashMap<String, String> params, PMCallback pmCallback);
    }
    //P
    abstract class IPresenter extends BasePresenter<IModel, IView>{
        @Override
        public IModel getModule() {
            return new SearchModel();
        }

        public abstract void jumpSearch(HashMap<String, String> params);
    }
}
