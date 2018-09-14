package be.iris.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.iris.dao.ActivityDao;
import be.iris.dao.WorkingDayDao;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.entities.TutworkingDay;
import be.iris.exceptions.ActivityException;

@Stateless(mappedName = "activityImpl")
public class ActivityImpl implements ActivityDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	private EntityManager em;

	@EJB
	private WorkingDayDao workingDay;
	@Override
	public void insertActivity(Tutactivity activity, String pid, long pno)
			throws ActivityException {
		try {
			Tutproject p = em.find(Tutproject.class, pid);
			Tutperson person = em.find(Tutperson.class, pno);
			if(person.getPtype().equalsIgnoreCase("coworker")){
				TutworkingDay wd = workingDay.getWorkingDay(activity.getActDate(), pno);
				if(wd == null){
					throw new ActivityException("You cannot add an activity for that date, you didn't worked !");
				}
			}
			em.persist(activity);			
			p.addActivity(activity);
			person.addActivity(activity);
			em.merge(p);
			em.merge(person);
		

		} catch (RuntimeException re) {
				throw new ActivityException("Oups: problem while registrating the activity");
			}
	}

	@Override
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity)
	{
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

	@Override
	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createQuery("SELECT a from Tutactivity a WHERE a.date = :date", Tutactivity.class);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPerson(long person)
			throws ActivityException {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {
			Tutperson p = em.find(Tutperson.class, person);
			int i = 0;
			for(; i <p.getActivities().size();i++){
				em.detach(p.getActivities().get(i));
				listActivities.add(p.getActivities().get(i));
			}
			if(listActivities.isEmpty()){
				throw new ActivityException("There is no activity for this person");
			}

		} catch (RuntimeException re) {
			throw new ActivityException("Oups: problem while getting the activity");
			}
		return listActivities;
	}
	
	@Override
	public List<Tutactivity> getAllActivitiesOfProject(String project)
			throws ActivityException {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			Tutproject p = em.find(Tutproject.class, project);
			int i = 0;
			for(; i <p.getActivities().size();i++){
				em.detach(p.getActivities().get(i));
				listActivities.add(p.getActivities().get(i));
			}
			if(listActivities.isEmpty()){
				throw new ActivityException("There is no activity for this project");
			}
		} catch (RuntimeException re) {
			throw new ActivityException("Oups: problem while getting the activity");
		}
		return listActivities;
	}


	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.date = :date",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}


	@Override
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createQuery("SELECT a from Tutactivity a WHERE a.project = project AND a.date = :date",
					Tutactivity.class);
			query.setParameter("project", project);
			query.setParameter("date", Date.valueOf(date));
			listActivities = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createQuery("SELECT a from Tutactivity a WHERE a.person = person AND a.project = project",
					Tutactivity.class);
			query.setParameter("person", person);
			query.setParameter("project", project);
			listActivities = query.getResultList();


		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkigAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		List<Tutactivity> listActivities = new ArrayList<>();
		try {

			TypedQuery<Tutactivity> query = em.createQuery(
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
