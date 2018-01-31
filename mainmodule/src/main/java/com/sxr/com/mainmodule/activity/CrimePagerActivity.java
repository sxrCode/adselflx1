package com.sxr.com.mainmodule.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.fragment.CrimentFragment;
import com.sxr.com.mainmodule.model.Crime;

import java.util.ArrayList;
import java.util.List;


public class CrimePagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private List<Crime> mCrimes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        initData();
        initWidget();
    }

    private void initData() {
        mCrimes = new ArrayList<>();
        mCrimes.add(new Crime("des1", "1"));
        mCrimes.add(new Crime("des2", "2"));
        mCrimes.add(new Crime("des3", "3"));
        mCrimes.add(new Crime("des4", "4"));
    }

    private void initWidget() {
        mViewPager = findViewById(R.id.viewpager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return CrimentFragment.newInstanse(mCrimes.get(position));
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mCrimes.get(position).getDescribe();
            }
        });
        mViewPager.setCurrentItem(2);
        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabTextColors(getResources().getColor(android.R.color.black), getResources().getColor(android.R.color.holo_blue_dark));
    }
}
