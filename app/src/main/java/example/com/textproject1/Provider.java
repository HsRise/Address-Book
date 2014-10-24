package example.com.textproject1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class Provider extends ContentProvider{
    @Override
    public boolean onCreate(){
        return true;
    }
    @Override
    public String getType(Uri uri){
        return null;
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String where, String[] whereArgs, String sortOrder){
        return null;
    }
    @Override
    public Uri insert(Uri uri, ContentValues valus){
        return null;
    }
    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs){
        return 0;
    }
    @Override
    public int delete(Uri uri, String where, String[] whereArgs){
        return 0;
    }
}