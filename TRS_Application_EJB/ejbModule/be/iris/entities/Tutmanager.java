package be.iris.entities;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("Manager")
@Named("manager")
@RequestScoped
public class Tutmanager extends Tutperson{

	public Tutmanager(){
		super();
	}
}
