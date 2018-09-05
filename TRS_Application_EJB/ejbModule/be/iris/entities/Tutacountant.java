package be.iris.entities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("accountant")
@Named("accountant")
@RequestScoped
public class Tutacountant extends Tutperson{

	
	public Tutacountant(){
		super();
	}
}
