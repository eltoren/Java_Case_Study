package be.iris.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.Backing.FrontBean;
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
	private FrontBean fb ;
	
	@Inject
	@Named("person")
	private Tutperson personSelected;

	private List<Tutperson> persons= new ArrayList<>();
	private List<String> listOfFirstNames = new ArrayList<>();

	public LoginController() {

	}

	public List<String> getListOfFirstNames() {
		if(persons.isEmpty()){
			persons = personBean.getAllPersons();
			for(Tutperson p : persons){
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

	public String login(){
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ")[1];
		for(Tutperson p : persons){
			if(p.getPfname().equals(firstName) && p.getPlname().equals(lastName)){
				personSelected = p;
				
				System.out.println(personSelected.getPno());
				break;
			}
		}
		if(personBean.iSLoginOk(personSelected, password))
		{
			PersonTypeCheck();
			return "MainPage";
		}
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
	
	public void PersonTypeCheck()
	{
		
		// test manager
		personSelected.setPtype("Manager");
		System.out.println("Here changed ass manager");
		System.out.println(personSelected.getPtype());
//		
//		//test IW
//		
//		personSelected.setPtype("Accountant");
//		System.out.println(personSelected.getPtype());
//		
//		
//		// test Accountant
//		
//		personSelected.setPtype("IW");
//		System.out.println(personSelected.getPtype());
		
		
		switch(personSelected.getPtype())
		{
		case "Manager" :
			fb.setBool_MAN(true);
			break;
		case "IW" :
			fb.setBool_IW(true);
			break;
		case "Accountant":
			fb.setBool_ACC(true);
		
		
		}
		
		
	
		
		
	}

	
}
