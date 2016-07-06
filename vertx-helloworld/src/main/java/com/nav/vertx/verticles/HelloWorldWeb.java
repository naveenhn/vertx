/**
 * 
 */
package com.nav.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * @author naveen
 * Simple Hello World
 *
 */
public class HelloWorldWeb extends AbstractVerticle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 Vertx vertx = Vertx.vertx();
		 vertx.deployVerticle(new HelloWorldWeb());
		
	}
	
	@Override
	public void start() throws Exception {
		//you need a router
		Router router = Router.router(vertx);
		
		router.route().handler(routingContext -> {
			routingContext.response().putHeader("content-type", "text/html").end("Hello World!!");
			
			
		});
		
		
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

}
