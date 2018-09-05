package be.iris.session.view;

import javax.ejb.Remote;

import be.iris.entities.Tutperson;

@Remote
public interface PersonConectedBeanRemote {
	
	public void setConnectedPerson(Tutperson person);
	
	public Tutperson getConnectedPerson();

}
