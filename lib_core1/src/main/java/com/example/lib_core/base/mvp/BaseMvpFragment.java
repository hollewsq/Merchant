package com.example.lib_core.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lib_core.base.BaseAcivity;
import com.example.lib_core.base.BaseFragment;

public abstract class BaseMvpFragment<M extends IBaseModel,P extends BasePresenter> extends BaseFragment implements IBaseView {

    public M modle;
    public P presenter;


    @Override
    protected void initData() {
        presenter = (P) initPresenter();

        if (presenter != null) {
            modle = (M) presenter.getModule();
            if (modle != null) {
                //绑定
                presenter.attach(modle,this);
            }
        }
        init();

    }

    protected abstract void init();
    @Override
    public void onDestroy() {
        super.onDestroy();
        //解绑
        if (presenter != null) {
            presenter.dettach();
        }
    }

    /*private boolean isViewCreated; // 界面是否已创建完成
    private boolean isVisibleToUser; // 是否对用户可见
    private boolean isDataLoaded; // 数据是否已请求

    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewCreated = true;
    }

    public void tryLoadData(){
        if (isVisibleToUser && isViewCreated && isDataLoaded){
            loadData();
            isDataLoaded = true;
        }
    }
*/
}
