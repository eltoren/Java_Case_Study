package be.iris.Backing;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



@Named
@SessionScoped
public class FrontBean implements Serializable {

	public String register()
	{
		System.out.println("Hello");
		return "ActivityRegistration";
	}
	
	
}
