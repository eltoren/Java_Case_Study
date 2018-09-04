package be.iris.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;

@Named
@SessionScoped
public class LoginController implements Serializable{

	@EJB(name = "personBean")
	private PersonBeanRemote personBean;
	private String password;
	private String name;
	@Inject
	private Tutperson personSelected;

	private List<Tutperson> listPersons;
	private List<String> listOfFirstNames;

	public LoginController() {
		listPersons = new ArrayList<>();
		listOfFirstNames = new ArrayList<>();
	}

	public List<String> getListOfFirstNames() {
		this.setListPersons(personBean.getAllPersons());

		for (Tutperson p : listPersons) {
			listOfFirstNames.add(p.getPfname() + " " + p.getPlname());
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
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ")[1];
		for(Tutperson p : listPersons){
			if(p.getPfname().equals(firstName) && p.getPlname().equals(lastName)){
				personSelected = p;
				System.out.println(personSelected.getPno());
				break;
			}
		}
		return "index";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
