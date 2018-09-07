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
	public void insertActivity(Tutactivity activity, String pid, long pno) {
		try {
			System.out.println(pid +" " + pno);
			Tutproject p = em.find(Tutproject.class, pid);
			em.persist(activity);
			Tutperson person = em.find(Tutperson.class, pno);
			System.out.println(person.getPlname());
			/*Query q  = em.createNativeQuery("Tutperson.findPersonConnected", Tutperson.class);
			q.setParameter("pno", pno);
			Tutperson person = (Tutperson) q.getSingleResult();*/
			p.addActivity(activity);
			person.addActivity(activity);
		//	person.addActivity(activity);
			em.merge(p);
			em.merge(person);
		

		} catch (RuntimeException re) {
				re.printStackTrace();
			}
	}

	@Override
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity) {
		try {

			Tutactivity act = em.find(Tutactivity.class, oldActivity.getAid());
			act.setActDate(newActivity.getActDate());
			act.setActDescription(newActivity.getActDescription());
			act.setActEndTime(newActivity.getActEndTime());
			act.setActStartTime(newActivity.getActStartTime());
			act.setPerson(newActivity.getPerson());
			act.setProject(newActivity.getProject());

			em.merge(act);


		} catch (RuntimeException re) {
				System.err.println(re.getMessage());
			}
	}

	@Override
	public void deleteActivity(Tutactivity activity) {
		try {

			em.merge(activity);
			em.remove(activity);


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public List<Tutactivity> listAllActivity() {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createNamedQuery("Tutactivity.ListActivities", Tutactivity.class);
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.date = :date", Tutactivity.class);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPerson(Tutperson person) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = :person", Tutactivity.class);
			query.setParameter("person", person);
			listActivities = query.getResultList();

		} catch (RuntimeException re) {
				System.err.println(re.getMessage());
			}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfProject(Tutproject project) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.project = :project", Tutactivity.class);
			query.setParameter("project", project);
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.project = project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.project = project",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("project", project);
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkigAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Query query = em.createQuery(
					"SELECT a from Tutactivity a WHERE a.person = person AND a.project = :project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@Override
	public void deleteListOfActivitiesOnDate(LocalDate date) {
		try {

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.date = :date", Tutactivity.class);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
	}

	@Override
	public void deleteListOfActivitiesOfPerson(Tutperson person) {
		try {

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.person = :person", Tutactivity.class);
			query.setParameter("person", person);
			query.executeUpdate();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void deleteListOfActivitiesOfProject(Tutproject project) {
		try {

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.project = :project", Tutactivity.class);
			query.setParameter("project", project);
			query.executeUpdate();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void deleteListOfActivitiesofProjectAtDate(Tutproject project, LocalDate date) {
		try {

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.project = :project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
	}

	@Override
	public void deleteListOfActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		try {

			Query query = em.createQuery("DELETE from Tutactivity a WHERE a.person = :person AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("date", Date.valueOf(date));
			query.executeUpdate();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
	}

}
