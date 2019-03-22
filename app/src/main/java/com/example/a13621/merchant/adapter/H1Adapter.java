package com.example.a13621.merchant.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.activity.HeatActivity;
import com.example.a13621.merchant.entity.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class H1Adapter extends RecyclerView.Adapter<H1Adapter.RHodel> {
    private Context context;
    private HomeBean.ResultBean.RxxpBean rxxp;

    public H1Adapter(Context context, HomeBean.ResultBean.RxxpBean rxxp) {
        this.context = context;
        this.rxxp = rxxp;
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_h1, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, final int i) {
        rHodel.name1.setText(rxxp.getName());
        rHodel.classif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = rxxp.getId();
                Intent intent = new Intent(context, HeatActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

        //创建适配器
        H11Adapter h11Adapter = new H11Adapter(context);
        rHodel.rv1.setAdapter(h11Adapter);
        //设置recycleView 展示类型
        rHodel.rv1.setLayoutManager(new LinearLayoutManager(context, 0, false));
        //传递数据
        List<HomeBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxp.getCommodityList();
        h11Adapter.setCommodityList(commodityList);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class RHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.name1)
        TextView name1;
        @BindView(R.id.classif)
        ImageView classif;
        @BindView(R.id.rv1)
        RecyclerView rv1;
        public RHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
