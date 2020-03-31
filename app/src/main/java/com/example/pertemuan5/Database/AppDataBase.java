package com.example.pertemuan5.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataDiri.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase
{
    public abstract DataDiriDAO dao();
    private static  AppDataBase appDataBase;

    public static AppDataBase initDb(Context context)
    {
        if(appDataBase == null)
            appDataBase= Room.databaseBuilder(context, AppDataBase.class, "datadiri_db").allowMainThreadQueries().build();
        return appDataBase;
    }

    public static void destroyInstance(){appDataBase=null;}
}
