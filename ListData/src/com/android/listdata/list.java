package com.android.listdata;

import java.util.ArrayList;
import java.util.List;


import com.android.listdata.db.ListDataDatabaseHelper;
import com.android.listdata.db.ListDataModel;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class list extends Activity{
	
	ListView listNameAge;
	ArrayList<ListDataModel> ListData;
	ListDataModel list;
	myAdapter adapter;
	
@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.list);
	
	ListData=new ArrayList<ListDataModel>();
    
    
    ListDataDatabaseHelper helper=new ListDataDatabaseHelper(list.this);
	SQLiteDatabase db=helper.getReadableDatabase();
	
	Cursor cur=db.query("user", new String[]{"name","age"}, null, null, null, null, null);

	if(cur.moveToFirst())
	{
		do
		{
			 list =new ListDataModel();
			list.setName(cur.getString(cur.getColumnIndex("name")));
			list.setAge(cur.getInt(cur.getColumnIndex("age")));
			Log.d("Data",list.toString());
			ListData.add(list);
		
		}while(cur.moveToNext());
	}
	cur.close();
	

	adapter=new myAdapter(list.this,ListData);
	
   listNameAge=(ListView)findViewById(R.id.list);
   listNameAge.setAdapter(adapter);
 //  adapter.notifyDataSetChanged();           

   listNameAge.setOnItemClickListener(new OnItemClickListener() {

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Log.d("****", "*********");

		ListDataModel list=(ListDataModel)listNameAge.getItemAtPosition(position);
		Intent intent=new Intent(list.this,NewActivity.class);
		intent.putExtra("name", list.getName());
		intent.putExtra("age", list.getAge());
		startActivity(intent);
	}
});
   
}
}
