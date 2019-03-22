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
import retrofit2.http.Url;

public class H22Adapter extends RecyclerView.Adapter<H22Adapter.RHodel> {
    private Context context;
    private List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList;

    public H22Adapter(Context context) {
        this.context = context;
        this.commodityList = new ArrayList<>();
    }

    public void setCommodityList(List<HomeBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList) {
        if (commodityList != null) {
            this.commodityList.addAll(commodityList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_h22, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, int i) {
        final HomeBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = commodityList.get(i);
        rHodel.introduce.setText(commodityListBeanXX.getCommodityName());
        rHodel.price.setText(commodityListBeanXX.getPrice());

        Uri uri = Uri.parse(commodityListBeanXX.getMasterPic());
        rHodel.img.setImageURI(uri);

        rHodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("commodityId", commodityListBeanXX.getCommodityId());
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
        @BindView(R.id.introduce)
        TextView introduce;
        @BindView(R.id.price)
        TextView price;
        public RHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
