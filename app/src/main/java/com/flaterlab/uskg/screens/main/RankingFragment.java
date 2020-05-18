package com.flaterlab.uskg.screens.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.Rating;
import com.flaterlab.uskg.screens.ranking.RankingActivity;
import com.flaterlab.uskg.util.BaseFragment;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;
public class RankingFragment extends BaseFragment {
    private UniversityListViewModel viewModel;
    private ConstraintLayout
            rankGeneral, rankTechnical, rankMedical,
            rankLaw, rankHumanity, rankBusiness;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(
                requireActivity(),
                InjectorUtils.getInstance().provideUniversityListViewModelFactory(requireContext())
        ).get(UniversityListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rankGeneral = view.findViewById(R.id.cl_rank_general);
        rankTechnical = view.findViewById(R.id.cl_rank_technical);
        rankMedical = view.findViewById(R.id.cl_rank_medical);
        rankLaw = view.findViewById(R.id.cl_rank_law);
        rankHumanity = view.findViewById(R.id.cl_rank_humanity);
        rankBusiness = view.findViewById(R.id.cl_rank_business);

        initOnClickListeners();
    }
    private void initOnClickListeners() {
        rankGeneral.setOnClickListener(view -> {
            startRanksActivity(Rating.GENERAL);
        });

        rankTechnical.setOnClickListener(view -> {
            startRanksActivity(Rating.TECHNICAL);
        });

        rankMedical.setOnClickListener(view -> {
            startRanksActivity(Rating.MEDICAL);
        });

        rankLaw.setOnClickListener(view -> {
            startRanksActivity(Rating.LAW);
        });

        rankHumanity.setOnClickListener(view -> {
            startRanksActivity(Rating.HUMANITY);
        });

        rankBusiness.setOnClickListener(view -> {
            startRanksActivity(Rating.BUSINESS);
        });
    }

    private void startRanksActivity(int rankingType) {
        Intent intent = new Intent(requireContext(), RankingActivity.class);
        intent.putExtra(RankingActivity.RANK_TYPE, rankingType);
        startActivity(intent);
    }
}