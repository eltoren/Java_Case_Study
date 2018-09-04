package be.iris.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;

public class ListingPersons {

	private List<Tutperson> persons;
	private List<String> names;
	
	public ListingPersons(){

	}
	
	public List<Tutperson> getPersons() {
		return persons;
	}

	public void setPersons(List<Tutperson> persons) {
		this.persons = persons;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}


	
}
