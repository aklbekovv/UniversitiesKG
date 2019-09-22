package com.flaterlab.uskg.data;

import androidx.lifecycle.LiveData;

import com.flaterlab.uskg.models.University;

import java.util.List;

public class UniversityRepository {
    private static UniversityRepository instance;

    public static UniversityRepository getInstance(UniversityDao universityDao) {
        if (instance == null) {
            instance = new UniversityRepository(universityDao);
        }
        return instance;
    }

    private UniversityDao universityDao;

    private UniversityRepository(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    public LiveData<List<University>> getUniversities() {
        return universityDao.getAll();
    }

    public LiveData<University> getUniversityById(int id) {
        return universityDao.getUniversityById(id);
    }
}
