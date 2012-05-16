package com.android.listdata.db;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ListDataDatabaseHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "NewListData";
	private static final int DATABASE_VERSION = 1;
	
	public ListDataDatabaseHelper(Activity context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE user (name TEXT PRIMARY KEY,"
					+ "age INTEGER );");
			db.execSQL("CREATE TABLE userInfo (name TEXT PRIMARY KEY,"+"emailId TEXT,"
					+ "age INTEGER,"+"gender TEXT);");					
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
