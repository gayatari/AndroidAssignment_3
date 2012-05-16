package com.android.listdata;

import java.util.ArrayList;
import java.util.List;

import com.android.listdata.db.ListDataModel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class myAdapter extends BaseAdapter {
	
	
	ArrayList<ListDataModel> ListData;
	private LayoutInflater mInflater;
	public myAdapter(Context context, ArrayList<ListDataModel> ListData) {
		
		// TODO Auto-generated constructor stub
		
		this.ListData=ListData;
		mInflater = LayoutInflater.from(context);
	}


	

	


	@Override
	public int getCount() {
		return ListData.size();
	}

	@Override
	public ListDataModel getItem(int position) {
		
		return ListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*LinearLayout layout=null;
		TextView text;
		
		ListDataModel list=ListData.get(position);
		if(layout==null){
			LayoutInflater inflater=context.getLayoutInflater();
			layout=(LinearLayout)inflater.inflate(R.layout.list_item,null);
		}
		else {
			layout=(LinearLayout)convertView;
		}
		text=(TextView)layout.findViewById(R.id.text);
		text.setText(list.getiName()+"\n"+list.getiAge());
		
		
		return layout;*/
		
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.customlist, null);
			holder = new ViewHolder();
			holder.name= (TextView) convertView
					.findViewById(R.id.textName);
			holder.age = (TextView) convertView
					.findViewById(R.id.textAge);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name.setText(ListData.get(position).getName());
		holder.age.setText(String.format("%d",ListData.get(position).getAge()));
		 
		return convertView;
	}
	static class ViewHolder {
		TextView name;
		TextView age;
	}

}

