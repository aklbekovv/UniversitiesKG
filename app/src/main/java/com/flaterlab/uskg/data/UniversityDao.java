package com.flaterlab.uskg.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.flaterlab.uskg.models.University;

import java.util.List;

@Dao
public interface UniversityDao {

    @Query("SELECT * FROM universities")
    LiveData<List<University>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<University> universities);
}
