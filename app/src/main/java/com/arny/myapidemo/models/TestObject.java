package com.arny.myapidemo.models;

import android.database.Cursor;
//import org.chalup.microorm.MicroOrm;
//import org.chalup.microorm.annotations.Column;

import java.io.Serializable;
import java.util.ArrayList;


public class TestObject implements Serializable {
	private String id;
    private long dbID;
    private String name;
    private ArrayList<GoodItem> goodItems;

	public TestObject() {
	}

	public TestObject(String id,String name) {
		this.id = id;
		this.name = name;
	}

	public long getDbID() {
        return dbID;
    }

    public void setDbID(long dbID) {
        this.dbID = dbID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public TestObject getFromCursor(Cursor c){
////	    MicroOrm uOrm = new MicroOrm();
////	    return uOrm.fromCursor(c, this.getClass());
//    }

    @Override
    public String toString() {
        return "\nid:" + this.getDbID() + ";name:" + this.getName() + ";goodItems:" + getGoodItems();
    }

    public ArrayList<GoodItem> getGoodItems() {
        return goodItems;
    }

    public void setGoodItems(ArrayList<GoodItem> goodItems) {
        this.goodItems = goodItems;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
