package com.example.administrator.mydairy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MySQHelper extends SQLiteOpenHelper {

    public MySQHelper(Context context){
        super(context,"my.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Dairy(id integer primary key autoincrement,title varchar(40),content varchar(800))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
