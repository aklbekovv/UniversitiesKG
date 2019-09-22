package com.flaterlab.uskg.screens.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.data.AppDatabase;
import com.flaterlab.uskg.util.BaseActivity;
import com.flaterlab.uskg.util.ViewPagerAdapter;
import com.flaterlab.uskg.views.NonSwipeableViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    private NonSwipeableViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
        initBottomNavigation();

        AppDatabase.getInstance(this).getUniversitiesDao().getAll().observe(this, us -> {
            if (us != null) {
                log(us.toString());
            }
        });
    }

    private void initViewPager() {
        viewPager = findViewById(R.id.view_pager);
        Fragment[] fragments = {
                new HomeFragment(),
                new RankingFragment(),
                new AboutFragment()
        };
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                fragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    private void initBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int currentItemPosition = 0;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_favorites:
                currentItemPosition = 1;
                break;
            case R.id.nav_search:
                currentItemPosition = 2;
                break;
        }
        viewPager.setCurrentItem(currentItemPosition);
        return true;
    }
}