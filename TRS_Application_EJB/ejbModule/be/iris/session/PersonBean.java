package be.iris.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.PersonDao;
import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;

@Stateless(mappedName = "personBean")
public class PersonBean implements PersonBeanRemote {

	@EJB(name = "personDaoImpl")
	PersonDao personDao;

	public PersonBean() {
	}

	@Override
	public void saveNewPerson(Tutperson person) {
		personDao.insertPerson(person);
	}

	@Override
	public void updatePerson(Tutperson oldPerson, Tutperson newPerson) {
		personDao.updatePerson(oldPerson, newPerson);
	}

	@Override
	public Tutperson getPerson(Tutperson person) {
		return personDao.getPerson(person);
	}

	@Override
	public List<Tutperson> getAllPersons() {
		return personDao.listAllPersons();
	}

	@Override
	public void deletePerson(Tutperson Person) {
		personDao.deletePerson(Person);

	}

	@Override
	public boolean iSLoginOk(Tutperson tutperson, String password) {
		String realPassword = personDao.getPasswordOfPerson(tutperson);
		if (realPassword.equals(password)) {
			return true;
		}
		return false;
	}

}
