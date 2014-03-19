package com.example.listviewanddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseOpenHelper {
	private static final String TAG = MyDatabaseOpenHelper.class
			.getSimpleName();

	private static final int VERSION = 1;
	private static final String DATABASE_NAME = "mydatabase";

	private static final String TABLE_NAME = "task_table"; // Table name
	private static final String COLUMN_ID = "_id"; // a column named "_id" is
													// required for cursor
	private static final String COLUMN_NAME = "Name";
	private static final String COLUMN_TIME = "Time";
	private static final String COLUMN_NUM = "Number";

	private DatabaseOpenHelper openHelper;
	private SQLiteDatabase database;

	public MyDatabaseOpenHelper(Context aContext) {

		openHelper = new DatabaseOpenHelper(aContext);
		database = openHelper.getWritableDatabase();
	}

	public void insertData(String name, String time, String num) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_NAME, name);
		cv.put(COLUMN_TIME, time);
		cv.put(COLUMN_NUM, num);
		database.insert(TABLE_NAME, null, cv);
	}

	private class DatabaseOpenHelper extends SQLiteOpenHelper {
		Context context;
		public DatabaseOpenHelper(Context aContext) {
			super(aContext, DATABASE_NAME, null, VERSION);
			context = aContext;
			Message.message(context, "constructor was called");
		}

		@Override
		public void onCreate(SQLiteDatabase sqLiteDatabase) {
			// Create your tables here

			String buildSQL = "CREATE TABLE " + TABLE_NAME + "( " + COLUMN_ID
					+ " INTEGER PRIMARY KEY, " + COLUMN_NAME + " TEXT, "
					+ COLUMN_TIME + " TEXT, " + COLUMN_NUM + " text )";

			Log.d(TAG, "onCreate SQL: " + buildSQL);

			sqLiteDatabase.execSQL(buildSQL);
			Message.message(context, "onCreate was called");
		}

		@Override
		public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion,
				int newVersion) {
			// Database schema upgrade code goes here

			String buildSQL = "DROP TABLE IF EXISTS " + TABLE_NAME;

			Log.d(TAG, "onUpgrade SQL: " + buildSQL);

			sqLiteDatabase.execSQL(buildSQL); // drop previous table

			onCreate(sqLiteDatabase); // create the table from the beginning
			Message.message(context, "onUpgrad was called");
		}
	}

	public Cursor getAllData() {
		String buildSQL = "SELECT * FROM " + TABLE_NAME;

		Log.d(TAG, "getAllData SQL: " + buildSQL);

		return database.rawQuery(buildSQL, null);
	}

}
