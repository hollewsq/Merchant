package com.example.a13621.merchant.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.adapter.ClassIfAdapter;
import com.example.a13621.merchant.contract.ClassIfContract;
import com.example.a13621.merchant.entity.ClassIfBean;
import com.example.a13621.merchant.presenter.ClassIfPresenter;
import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FashionActivity extends BaseMvpActivity<ClassIfContract.IModel, ClassIfContract.IPresenter> implements ClassIfContract.IView {

    @BindView(R.id.name1)
    TextView name1;
    @BindView(R.id.rv)
    RecyclerView rv;
    private HashMap<String, String> params;

    @Override
    protected int getResLayoutById() {
        return R.layout.activity_fashion;
    }

    @Override
    protected void initView() {
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        name1.setText("魔力时尚");
    }

    @Override
    protected void initData() {
        super.initData();
        params = new HashMap<>();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        params.put("labelId", id);
        params.put("page", 1 + "");
        params.put("count", 20 + "");
        presenter.jumpClass(params);
    }

    @Override
    public void onFailClass(Object msg) {
        ClassIfBean classIfBean = (ClassIfBean) msg;
        Toast.makeText(this, classIfBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessClass(Object reg) {
        ClassIfBean classIfBean = (ClassIfBean) reg;
        List<ClassIfBean.ResultBean> result = classIfBean.getResult();
        ClassIfAdapter classIfAdapter = new ClassIfAdapter(this, result);
        rv.setAdapter(classIfAdapter);
    }

    @Override
    public BasePresenter initPresenter() {
        return new ClassIfPresenter();
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
}
