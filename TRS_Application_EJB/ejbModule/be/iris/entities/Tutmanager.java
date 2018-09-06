package be.iris.entities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Named("manager")
@RequestScoped
@DiscriminatorValue("Manager")
public class Tutmanager extends Tutperson{

	public Tutmanager(){
		super();
	}
}
