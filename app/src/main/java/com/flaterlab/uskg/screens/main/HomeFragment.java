package com.flaterlab.uskg.screens.main;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.screens.main.adapters.UniversitiesRVAdapter;
import com.flaterlab.uskg.util.BaseFragment;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;
public class HomeFragment extends BaseFragment {
    private UniversitiesRVAdapter adapter;
    private UniversityListViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }
    private void initViewModel() {
        viewModel = new ViewModelProvider(
                requireActivity(),
                InjectorUtils.getInstance().provideUniversityListViewModelFactory(requireContext())
        ).get(UniversityListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvUniversities = view.findViewById(R.id.rv_universities);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        rvUniversities.setLayoutManager(layoutManager);
        rvUniversities.setHasFixedSize(true);

        adapter = new UniversitiesRVAdapter();
        rvUniversities.setAdapter(adapter);

        initObservers();
    }
    private void initObservers() {
        viewModel.getUniversities().observe(this, universities -> {
            if (universities != null) {
                adapter.updateUniversities(universities, false);
            }
        });
    }
}






