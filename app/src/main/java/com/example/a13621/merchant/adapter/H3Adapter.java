package com.example.a13621.merchant.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.activity.QualityActivity;
import com.example.a13621.merchant.entity.HomeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class H3Adapter extends RecyclerView.Adapter<H3Adapter.RHodel> {
    private Context context;
    private HomeBean.ResultBean.PzshBean pzsh = new HomeBean.ResultBean.PzshBean();

    public H3Adapter(Context context, HomeBean.ResultBean.PzshBean pzsh) {
        this.context = context;
        this.pzsh = pzsh;
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_h3, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, int i) {
        rHodel.name1.setText(pzsh.getName());

        rHodel.classif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = pzsh.getId();
                Intent intent = new Intent(context, QualityActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        });

        //设置适配器
        H33Adapter h33Adapter = new H33Adapter(context);
        rHodel.rv1.setAdapter(h33Adapter);
        //设置RecyclerView 展示类型
        rHodel.rv1.setLayoutManager(new GridLayoutManager(context, 2));
        //传递参数
        List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzsh.getCommodityList();
        h33Adapter.setCommodityList(commodityList);
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