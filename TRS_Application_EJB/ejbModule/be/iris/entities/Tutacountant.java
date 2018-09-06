package be.iris.entities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


@Named("accountant")
@RequestScoped
@DiscriminatorValue("accountant")
public class Tutacountant extends Tutperson{

	
	public Tutacountant(){
		super();
	}
}
