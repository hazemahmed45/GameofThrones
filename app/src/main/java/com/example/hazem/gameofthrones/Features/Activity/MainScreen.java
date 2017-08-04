package com.example.hazem.gameofthrones.Features.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Features.Adapters.GOTViewPagerAdapter;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.StringUtil;

public class MainScreen extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    GOTViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        SettingIDs();
        SettingViews();
    }
    void SettingIDs()
    {
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
    }
    void SettingViews()
    {
        adapter=new GOTViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                    {
                        MainScreen.this.getSupportActionBar().setTitle("Character");
                    }
                    case 2:
                    {
                        MainScreen.this.getSupportActionBar().setTitle("Character");
                    }
                    case 1:
                    {
                        MainScreen.this.getSupportActionBar().setTitle("Character");
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
