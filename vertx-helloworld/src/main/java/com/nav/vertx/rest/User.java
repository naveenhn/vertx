/**
 * 
 */
package com.nav.vertx.rest;

import java.util.HashMap;
import java.util.Map;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * @author naveen

 */
public class User {
	
	private static Map<String, JsonObject> users = new HashMap<>();
	
	static{
		
		users.put("1", new JsonObject().put("id", "1").put("name", "Naveen").put("height", 5.11).put("weight", 85));
		users.put("2",new JsonObject().put("id", "2").put("name", "Ajay").put("height", 5.11).put("weight", 80));
		users.put("3",new JsonObject().put("id", "3").put("name", "Manohar").put("height", 5.10).put("weight", 80));
		users.put("4",new JsonObject().put("id", "4").put("name", "Lokesh").put("height", 5.8).put("weight", 78));
		
	}
	
	
	
	public static JsonArray getUsers(){
		
		JsonArray userarray = new JsonArray();
		users.forEach((k,v) -> userarray.add(v));		
		
		return userarray;
		
	}
	
	public static JsonObject getUser(String userId){
		
		return users.get(userId) != null ? users.get(userId) : null;
		
		
	}

}
