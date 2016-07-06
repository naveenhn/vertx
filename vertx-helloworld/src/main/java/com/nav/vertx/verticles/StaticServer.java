/**
 * 
 */
package com.nav.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

/**
 * @author naveen
 *
 */
public class StaticServer extends AbstractVerticle{
	
	public static void main(String[] args) {
		Vertx.vertx().deployVerticle(new StaticServer());
	}
	
	@Override
	public void start() throws Exception {
		super.start();
		
		Router router = Router.router(vertx);
		//render all pages from the webroot folder- default!
		router.route().handler(StaticHandler.create());
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		
	}

}
