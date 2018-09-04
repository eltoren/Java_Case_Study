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
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePerson(Tutperson oldPerson, Tutperson newPerson) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tutperson getPerson(Tutperson person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutperson> getAllPersons() {
		return personDao.listAllPersons();
	}

	@Override
	public void deletePerson(Tutperson Person) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean iSLoginOk(Tutperson tutperson, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
