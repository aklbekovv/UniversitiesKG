package com.flaterlab.uskg.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.data.UniversityRepository;

public class UniversityListViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private UniversityRepository universityRepository;

    public UniversityListViewModelFactory(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (modelClass.cast(new UniversityListViewModel(universityRepository)));
    }
}