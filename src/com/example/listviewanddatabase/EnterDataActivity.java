package com.example.listviewanddatabase;

import com.example.listviewanddatabase.R;

import android.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
 
public class EnterDataActivity extends Activity {
 
    EditText editTextName;
    EditText editTextTime;
    EditText editTextNum;
 
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
 
        editTextName = (EditText) findViewById(R.id.input_name);
        editTextTime = (EditText) findViewById(R.id.input_time);
        editTextNum = (EditText) findViewById(R.id.input_num);
    }
 
    public void onClickAdd (View btnAdd) {
 
        String name = editTextName.getText().toString();
        String time = editTextTime.getText().toString();
        String num = editTextNum.getText().toString();
 
        MainActivity.myDBOHelper.insertData(name, time, num);

        MainActivity.myCA.changeCursor(MainActivity.myDBOHelper.getAllData());
 
            finish();
        
    }
}
