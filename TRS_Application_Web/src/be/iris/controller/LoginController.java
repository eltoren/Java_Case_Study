package be.iris.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;
@Named
@RequestScoped
public class LoginController {

	@EJB(name="personBean")
	private PersonBeanRemote personBean;
	private String password;
	@Inject
	private Tutperson personSelected;
	
	private List<Tutperson>  listPersons;
	private List<String> listOfFirstNames;
	
	
	public LoginController(){
		listPersons = new ArrayList<>();
		listOfFirstNames = new ArrayList<>();
	}
	
	public List<String> getListOfFirstNames() {
		System.out.println("TEST");
		this.setListPersons(personBean.getAllPersons());
		
		for(Tutperson p : listPersons){
			listOfFirstNames.add(p.getPfname());
		}
		return listOfFirstNames;
	}

	public void setListOfFirstNames(List<String> listOfFirstNames) {
		this.listOfFirstNames = listOfFirstNames;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Tutperson getPersonSelected() {
		return personSelected;
	}

	public void setPersonSelected(Tutperson personSelected) {
		this.personSelected = personSelected;
	}

	public List<Tutperson> getListPersons() {
		return listPersons;
	}

	public void setListPersons(List<Tutperson> listPersons) {
		this.listPersons = listPersons;
	}
	
	
	public String login(){
		//
		return "index";
	}
	
}
