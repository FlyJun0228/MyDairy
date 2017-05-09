package com.example.administrator.mydairy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class DairyDao {

    private MySQHelper sqHelper;
    public Long Check;
    private int sum;
    public List<Bean> data;
    private Bean bean;

    public DairyDao(Context context){
        sqHelper = new MySQHelper(context);
    }
    public void Add(String title,String content){
        SQLiteDatabase sqLiteDatabase = sqHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("content",content);
        Check = sqLiteDatabase.insert("Dairy",null,contentValues);
        sqLiteDatabase.close();
    }
    public void Query(){
        data = new ArrayList<Bean>();
        SQLiteDatabase sqLiteDatabase = sqHelper.getReadableDatabase();
        String sql = "select Count(*) from Dairy";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();
        sum = cursor.getInt(0);
        String title = null;
        String content = null;
        String sqll = "select* from Dairy";
        Cursor cursor1 = sqLiteDatabase.rawQuery(sqll,null);
        for (int i = 1;i<= sum;i++) {
            if (cursor1.moveToNext()) {
                title = cursor1.getString(cursor1.getColumnIndex("title"));
                content = cursor1.getString(cursor1.getColumnIndex("content"));
                bean = new Bean(title,content);
                data.add(bean);
            }
        }
    }
}
