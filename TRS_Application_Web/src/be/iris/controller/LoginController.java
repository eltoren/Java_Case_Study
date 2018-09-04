package be.iris.controller;

import java.io.Serializable;
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
public class LoginController implements Serializable{

	@EJB(name = "personBean")
	private PersonBeanRemote personBean;
	private String password;
	private String name;
	@Inject
	private Tutperson personSelected;

	@Inject
	private ListingPersons listPersons;
	private List<String> listOfFirstNames;

	public LoginController() {
		listOfFirstNames = new ArrayList<>();
	
	}

	public List<String> getListOfFirstNames() {
		
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

	public ListingPersons getListPersons() {
		return listPersons;
	}

	public void setListPersons(ListingPersons listPersons) {
		this.listPersons = listPersons;
	}

	public String login(){
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ")[1];
		for(Tutperson p : listPersons.getPersons()){
			if(p.getPfname().equals(firstName) && p.getPlname().equals(lastName)){
				personSelected = p;
				
				System.out.println(personSelected.getPno());
				break;
			}
		}
		if(personBean.iSLoginOk(personSelected, password))
			return "ActivityRegistration?faces-redirect=true";
		else
			return "index";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonBeanRemote getPersonBean() {
		return personBean;
	}

	
}
