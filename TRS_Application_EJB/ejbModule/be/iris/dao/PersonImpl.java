package be.iris.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import be.iris.entities.Tutperson;

@Stateless(mappedName="personDaoImpl")
public class PersonImpl implements PersonDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	EntityManager em;

	@Override
	public void insertPerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(person);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
	}

	@Override
	public void updatePerson(Tutperson oldPerson, Tutperson newPerson) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Tutperson prsn = em.find(Tutperson.class, oldPerson);
			prsn.setPno(newPerson.getPno());
			prsn.setPadept(newPerson.getPadept());
			prsn.setPfname(newPerson.getPfname());
			prsn.setPfunc(newPerson.getPfunc());
			prsn.setPlname(newPerson.getPlname());
			prsn.setPsex(newPerson.getPsex());
			prsn.setPtel(newPerson.getPtel());
			prsn.setCocPno(newPerson.getCocPno());
			prsn.setActivities(newPerson.getActivities());

			em.persist(prsn);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void deletePerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(person);
			em.remove(person);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}

	}

	@Override
	public List<Tutperson> listAllPersons() {
		List<Tutperson> listPersons = new ArrayList<>();
		TypedQuery<Tutperson> query = em.createNamedQuery("Tutperson.findPersonsLogs", Tutperson.class);

		for(Tutperson p : query.getResultList()){
			em.detach(p);
			listPersons.add(p);
		}
		
		return listPersons;
	}

}
