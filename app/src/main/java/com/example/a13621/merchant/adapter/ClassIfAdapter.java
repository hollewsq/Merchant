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
import com.example.a13621.merchant.entity.ClassIfBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassIfAdapter extends RecyclerView.Adapter<ClassIfAdapter.RHodel> {
    private Context context;
    private List<ClassIfBean.ResultBean> result;

    public ClassIfAdapter(Context context, List<ClassIfBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_class, viewGroup, false);
        RHodel rHodel = new RHodel(view);
        return rHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull RHodel rHodel, int i) {
        final ClassIfBean.ResultBean resultBean = result.get(i);
        rHodel.name.setText(resultBean.getCommodityName());
        rHodel.price.setText(resultBean.getPrice());
        rHodel.num.setText(resultBean.getSaleNum());
        Uri parse = Uri.parse(resultBean.getMasterPic());
        rHodel.img.setImageURI(parse);

        rHodel.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("commodityId", resultBean.getCommodityId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class RHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        SimpleDraweeView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.num)
        TextView num;
        public RHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
