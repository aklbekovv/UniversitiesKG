package com.flaterlab.uskg.screens.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;

public class ContactsFragment extends Fragment {
    private UniversityListViewModel viewModel;
    private University university;
    private TextView tvCity, tvAddress, tvWebsite, tvEmail, tvPhoneNumber;

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

        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCity = view.findViewById(R.id.tv_city);
        tvAddress = view.findViewById(R.id.tv_address);
        tvWebsite = view.findViewById(R.id.tv_website);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPhoneNumber = view.findViewById(R.id.tv_phone_number);

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
        tvCity.setText(university.getCity());
        tvAddress.setText(university.getAddress());

        initWebsite();
        initEmail();
        initPhoneNumber();
    }

    private void initWebsite() {
        tvWebsite.setText(university.getContacts().getWebsite());
    }

    private void initEmail() {
        tvEmail.setText(university.getContacts().getEmail());
    }

    private void initPhoneNumber() {
        tvPhoneNumber.setText(university.getContacts().getPhoneNumber());
    }
}
