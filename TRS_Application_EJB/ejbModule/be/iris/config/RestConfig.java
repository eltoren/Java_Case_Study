package be.iris.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;

import be.iris.exceptions.ActivityBean;

@ApplicationPath("abis-services")
public class RestConfig extends ResourceConfig{

	 public RestConfig() {
	        packages("be.iris.services");
	    }
	
}