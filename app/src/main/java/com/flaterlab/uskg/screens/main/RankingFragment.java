package com.flaterlab.uskg.screens.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.util.BaseFragment;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;


public class RankingFragment extends BaseFragment {
    private UniversityListViewModel viewModel;
    private ConstraintLayout rankGeneral, rankTechnical, rankMedical, rankLaw, rankHumanity;

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

        initOnClickListeners();
    }

    private void initOnClickListeners() {
        rankGeneral.setOnClickListener(view -> {
            showToast();
        });

        rankTechnical.setOnClickListener(view -> {
            showToast();
        });

        rankMedical.setOnClickListener(view -> {
            showToast();
        });

        rankLaw.setOnClickListener(view -> {
            showToast();
        });

        rankHumanity.setOnClickListener(view -> {
            showToast();
        });
    }

    private void showToast() {
        Toast.makeText(requireContext(), "Not implemented yet", Toast.LENGTH_SHORT).show();
    }
}