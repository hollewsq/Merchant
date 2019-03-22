package com.example.a13621.merchant.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.a13621.merchant.R;
import com.example.a13621.merchant.fragment.CircleFragment;
import com.example.a13621.merchant.fragment.HomeFragment;
import com.example.a13621.merchant.fragment.MyFragment;
import com.example.a13621.merchant.fragment.OrderFragment;
import com.example.a13621.merchant.fragment.ShoppingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class

MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.Circle:
                    pager.setCurrentItem(1);
                    return true;
                case R.id.Cart:
                    pager.setCurrentItem(2);
                    return true;
                case R.id.Order:
                    pager.setCurrentItem(3);
                    return true;
                case R.id.My:
                    pager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new HomeFragment();
                    case 1:
                        return new CircleFragment();
                    case 2:
                        return new ShoppingFragment();
                    case 3:
                        return new OrderFragment();
                    case 4:
                        return new MyFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.Home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.Circle);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.Cart);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.Order);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.My);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
