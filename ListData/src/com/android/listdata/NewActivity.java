package com.android.listdata;

import android.app.Activity;



    import com.android.listdata.db.ListDataDatabaseHelper;
	import com.android.listdata.db.ListDataModel;
	import android.content.Intent;
	import android.database.Cursor;
	import android.database.sqlite.SQLiteDatabase;
	import android.os.Bundle;
	import android.util.Log;
import android.widget.TextView;

				

public class NewActivity extends Activity {
	
	TextView textName,textage,textgender,textmail;
	ListDataModel list;
	String name;
	int age;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lay);

		
		textName=(TextView)findViewById(R.id.Name);
		textage=(TextView)findViewById(R.id.Age);
		textgender=(TextView)findViewById(R.id.gender);
		textmail=(TextView)findViewById(R.id.email);
		
		Intent intent=getIntent();
		name=(String)intent.getSerializableExtra("name");
		age=(Integer)intent.getSerializableExtra("age");
		
		ListDataDatabaseHelper helper=new ListDataDatabaseHelper(NewActivity.this);
			SQLiteDatabase db=helper.getReadableDatabase();
			
			Cursor cur=db.query("userInfo", new String[]{"name","emailId","age","gender"}, null, null, null, null, null);

			if(cur.moveToFirst())
			{
				do
				{
					 list=new ListDataModel();
					list.setName(cur.getString(cur.getColumnIndex("name")));
					list.setEmialId(cur.getString(cur.getColumnIndex("emailId")));
					list.setAge(cur.getInt(cur.getColumnIndex("age")));
					list.setGender(cur.getString(cur.getColumnIndex("gender")));
					if(list.getName().equals(name) && list.getAge()==age)
					{
						textName.setText(list.getName());
						textage.setText(String.format("%d",list.getAge()));
						textgender.setText(list.getGender());
						textmail.setText(list.getEmialId());
					}
					Log.d("Data",list.toString());
				
				//	cur.moveToNext();
				}while(cur.moveToNext());
				
			}
			cur.close();
			

	}

}
