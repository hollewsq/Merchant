package com.example.a13621.merchant.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a13621.merchant.R;
import com.example.a13621.merchant.adapter.HomeAdapter;
import com.example.a13621.merchant.contract.HomeContract;
import com.example.a13621.merchant.entity.BannerBean;
import com.example.a13621.merchant.entity.HomeBean;
import com.example.a13621.merchant.myview.Search1View;
import com.example.a13621.merchant.presenter.HomePresenter;
import com.example.lib_core.base.mvp.BaseMvpFragment;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends BaseMvpFragment<HomeContract.IModel, HomeContract.IPresenter> implements HomeContract.IView {

    @BindView(R.id.sear)
    Search1View search1;
    @BindView(R.id.xrv)
    XRecyclerView xrv;
    private HomeBean.ResultBean result = new HomeBean.ResultBean();
    private HomeAdapter homeAdapter;
    private XBanner xb;

    @Override
    protected int getResLayoutById() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initData() {
        super.initData();
        presenter.jumpHome();
        presenter.jumpBanner();
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(getActivity());
        View banner = LayoutInflater.from(getActivity()).inflate(R.layout.banner, null);
        xb = banner.findViewById(R.id.xb);
        xrv.addHeaderView(banner);

        xrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xrv.loadMoreComplete();
            }
        });

        xrv.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    }

    @Override
    public BasePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onFailHome(Object msg) {
        HomeBean home = (HomeBean) msg;
        Toast.makeText(getActivity(), home.getMessage() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailBanner(Object msg) {
        BannerBean bannerBean = (BannerBean) msg;
        Toast.makeText(getActivity(), bannerBean.getMessage() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessHome(Object reg) {
        HomeBean home = (HomeBean) reg;
        result = home.getResult();
        //创建适配器
        homeAdapter = new HomeAdapter(getActivity(), result);
        xrv.setAdapter(homeAdapter);
    }

    @Override
    public void onSuccessBanner(Object reg) {
        BannerBean bannerBean = (BannerBean) reg;
        final List<BannerBean.ResultBean> result = bannerBean.getResult();
        xb.setData(result, null);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView) view);
            }
        });

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
