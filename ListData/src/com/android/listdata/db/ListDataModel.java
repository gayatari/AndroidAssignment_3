package com.android.listdata.db;

import android.database.Cursor;

import com.android.*;
import com.android.listdata.list;
//edjkszd
public class ListDataModel{

	String Name;
	String EmialId;
	int Age;
	String Gender;

	public ListDataModel() {
		super();
	}

	

		public ListDataModel(String Name, String EmialId, int Age, String Gender) {
			super();
			this.Name = Name;
			this.EmialId = EmialId;
			this.Age = Age;
			this.Gender = Gender;
		}

		public String getName() {
			return Name;
		}

		public void setName(String Name) {
			this.Name = Name;
		}

		public String getEmialId() {
			return EmialId;
		}

		public void setEmialId(String EmialId) {
			this.EmialId = EmialId;
		}

		public int getAge() {
			return Age;
		}

		public void setAge(int iAge) {
			this.Age = iAge;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String Gender) {
			this.Gender = Gender;
		}

		@Override
		public String toString() {
			return "\n"+"Name=" + Name +"\n"+"Emial Id=" + EmialId
					+"\n"+"Age="+Age+"\n"+"Gender="+Gender;
		}
		
		
	}


