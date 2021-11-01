package com.agesadev.noty.Repository;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.agesadev.noty.model.Note;
import com.agesadev.noty.utils.Constants;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM user "+ Constants.TABLE_NAME_NOTE)
    List<Note> getAll();

    @Insert
    void insert(Note note);


    @Update
    void update(Note repos);


    @Delete
    void delete(Note note);


    @Delete
    void delete(Note ...note);


    

}
