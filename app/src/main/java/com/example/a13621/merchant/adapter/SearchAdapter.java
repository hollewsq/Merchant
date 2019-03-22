package com.example.a13621.merchant.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.entity.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends XRecyclerView.Adapter<SearchAdapter.XHodel> {
    private Context context;
    private List<SearchBean.ResultBean> result;

    public SearchAdapter(Context context) {
        this.context = context;
        this.result = new ArrayList<>();
    }

    public void setResult(List<SearchBean.ResultBean> result) {
        this.result.clear();
        if (result != null) {
            this.result.addAll(result);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XHodel onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_search, viewGroup, false);
        XHodel xHodel = new XHodel(view);
        return xHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull XHodel xHodel, int i) {
        SearchBean.ResultBean resultBean = result.get(i);
        xHodel.name.setText(resultBean.getCommodityName());
        xHodel.price.setText("￥"+resultBean.getPrice());
        xHodel.num.setText("已售"+resultBean.getSaleNum()+"件");
        Uri parse = Uri.parse(resultBean.getMasterPic());
        xHodel.img.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class XHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        SimpleDraweeView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.num)
        TextView num;
        public XHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
