package be.iris.session.view;

import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Tutperson;

@Remote
public interface PersonBeanRemote {

	public void saveNewPerson(Tutperson person);

	public void updatePerson(Tutperson oldPerson, Tutperson newPerson);

	public Tutperson getPerson(Tutperson person);

	public List<Tutperson> getAllPersons();

	public void deletePerson(Tutperson Person);

	public boolean iSLoginOk(Tutperson tutperson, String password);

}
