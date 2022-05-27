package com.externalModeller.gcp.GCPWebApp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class GoogleOAuthServer {

	 private Server server = new Server(8080);

	  
	 public static void main(String[] args) throws Exception {
	  new GoogleOAuthServer().startJetty();
	 }
	 
	@SuppressWarnings("resource")
	public void startJetty() throws Exception {

	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	        context.setContextPath("/");
	        server.setHandler(context);
	 
	        // map servlets to endpoints
	        context.addServlet(new ServletHolder(new SigninServlet()),"/signin");        
	        context.addServlet(new ServletHolder(new CallbackServlet()),"/callback");        
	        
	        server.start();
	        server.join();
	 }

}
