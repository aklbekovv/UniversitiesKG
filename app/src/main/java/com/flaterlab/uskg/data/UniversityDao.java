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

    @Query("SELECT * FROM universities WHERE id == :uId")
    LiveData<University> getUniversityById(int uId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<University> universities);
}
