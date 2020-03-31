package com.example.pertemuan5.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insertData(DataDiri dataDiri);

    @Query("SELECT * FROM datadiri_db ")
    List<DataDiri> getData();

    @Update
    int updateData(DataDiri item);
    @Delete
    void deleteData (DataDiri item);
}
