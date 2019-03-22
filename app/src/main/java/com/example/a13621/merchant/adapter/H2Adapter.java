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
import com.example.a13621.merchant.activity.FashionActivity;
import com.example.a13621.merchant.entity.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class H2Adapter extends RecyclerView.Adapter<H2Adapter.RHodel> {
    private Context context;
    private HomeBean.ResultBean.MlssBean mlss = new HomeBean.ResultBean.MlssBean();

    public H2Adapter(Context context, HomeBean.ResultBean.MlssBean mlss) {
        this.context = context;
        this.mlss = mlss;
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_h2, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, int i) {
        rHodel.name1.setText(mlss.getName());

        rHodel.classif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = mlss.getId();
                Intent intent = new Intent(context, FashionActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

        //创建适配器
        H22Adapter h22Adapter = new H22Adapter(context);
        rHodel.rv1.setAdapter(h22Adapter);
        //设置recycleView 展示类型
        rHodel.rv1.setLayoutManager(new LinearLayoutManager(context, 1, false));
        //传递数据
        List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlss.getCommodityList();
        h22Adapter.setCommodityList(commodityList);
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
