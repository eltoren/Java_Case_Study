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

import be.iris.dao.CompanyDao;
import be.iris.entities.Tutcompany;

@Stateless(mappedName = "companyImpl")
public class CompanyImpl implements CompanyDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	EntityManager em;

	@Override
	public void insertCompany(Tutcompany company) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(company);

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
	public void updateCompany(Tutcompany oldCompany, Tutcompany newCompany) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Tutcompany company = em.find(Tutcompany.class, oldCompany);
			company.setCobankno(newCompany.getCobankno());
			company.setConame(newCompany.getConame());
			company.setCostreet(newCompany.getCostreet());
			company.setCostrno(newCompany.getCostrno());
			company.setCotel(newCompany.getCotel());
			company.setCotown(newCompany.getCotown());
			company.setCotownno(newCompany.getCotownno());
			company.setCovat(newCompany.getCovat());
			company.setTutperson(newCompany.getTutperson());
			company.setTutpersons(newCompany.getTutpersons());

			em.merge(company);

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
	public void deleteCompany(Tutcompany company) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(company);
			em.remove(company);

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
	public Tutcompany geCompany(Tutcompany company) {
		EntityTransaction tx = em.getTransaction();
		Tutcompany returncompany = new Tutcompany();
		try {
			tx.begin();

			returncompany = em.find(Tutcompany.class, company);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return returncompany;
	}

	@Override
	public List<Tutcompany> listAllCompanies() {
		EntityTransaction tx = em.getTransaction();
		List<Tutcompany> listCompanies = new ArrayList<>();
		try {
			tx.begin();

			TypedQuery<Tutcompany> query = em.createNamedQuery("Tutcompany.findAll", Tutcompany.class);
			listCompanies = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listCompanies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutcompany> listComapniesInCountry(String country) {
		EntityTransaction tx = em.getTransaction();
		List<Tutcompany> listCompanies = new ArrayList<>();
		try {
			tx.begin();

			String sql = "select c from TUTCOMPANIES c where c.cocountr like ?";
			Query query = em.createNativeQuery(sql, Tutcompany.class);
			query.setParameter(1, country);
			listCompanies = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listCompanies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutcompany> listCompaniesInTownByName(String town) {
		EntityTransaction tx = em.getTransaction();
		List<Tutcompany> listCompanies = new ArrayList<>();
		try {
			tx.begin();

			String sql = "select c from TUTCOMPANIES c where c.cotown like ?";
			Query query = em.createNativeQuery(sql, Tutcompany.class);
			query.setParameter(1, town);
			listCompanies = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listCompanies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutcompany> listCompaniesInTownByZipCode(String zipcode) {
		EntityTransaction tx = em.getTransaction();
		List<Tutcompany> listCompanies = new ArrayList<>();
		try {
			tx.begin();

			String sql = "select c from TUTCOMPANIES c where c.cotownno like ?";
			Query query = em.createNativeQuery(sql, Tutcompany.class);
			query.setParameter(1, zipcode);
			listCompanies = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listCompanies;
	}

}
