package com.treelogic.mongodb;

import java.util.Arrays;
import java.util.Iterator;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.treelogic.mongodb.utils.MongoUtils;


public class AggregationExample {
	
	
	public static void main (String [] args){
		DB db = MongoUtils.initializeDB("test");
		DBCollection col = MongoUtils.initializeCollection(db, "person");
		DBObject match = new BasicDBObject();
		DBObject group = new BasicDBObject("_id", new BasicDBObject("name", "$name"));
		group.put("totalDoors", new BasicDBObject("$sum", "$address.door"));
		match = new BasicDBObject("$match", match);
		group = new BasicDBObject("$group", group);
		AggregationOutput aggregation = col.aggregate(Arrays.asList(match, group));
		Iterator<DBObject> iterator = aggregation.results().iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
