package com.example.a13621.merchant.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.activity.DetailsActivity;
import com.example.a13621.merchant.entity.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class H33Adapter extends RecyclerView.Adapter<H33Adapter.RHodel> {
    private Context context;
    private List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityList;

    public H33Adapter(Context context) {
        this.context = context;
        this.commodityList = new ArrayList<>();
    }

    public void setCommodityList(List<HomeBean.ResultBean.PzshBean.CommodityListBeanX> commodityList) {
        if (commodityList != null) {
            this.commodityList.addAll(commodityList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_h33, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, int i) {
        final HomeBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = commodityList.get(i);
        rHodel.phone.setText(commodityListBeanX.getCommodityName());
        rHodel.money.setText(commodityListBeanX.getPrice());

        Uri uri = Uri.parse(commodityListBeanX.getMasterPic());
        rHodel.img.setImageURI(uri);

        rHodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("commodityId", commodityListBeanX.getCommodityId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class RHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        SimpleDraweeView img;
        @BindView(R.id.phone)
        TextView phone;
        @BindView(R.id.money)
        TextView money;
        public RHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
