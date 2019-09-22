package com.flaterlab.uskg.screens.info;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.util.BaseActivity;
import com.flaterlab.uskg.util.CommonUtils;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.Objects;

public class InfoActivity extends BaseActivity {

    public static final String UNIVERSITY_ID = "com.flaterlab.university";
    private final Fragment[] fragments = {
            new InfoFragment(),
            new ContactsFragment()
    };
    private UniversityListViewModel viewModel;
    private University currentUniversity;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private NestedScrollView nestedScrollView;
    private ImageView ivIcon;
    private TextView tvTitle, tvSchoolType, tvFounded;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initViewModel();
        initViews();
        initTabLayout();
        initTabLayoutSelection();

        int universityId = getIntent().getIntExtra(UNIVERSITY_ID, -1);

        if (universityId != -1) {
            observeUniversity(universityId);
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_container, fragments[0])
                    .commit();
        }
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(
                this,
                InjectorUtils.getInstance().provideUniversityListViewModelFactory(this)
        ).get(UniversityListViewModel.class);
    }

    private void initViews() {
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(" ");
        nestedScrollView = findViewById(R.id.nested_scroll_view);

        ivIcon = findViewById(R.id.iv_icon);
        tvTitle = findViewById(R.id.tv_title);
        tvSchoolType = findViewById(R.id.tv_school_type);
        tvFounded = findViewById(R.id.tv_founded_in);
    }

    private void observeUniversity(int universityId) {
        viewModel.getUniversityById(universityId).observe(this, university -> {
            if (university != null) {
                currentUniversity = university;
                viewModel.setCurrentUniversity(currentUniversity);
                updateUi();
            }
        });
    }

    private void updateUi() {
        initAppBarLayout();
        tvTitle.setText(currentUniversity.getName());
        tvSchoolType.setText(currentUniversity.getSchoolType());
        tvFounded.setText(currentUniversity.getFounded());

        try {
            ivIcon.setImageDrawable(CommonUtils.getIcon(this, currentUniversity.getIconPath()));
        } catch (IOException ignored) {
        }
    }

    private void initAppBarLayout() {
        appBarLayout = findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset <= 20) {
                    tvTitle.setText(" ");
                }
                if (scrollRange + verticalOffset <= 30) {
                    collapsingToolbarLayout.setTitle(currentUniversity.getAbbreviation());
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    tvTitle.setText(currentUniversity.getName());
                    isShow = false;
                }
            }
        });
    }

    private void initTabLayout() {
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_info));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_contacts));
    }

    private void initTabLayoutSelection() {

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_container, fragments[tab.getPosition()])
                        .commit();

//                setAppBarLayoutEnabled(tab.getPosition() != 1);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setAppBarLayoutEnabled(boolean enabled) {
        if (!enabled) {
            appBarLayout.setExpanded(false, true);
        }

        ViewCompat.setNestedScrollingEnabled(nestedScrollView, enabled);
        CoordinatorLayout.LayoutParams params =
                (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        if (params.getBehavior() == null) {
            params.setBehavior(new AppBarLayout.Behavior());
        }

        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return enabled;
            }
        });
    }
}
