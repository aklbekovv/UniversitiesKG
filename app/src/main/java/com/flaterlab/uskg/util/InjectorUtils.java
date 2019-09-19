package com.flaterlab.uskg.util;

import android.content.Context;

import com.flaterlab.uskg.data.AppDatabase;
import com.flaterlab.uskg.data.UniversityRepository;
import com.flaterlab.uskg.viewmodels.UniversityListViewModelFactory;

public class InjectorUtils {
    private static InjectorUtils instance;
    public static InjectorUtils getInstance() {
        if (instance == null) {
            instance = new InjectorUtils();
        }
        return instance;
    }

    private InjectorUtils() {
    }

    private UniversityRepository getUniversityRepository(Context context) {
        return UniversityRepository.getInstance(
                AppDatabase.getInstance(context.getApplicationContext()).getUniversitiesDao()
        );
    }

    public UniversityListViewModelFactory provideUniversityListViewModelFactory(Context context) {
        UniversityRepository repository = getUniversityRepository(context);
        return new UniversityListViewModelFactory(repository);
    }
}
