package com.example.listviewanddatabase;

import com.example.listviewanddatabase.R;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	public static MyCursorAdapter myCA;
	public static MyDatabaseOpenHelper myDBOHelper;
	private static final int ENTER_DATA_REQUEST_CODE = 1;
	private ListView listView;

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myDBOHelper = new MyDatabaseOpenHelper(this);

		listView= (ListView) findViewById(R.id.list_tasks);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Log.d(TAG, "clicked on item: " + position);
				
			}

		});
		new Handler().post(new Runnable() {
			@Override
			public void run() {
				myCA = new MyCursorAdapter(MainActivity.this, myDBOHelper
						.getAllData());
				listView.setAdapter(myCA);
			}
		});
	}

	public void onClickEnterData(View btnAdd) {

		startActivity(new Intent(MainActivity.this, EnterDataActivity.class));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		
	}

	

}
