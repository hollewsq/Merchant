package com.example.a13621.merchant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.contract.DetailsContract;
import com.example.a13621.merchant.entity.DetailsBean;
import com.example.a13621.merchant.presenter.DetailsPresenter;
import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseMvpActivity<DetailsContract.IModel, DetailsContract.IPresenter> implements DetailsContract.IView {

    @Override
    protected int getResLayoutById() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        super.initData();
        HashMap<String, String> params = new HashMap<>();
        Intent intent = getIntent();
        String commodityId = intent.getStringExtra("commodityId");
        params.put("commodityId", commodityId);
        presenter.jumpClass(params);
    }

    @Override
    public BasePresenter initPresenter() {
        return new DetailsPresenter();
    }

    @Override
    public void onFailDetails(Object msg) {
        DetailsBean detailsBean = (DetailsBean) msg;
        Toast.makeText(this, detailsBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessDetails(Object reg) {
        DetailsBean detailsBean = (DetailsBean) reg;
        Toast.makeText(this, detailsBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideLoding() {

    }

    @Override
    public void failLoding(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
