package be.iris.dao;

import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutperson;

@Local
public interface PersonDao {

	public void insertPerson(Tutperson person);

	public void updatePerson(Tutperson oldPerson, Tutperson newPerson);

	public void deletePerson(Tutperson person);

	public List<Tutperson> listAllPersons();

}
