package be.iris.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import be.iris.Backing.FrontBean;
import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;
import be.iris.utilities.PrenomComparator;

@Named
@SessionScoped
public class LoginController implements Serializable {

	@EJB(name = "personBean")
	private PersonBeanRemote personBean;

	private String password;
	private String name;

	@Inject
	private FrontBean fb;

	
	private Tutperson personSelected;
	private List<Tutperson> persons = new ArrayList<>();
	private List<String> listOfFirstNames = new ArrayList<>();

	public LoginController() {
		personSelected = new Tutperson();
	}

	public List<String> getListOfFirstNames() {
		if (persons.isEmpty()) {
			persons = personBean.getAllPersons();
			for (Tutperson p : persons) {
				listOfFirstNames.add(p.getPfname() + " " + p.getPlname());
				
			}
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

	public List<Tutperson> getPersons() {
		return persons;
	}

	public void setPersons(List<Tutperson> persons) {
		this.persons = persons;
	}

	public String login() {
		String firstName = name.split(" ")[0]; /* Here change this !! Junior */
		String lastName = name.split(" ")[1];
		
				
		for (Tutperson p : persons) {
			if (p.getPfname().equals(firstName) && p.getPlname().equals(lastName)) {
				personSelected = p;
				break;
			}
		}
		if (personBean.iSLoginOk(personSelected, password)) {
			PersonTypeCheck();
			return "MainPage";
		} else
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

	public void PersonTypeCheck() {
		switch (personSelected.getPtype()) {
		case "Manager":
			fb.setBool_MAN(true);
			break;

		case "Accountant":
			fb.setBool_ACC(true);
			break;

		case "Coworker":
			fb.setBool_CW(true);
			break;

		default:
			fb.setBool_EMP(true);

		}

	}
	
	/*SI time*/
	
	@SuppressWarnings("unchecked") //Supprime un avertissement
	public void trierContacts() {  
		Comparator Jcomparator = new PrenomComparator();
	
		Collections.sort(persons,Jcomparator); 
		
		//Collections.sort(persons);
		
				
	}
	
	

}
