package com.treelogic.eba.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.treelogic.eba.utils.MongoUtils;

public class GetResultsFromMongoDB {

	public static void main (String [] args){
		DB db = MongoUtils.initializeDB("test");
		DBCollection col = MongoUtils.initializeCollection(db, "person");
		DBObject query = new BasicDBObject("name", "Jorge");
		DBCursor cursor = col.find(query);
		while(cursor.hasNext())
			System.out.println(cursor.next());
		
		MongoUtils.close();
	}
}
