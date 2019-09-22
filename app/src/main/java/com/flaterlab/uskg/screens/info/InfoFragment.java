package com.flaterlab.uskg.screens.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.Major;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.util.BaseFragment;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;
import com.flaterlab.uskg.views.MajorView;

import java.util.List;

public class InfoFragment extends BaseFragment {
    private UniversityListViewModel viewModel;
    private University university;
    private LinearLayout container;
    private TextView tvTeachers, tvStudents, tvDescription, tvEntranceInfo;

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

        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = view.findViewById(R.id.info_container);
        tvTeachers = view.findViewById(R.id.tv_teachers);
        tvStudents = view.findViewById(R.id.tv_students);
        tvDescription = view.findViewById(R.id.tv_description);
        tvEntranceInfo = view.findViewById(R.id.tv_entrance_info);

        observeUniversity();
    }

    private void observeUniversity() {
        viewModel.getCurrentUniversity().observe(this, university -> {
            if (university != null) {
                this.university = university;
                updateUi();
            }
        });
    }

    private void updateUi() {
        tvTeachers.setText(String.valueOf(university.getTeachers()));
        tvStudents.setText(String.valueOf(university.getStudents()));
        tvDescription.setText(university.getDescription());
        tvEntranceInfo.setText(university.getEntranceInfo());

        initMajors();
    }

    private void initMajors() {
        List<Major> majors = university.getMostPopularMajors();
        log("Majors: " + majors);

        for (Major major : majors) {
            MajorView majorView = new MajorView(requireContext());
            majorView.setName(String.format(getString(R.string.info_major_list), major.getName()));
            String price = major.getLowestFee() == major.getHighestFee() ?
                    major.getLowestFee() + "" :
                    major.getLowestFee() + "-" + major.getHighestFee();
            String fee = price + " " +
                    major.getCurrency();
            majorView.setFee(fee);

            container.addView(majorView);
        }
    }
}
