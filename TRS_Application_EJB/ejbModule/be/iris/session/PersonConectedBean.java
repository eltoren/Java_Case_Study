package be.iris.session;

import javax.ejb.Stateful;

import be.iris.entities.Tutperson;
import be.iris.session.view.PersonConectedBeanRemote;


@Stateful(mappedName="personConnectedBean")
public class PersonConectedBean implements PersonConectedBeanRemote {

	private Tutperson person;
	
    public PersonConectedBean() {
    }

	@Override
	public void setConnectedPerson(Tutperson person) {
		this.person = person;
		
	}

	@Override
	public Tutperson getConnectedPerson() {
		return this.person;
	}

}
