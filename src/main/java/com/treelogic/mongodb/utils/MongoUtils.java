package com.treelogic.mongodb.utils;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtils {
	static MongoClient client;
	
	static{
		try {
			client = new MongoClient("localhost");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	public static DB initializeDB(String db){
		return client != null? client.getDB(db) : null;
	}
	public static DBCollection initializeCollection(DB db, String col){
		return db != null? db.getCollection(col): null;
	}
	
	public static void close(){
		if(client != null)
			client.close();
	}
}
