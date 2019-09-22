package com.flaterlab.uskg.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.flaterlab.uskg.data.UniversityRepository;
import com.flaterlab.uskg.models.University;
import com.flaterlab.uskg.util.BaseViewModel;

import java.util.List;

public class UniversityListViewModel extends BaseViewModel {
    private UniversityRepository universityRepo;
    private MutableLiveData<University> currentUniversity = new MutableLiveData<>();

    UniversityListViewModel(UniversityRepository universityRepo) {
        this.universityRepo = universityRepo;
    }

    public LiveData<List<University>> getUniversities() {
        return universityRepo.getUniversities();
    }

    public LiveData<University> getUniversityById(int id) {
        return universityRepo.getUniversityById(id);
    }

    public void setCurrentUniversity(University university) {
        currentUniversity.setValue(university);
    }

    public LiveData<University> getCurrentUniversity() {
        return currentUniversity;
    }
}
