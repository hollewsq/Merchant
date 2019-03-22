package com.example.a13621.merchant.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.adapter.SearchAdapter;
import com.example.a13621.merchant.contract.SearchContract;
import com.example.a13621.merchant.entity.SearchBean;
import com.example.a13621.merchant.presenter.SearchPresenter;
import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseMvpActivity<SearchContract.IModel, SearchContract.IPresenter> implements SearchContract.IView {

    @BindView(R.id.xv)
    XRecyclerView xv;
    private SearchAdapter searchAdapter;
    private HashMap<String, String> params;

    @Override
    protected int getResLayoutById() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        getSupportActionBar().hide();
        xv.setLayoutManager(new GridLayoutManager(this, 2));
        searchAdapter = new SearchAdapter(this);
        xv.setAdapter(searchAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        params = new HashMap<>();
        params.put("keyword", "卫衣");
        params.put("page", 1+"");
        params.put("count", 20+"");
        presenter.jumpSearch(params);
    }

    @Subscribe(sticky = true)
    public void Keyword(String name){
        params.put("keyword", name);
        presenter.jumpSearch(params);
    }

    @Override
    public BasePresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    public void onFailSearch(Object msg) {
        SearchBean searchBean = (SearchBean) msg;
        Toast.makeText(SearchActivity.this, searchBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessSearch(Object reg) {
        SearchBean searchBean = (SearchBean) reg;
        List<SearchBean.ResultBean> result = searchBean.getResult();
        searchAdapter.setResult(result);
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
