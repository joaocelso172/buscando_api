package com.example.buscando_api.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.buscando_api.Fragment.HomeFragment;
import com.example.buscando_api.Fragment.InscFragment;
import com.example.buscando_api.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class abas extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout STL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abas);

        viewPager = findViewById(R.id.viewpager);
        STL = findViewById(R.id.viewpagertab);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Inscriçoes", InscFragment.class)
                        .create()
        );

        viewPager.setAdapter( adapter );
        STL.setViewPager(viewPager);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Teste");
    }
}
