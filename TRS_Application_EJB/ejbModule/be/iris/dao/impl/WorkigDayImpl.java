package be.iris.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import be.iris.dao.WorkingDayDao;
import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;

@Stateless(mappedName = "workingDayDaoImpl")
public class WorkigDayImpl implements WorkingDayDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	EntityManager em;

	@Override
	public void insertWorkingDay(TutworkingDay workingDay) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(workingDay);

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
	public void updateWorkingDay(TutworkingDay oldWorkingDay, TutworkingDay newWorkingDay) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			TutworkingDay workingDay = em.find(TutworkingDay.class, oldWorkingDay);
			workingDay.setDate(newWorkingDay.getDate());
			workingDay.setStartTime(newWorkingDay.getStartTime());
			workingDay.setEndTime(newWorkingDay.getEndTime());
			workingDay.setPersonId(workingDay.getPersonId());

			em.persist(workingDay);

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
	public void deleteWorkingDay(TutworkingDay workingDay) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(workingDay);
			em.remove(workingDay);

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
	public TutworkingDay getWorkigDay(TutworkingDay workingDay) {
		EntityTransaction tx = em.getTransaction();
		TutworkingDay returnWorkingDay = new TutworkingDay();
		try {
			tx.begin();

			returnWorkingDay = em.find(TutworkingDay.class, workingDay);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return returnWorkingDay;
	}

	@Override
	public List<TutworkingDay> listAllWorkigDays() {
		EntityTransaction tx = em.getTransaction();
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			tx.begin();

			TypedQuery<TutworkingDay> query = em.createNamedQuery("TutworkingDay.listWorkingDays", TutworkingDay.class);
			listWorkingDays = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			tx.begin();

			String sql = "select w from tutworkingDay w where w.date = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, Date.valueOf(date));
			listWorkingDays = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysOfPerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			tx.begin();

			String sql = "select w from tutworkingDay w where w.personId = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person.getPno());
			listWorkingDays = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@Override
	public TutworkingDay getWorkigDaysOfPersonAtDate(Tutperson person, LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		TutworkingDay returnWorkingDay = new TutworkingDay();
		try {
			tx.begin();

			String sql = "select w from tutworkingDay w where w.personId = ? and w.date = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person.getPno());
			query.setParameter(2, Date.valueOf(date));
			returnWorkingDay = (TutworkingDay) query.getSingleResult();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return returnWorkingDay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate) {
		EntityTransaction tx = em.getTransaction();
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			tx.begin();

			// needs testing if between works!

			String sql = "select w from tutworkingDay w where w.date between  ? and ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, Date.valueOf(startDate));
			query.setParameter(2, Date.valueOf(endDate));
			listWorkingDays = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(Tutperson person,
			LocalDate startDate, LocalDate endDate) {
		EntityTransaction tx = em.getTransaction();
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			tx.begin();

			// needs testing if between works!

			String sql = "select w from tutworkingDay w where w.personId = ? and w.date between  ? and ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person.getPno());
			query.setParameter(2, Date.valueOf(startDate));
			query.setParameter(3, Date.valueOf(endDate));
			listWorkingDays = query.getResultList();

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

}
