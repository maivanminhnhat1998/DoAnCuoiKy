package com.example.doancuoiky;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.doancuoiky.Adapter.PagerStateAdapter;

public class ContactActiviti extends AppCompatActivity {
    TabLayout demo_mTabList;
    ViewPager demo_mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_activiti);


        onInit();
        demo_mTabList.setupWithViewPager(demo_mViewPager);
        PagerStateAdapter pagerStateAdapter = new PagerStateAdapter(getSupportFragmentManager());
        pagerStateAdapter.addFragment(new DanhSachSP(),"San Pham");
        pagerStateAdapter.addFragment(new DanhSachBan(),"Ban");
        demo_mViewPager.setAdapter(pagerStateAdapter);
    }

    private void onInit() {
        demo_mTabList = (TabLayout)findViewById(R.id.demo_mTabList);
        demo_mViewPager = (ViewPager)findViewById(R.id.demo_mViewPager);
    }
}
