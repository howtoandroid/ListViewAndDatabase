package com.example.listviewanddatabase;
import com.example.listviewanddatabase.R;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class MyCursorAdapter extends CursorAdapter{

	public MyCursorAdapter(Context context, Cursor c) {
		super(context, c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView textViewName = (TextView)view.findViewById(R.id.name_single);
		textViewName.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
		TextView textViewTime = (TextView)view.findViewById(R.id.time_single);
		textViewTime.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
		TextView textViewNum = (TextView)view.findViewById(R.id.num_single);
		textViewNum.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View retView = inflater.inflate(R.layout.task_single_line, parent,false);
		return retView;
	}

}
