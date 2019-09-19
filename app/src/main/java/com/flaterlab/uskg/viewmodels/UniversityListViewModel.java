package com.flaterlab.uskg.viewmodels;

import androidx.lifecycle.LiveData;

import com.flaterlab.uskg.data.UniversityRepository;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.util.BaseViewModel;

import java.util.List;

public class UniversityListViewModel extends BaseViewModel {
    private UniversityRepository universityRepo;

    UniversityListViewModel(UniversityRepository universityRepo) {
        this.universityRepo = universityRepo;
    }

    public LiveData<List<University>> getUinversites() {
        return universityRepo.getUniversities();
    }
}
