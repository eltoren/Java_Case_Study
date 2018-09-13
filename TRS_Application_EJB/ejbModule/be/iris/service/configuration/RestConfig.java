package be.iris.service.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import be.iris.session.ActivityBean;

@ApplicationPath("/abis-services")
public class RestConfig extends Application{

	 @Override
	    public Set<Class<?>> getClasses() {
	        Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(ActivityBean.class);
	        return classes;
	    }
	
}