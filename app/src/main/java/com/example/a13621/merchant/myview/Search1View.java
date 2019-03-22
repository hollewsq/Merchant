package com.example.a13621.merchant.myview;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.activity.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Search1View extends ConstraintLayout {

    public SearchCallback searchCallback;

    public void setSearchListener(SearchCallback searchCallback) {
        this.searchCallback = searchCallback;
    }

    public Search1View(Context context) {
        this(context, null);
    }

    public Search1View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Search1View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        final View view = LayoutInflater.from(context).inflate(R.layout.search, this, true);
        ImageView ifclass = view.findViewById(R.id.ifclass);
        final EditText search = view.findViewById(R.id.search);
        ImageView seek = view.findViewById(R.id.seek);

        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = search.getText().toString();
                if (name.equals("")){
                    Intent intent = new Intent(context, SearchActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        /*seek.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = search.getText().toString();
                if (!name.equals("")){
                    Intent intent = new Intent(context, SearchActivity.class);
                    intent.putExtra("name", name);
                    context.startActivity(intent);
                }else {
                    Toast.makeText(context, "搜索框不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    /**
     * 自定义接口
     */
    public interface SearchCallback{
        void onSearch(String name);
    }
}
