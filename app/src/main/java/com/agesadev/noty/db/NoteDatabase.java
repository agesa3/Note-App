package com.agesadev.noty.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.agesadev.noty.Repository.NoteDao;
import com.agesadev.noty.utils.Constants;

public abstract class NoteDatabase extends RoomDatabase {

    public  abstract NoteDao getNoteDao();
    public static NoteDatabase noteDatabase;

    public static NoteDatabase getInstance(Context context){
        if(null==noteDatabase){
            noteDatabase=buildDatabaseInstance(context);
        }
        return noteDatabase;
    }

    private static NoteDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context,NoteDatabase.class,
                Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDatabase=null;
    }

}
