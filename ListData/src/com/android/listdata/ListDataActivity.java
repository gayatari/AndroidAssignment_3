package com.android.listdata;




import com.android.listdata.db.ListDataDatabaseHelper;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class ListDataActivity extends Activity {
    /** Called when the activity is first created. */
	EditText Name;
	EditText age;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Name=(EditText)findViewById(R.id.Name);
	     age=(EditText)findViewById(R.id.Age);
	     Button show=(Button)findViewById(R.id.show);
	    
	   show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Intent intent=new Intent(getApplicationContext(), list.class);
				//intent.putExtra("Name", Name.getText().toString());
				//intent.putExtra("age", age.getText().toString());
				//startActivity(intent);
				ListDataDatabaseHelper helper=new ListDataDatabaseHelper(ListDataActivity.this);
				SQLiteDatabase db=helper.getWritableDatabase();
				
				
				 ContentValues values = new ContentValues();
				 values.put("name", Name.getText().toString());
				 values.put("age", Integer.parseInt(age.getText().toString()));
				db.insert("user",null,values);
			
				
				ContentValues Convalues = new ContentValues();
				Convalues.put("name", "gayatri");
				Convalues.put("emailId","gayatri@yahoo.com");
				Convalues.put("age",24);
				Convalues.put("gender","Female");
				db.insert("userInfo",null,Convalues);
				db.close();
				
				Intent intent=new Intent(ListDataActivity.this,list.class);
				startActivity(intent);		
				
			   
			    
				
			}
		});
    }
}