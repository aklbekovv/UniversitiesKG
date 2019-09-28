package com.flaterlab.uskg.screens.ranking;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.screens.main.adapters.UniversitiesRVAdapter;
import com.flaterlab.uskg.util.BaseActivity;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.flaterlab.uskg.models.Rating.BUSINESS;
import static com.flaterlab.uskg.models.Rating.GENERAL;
import static com.flaterlab.uskg.models.Rating.HUMANITY;
import static com.flaterlab.uskg.models.Rating.LAW;
import static com.flaterlab.uskg.models.Rating.MEDICAL;
import static com.flaterlab.uskg.models.Rating.TECHNICAL;

public class RankingActivity extends BaseActivity {
    public static final String RANK_TYPE = "com.flaterlab.uskg.rank_type";
    private UniversityListViewModel viewModel;
    private UniversitiesRVAdapter adapter;
    private List<University> universityList;
    private int rankType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankType = getIntent().getIntExtra(RANK_TYPE, GENERAL);

        initViewModel();
        initRecyclerView();
        observeUniversities();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this,
                InjectorUtils.getInstance().provideUniversityListViewModelFactory(this)
        ).get(UniversityListViewModel.class);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new UniversitiesRVAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void observeUniversities() {
        viewModel.getUniversities().observe(this, universities -> {
            if (universities != null) {
                universityList = universities;
                updateUi();
            }
        });
    }

    private void updateUi() {
        Collections.sort(universityList, getComparator());

        adapter.updateUniversities(universityList, true);
    }

    private Comparator<University> getComparator() {
        int rank = R.string.ranking_general;
        Comparator<University> comparator =
                (u1, u2) -> (int) (u2.getRating().getGeneral() - u1.getRating().getGeneral());

        switch (rankType) {
            case MEDICAL:
                rank = R.string.ranking_medical;
                comparator =
                        (u1, u2) -> (int) (u2.getRating().getMedical() - u1.getRating().getMedical());
                break;
            case TECHNICAL:
                rank = R.string.ranking_technical;
                comparator =
                        (u1, u2) -> (int) (u2.getRating().getTechnical() - u1.getRating().getTechnical());
                break;
            case HUMANITY:
                rank = R.string.ranking_humanity;
                comparator =
                        (u1, u2) -> (int) (u2.getRating().getHumanity() - u1.getRating().getHumanity());
                break;
            case LAW:
                rank = R.string.ranking_law;
                comparator =
                        (u1, u2) -> (int) (u2.getRating().getLaw() - u1.getRating().getLaw());
                break;
            case BUSINESS:
                rank = R.string.ranking_business;
                comparator =
                        (u1, u2) -> (int) (u2.getRating().getBusinessManagement() -
                                u1.getRating().getBusinessManagement());
        }

        setTitle(String.format(getString(R.string.rank_title), getString(rank)));
        return comparator;
    }
}
