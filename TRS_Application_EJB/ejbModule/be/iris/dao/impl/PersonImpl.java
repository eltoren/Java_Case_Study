package be.iris.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import be.iris.dao.PersonDao;
import be.iris.entities.Tutperson;

@Stateless(mappedName = "personDaoImpl")
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
			prsn.setPadept(newPerson.getPadept());
			prsn.setPfname(newPerson.getPfname());
			prsn.setPfunc(newPerson.getPfunc());
			prsn.setPlname(newPerson.getPlname());
			prsn.setPsex(newPerson.getPsex());
			prsn.setPtel(newPerson.getPtel());
			prsn.setCocPno(newPerson.getCocPno());
			prsn.setActivities(newPerson.getActivities());
			
			em.merge(prsn);

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
	public Tutperson getPerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		Tutperson returnPerson = new Tutperson();
		try {
			tx.begin();
			returnPerson = em.find(Tutperson.class, person);
			tx.commit();
		} catch (RuntimeException re) {
			try {
				
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return returnPerson;
	}


	@Override
	public List<Tutperson> listAllPersons() {
		List<Tutperson> listPersons = new ArrayList<>();
		try {
			TypedQuery<Tutperson> query = em.createNamedQuery("Tutperson.findPersonsLogs", Tutperson.class);

			for (Tutperson p : query.getResultList()) {
				em.detach(p);
				listPersons.add(p);
			}
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listPersons;
	}

	@Override
	public String getPasswordOfPerson(Tutperson person) {
		String sql ="select p.password from tutpasswords p where p.pass_pno = ?";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, person.getPno());
		return (String) query.getSingleResult();
	}
}
