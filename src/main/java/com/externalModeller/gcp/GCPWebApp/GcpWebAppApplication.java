package com.externalModeller.gcp.GCPWebApp;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GcpWebAppApplication {
	
	@Autowired
	private HttpServletRequest httpServletRequest;

	public static void main(String[] args) {
		SpringApplication.run(GcpWebAppApplication.class, args);
	}
	
	@GetMapping(value="/user")
	public Principal userPrincipal(Principal principal) {
		System.out.println(httpServletRequest.getParameter("code"));
		System.out.println("User name : "+principal.getName());
		return principal;
	}
	
	
	/*
	 * @GetMapping(value="/") public String hello( HttpServletRequest
	 * httpServletRequest ) {
	 * 
	 * return "Welcome to Google authentication !!"; }
	 */
	
	@PostFilter(value = "/")
	public String authorize() {
		System.out.println(httpServletRequest.getParameter("code"));
		return "GCP authorize !! ";
	}

}
