package com.treelogic.eba.mongodb;

import java.util.Arrays;
import java.util.Date;

import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.treelogic.eba.model.Address;
import com.treelogic.eba.model.Person;
import com.treelogic.eba.utils.MongoUtils;

public class InsertJavaClass {	
	public static void main (String [] args){
		DB db = MongoUtils.initializeDB("test");
		DBCollection col = MongoUtils.initializeCollection(db, "person");
		
		Person person1 = new Person("Jorge", new Date());
		Address address_person_1 = new Address("Avd n1 ", "1",23);
		person1.setAddress(address_person_1);
	
		Person person2 = new Person("Rosa", new Date());
		Address address_person_2 = new Address("Avd n2 ", "12dA",12);
		person2.setAddress(address_person_2);
		
		Person person3 = new Person("Pelayo", new Date());
		Address address_person_3 = new Address("Avd N3 ", "324d",2);
		person3.setAddress(address_person_3);
		
		person3.setFriends(Arrays.asList(person1, person2));

		JacksonDBCollection<Person, String> jacksonWrapper_col = JacksonDBCollection.wrap(col, Person.class, String.class);
		@SuppressWarnings("unused")
		WriteResult<Person, String> result = jacksonWrapper_col.insert(Arrays.asList(person1, person2, person3));
		MongoUtils.close();
	}
}
