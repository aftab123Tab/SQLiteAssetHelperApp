package com.example.sqliteassethelperapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class MyDbclass extends SQLiteAssetHelper {
    private static final String DATABASE_NAME="sunsetApp.db";
    private static final int DATABASE_VERSION=1;
    Context context;
    public MyDbclass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    //Matching Cunstructur
    public ArrayList<DbModelClass>  getAllData()
    {
        try {
            ArrayList<DbModelClass> objectdbModelClassArrayList= new ArrayList<>();
            SQLiteDatabase objectSQLiteDatabase =getReadableDatabase();
            if(objectSQLiteDatabase!=null)
            {
Cursor  objectCursor= objectSQLiteDatabase.rawQuery("select * from sunsetdata",null);
if(objectCursor.getCount()!=0)
{while (objectCursor.moveToNext())
{
String imageDes=objectCursor.getString(0);
byte[] imagesByte=objectCursor.getBlob(1);
    Bitmap ourImage= BitmapFactory.decodeByteArray(imagesByte,0,imagesByte.length);
    objectdbModelClassArrayList.add(
            new DbModelClass(
                    imageDes,ourImage
            )
    );
}
return objectdbModelClassArrayList;

}else
{
    Toast.makeText(context,"NO Data Retrived",Toast.LENGTH_SHORT).show();
    return null;
}
            }else
            {
                Toast.makeText(context,"Data Base Null",Toast.LENGTH_SHORT).show();
                return null;
            }

            }catch (Exception e)
        {
            Toast.makeText(context,"getAllData:-"+e.getMessage(),Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
