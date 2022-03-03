package com.example.news;
/*  -> First I have created a splash screen
    ->Then I have used TabLayout in main xml file to create options for different fragments
    ->Then I have created layout resource file for the individual sections and used recycle view in them
    ->Then I have created JAVA class for the fragments
    ->Then I have created a pager Class or Model adapter to handle these fragments (JAVA Class)
*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,mscience,msports,mtech,mentertainment,mhealth,mbusiness;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String API_KEY="6c76309661e948fe848a707205125f19";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome=findViewById(R.id.home);
        mscience=findViewById(R.id.science);
        msports=findViewById(R.id.sports);
        mtech=findViewById(R.id.technology);
        mentertainment=findViewById(R.id.entertainment);
        mhealth=findViewById(R.id.health);
        mbusiness=findViewById(R.id.business);
        ViewPager viewPager= findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0 ||tab.getPosition()==1 ||tab.getPosition()==2 ||tab.getPosition()==3 ||tab.getPosition()==4 ||tab.getPosition()==5 ||tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

   }
}