/**
 * 
 */
package com.nav.vertx.verticles;

import com.nav.vertx.rest.User;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class RestServer.
 *
 * @author naveen
 */
/**
 * @author naveen
 *
 */
/**
 * @author naveen
 *
 */
public class RestServer extends AbstractVerticle {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//deploy verticle
		Vertx.vertx().deployVerticle(new RestServer());
	}
	
	/* (non-Javadoc)
	 * @see io.vertx.core.AbstractVerticle#start()
	 */
	@Override
	public void start() throws Exception {
		super.start();
		Router router = Router.router(vertx);

	    router.route().handler(BodyHandler.create());
	    router.get("/users/:userID").handler(this::handleGetUser);
	    router.get("/users").handler(this::handleGetUsers);

	vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}
	
	
	/**
	 * Handle get user.
	 *
	 * @param routingContext the routing context
	 */
	private void handleGetUser(RoutingContext routingContext){
		
		 String userID = routingContext.request().getParam("userID");
		    HttpServerResponse response = routingContext.response();
		    if (userID == null) {
		    	response.setStatusCode(400).end();
		    } else {
		      JsonObject user = User.getUser(userID);
		      
		      if (user == null) {
		        response.setStatusCode(404).end();
		      } else {
		    	  response.putHeader("content-type", "application/json").end(user.encodePrettily());
		      }
		}
		
	}
	
	
	
	/**
	 * Handle get users.
	 *
	 * @param routingContext the routing context
	 */
	private void handleGetUsers(RoutingContext routingContext){
		
		JsonArray usersArr = User.getUsers();
		routingContext.response().putHeader("content-type", "application/json").end(usersArr.encodePrettily());
		
		
	}
	
	
	
	

}
