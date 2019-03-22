package com.example.a13621.merchant.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.entity.HomeBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends XRecyclerView.Adapter<HomeAdapter.XHodel> {

    private Context context;
    private HomeBean.ResultBean result = new HomeBean.ResultBean();

    public HomeAdapter(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public XHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_home, viewGroup, false);
        XHodel xHodel = new XHodel(view);
        return xHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull XHodel xHodel, int i) {
        if (i == 0) {
            xHodel.rv1.setLayoutManager(new LinearLayoutManager(context, 0, false));
            HomeBean.ResultBean.RxxpBean rxxp = result.getRxxp();
            H1Adapter h1Adapter = new H1Adapter(context, rxxp);
            xHodel.rv1.setAdapter(h1Adapter);

        } else if (i == 1) {
            xHodel.rv2.setLayoutManager(new LinearLayoutManager(context, 1, false));
            HomeBean.ResultBean.MlssBean mlss = result.getMlss();
            H2Adapter h2Adapter = new H2Adapter(context, mlss);
            xHodel.rv2.setAdapter(h2Adapter);
        } else if (i == 2) {
            xHodel.rv3.setLayoutManager(new LinearLayoutManager(context, 1, false));
            HomeBean.ResultBean.PzshBean pzsh = result.getPzsh();
            H3Adapter h3Adapter = new H3Adapter(context, pzsh);
            xHodel.rv3.setAdapter(h3Adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class XHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.rv1)
        RecyclerView rv1;
        @BindView(R.id.rv2)
        RecyclerView rv2;
        @BindView(R.id.rv3)
        RecyclerView rv3;

        public XHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
