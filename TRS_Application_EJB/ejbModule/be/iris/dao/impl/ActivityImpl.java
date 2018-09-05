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

import be.iris.dao.ActivityDao;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;

@Stateless(mappedName = "activityImpl")
public class ActivityImpl implements ActivityDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	private EntityManager em;

	@Override
	public void insertActivity(Tutactivity activity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(activity);

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
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Tutactivity act = em.find(Tutactivity.class, oldActivity.getActivityId());
			act.setDate(newActivity.getDate());
			act.setDescription(newActivity.getDescription());
			act.setEndTime(newActivity.getEndTime());
			act.setStartTime(newActivity.getStartTime());
			act.setPerson(newActivity.getPerson());
			act.setProject(newActivity.getProject());

			// need to remove first before presisting again?
			//possible id conflict?
			//em.remove(oldActivity);
			
			em.persist(act);

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
	public void deleteActivity(Tutactivity activity) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(activity);
			em.remove(activity);

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
	public List<Tutactivity> listAllActivity() {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			TypedQuery<Tutactivity> query = em.createNamedQuery("Tutactivity.ListActivities", Tutactivity.class);
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.date = :date", Tutactivity.class);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = :person", Tutactivity.class);
			query.setParameter("person", person);
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfProject(Tutproject project) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.project = :project", Tutactivity.class);
			query.setParameter("project", project);
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.project = project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.project = project",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("project", project);
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkigAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			tx.begin();

			Query query = em.createQuery(
					"SELECT a from Tutactivity a WHERE a.person = person AND a.project = :project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

			tx.commit();

		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@Override
	public void deleteListOfActivitiesOnDate(LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.date = :date", Tutactivity.class);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();

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
	public void deleteListOfActivitiesOfPerson(Tutperson person) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.person = :person", Tutactivity.class);
			query.setParameter("person", person);
			query.executeUpdate();

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
	public void deleteListOfActivitiesOfProject(Tutproject project) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.project = :project", Tutactivity.class);
			query.setParameter("project", project);
			query.executeUpdate();

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
	public void deleteListOfActivitiesofProjectAtDate(Tutproject project, LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.project = :project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();

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
	public void deleteListOfActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.person = :person AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();

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

}
