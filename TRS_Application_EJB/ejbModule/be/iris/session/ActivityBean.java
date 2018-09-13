package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.iris.dao.ActivityDao;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.exceptions.ActivityException;
import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
//@Path("activities")
//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class ActivityBean implements ActivityBeanRemote {

	@EJB(name ="activityImpl")
	private ActivityDao activityDao;

	public ActivityBean() {
	}

	@POST
	//@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void saveNewActivitie(Tutactivity activity, String pid, long pno)
			throws ActivityException{
		activityDao.insertActivity(activity, pid, pno);

	}

	@Override
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity) {
		activityDao.updateActivity(oldActivity, newActivity);

	}

	@Override
	public void updateListOfActivities(List<Tutactivity> oldActivities, List<Tutactivity> newActivities) {
		if (oldActivities.size() == newActivities.size()) {
			for (int i = 0; i < oldActivities.size(); i++) {
				activityDao.updateActivity(oldActivities.get(i), newActivities.get(i));
			}
		} else {
			System.out.println("size not equal");
			// error
		}

	}

	@Override
	public List<Tutactivity> getAllActivities() {
		return activityDao.listAllActivity();
	}

	@Override
	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date) {
		return activityDao.getAllActivitiesAtDate(date);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPerson(long person)
			throws ActivityException {
		return activityDao.getAllActivitiesOfPerson(person);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		return activityDao.getAllActivitiesOfPersonAtDate(person, date);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfProject(String project)
			throws ActivityException {
		return activityDao.getAllActivitiesOfProject(project);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		return activityDao.getAllActivitiesOfProjectAtDate(project, date);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		return activityDao.getAllActivitiesOfPersonWorkingAtProject(person, project);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		return activityDao.getAllActivitiesOfPersonWorkigAtProjectOnDate(person, project, date);
	}

	@Override
	public void deleteActivity(Tutactivity activity) {
		activityDao.deleteActivity(activity);

	}

	@Override
	public void deleteListOfActivities(List<Tutactivity> activities) {
		for (Tutactivity tutactivity : activities) {
			activityDao.deleteActivity(tutactivity);
		}
	}

	@Override
	public void deleteActivitiesOnDate(LocalDate date) {
		activityDao.deleteListOfActivitiesOnDate(date);
	}

	@Override
	public void deleteActivitiesOfPerson(Tutperson person) {
		activityDao.deleteListOfActivitiesOfPerson(person);
	}

	@Override
	public void deleteActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		activityDao.deleteListOfActivitiesOfPersonAtDate(person, date);
	}

	@Override
	public void deleteActivitiesOfProject(Tutproject project) {
		activityDao.deleteListOfActivitiesOfProject(project);
	}

	@Override
	public void deleteActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		activityDao.deleteListOfActivitiesofProjectAtDate(project, date);
	}

	@Override
	public void deleteListOfActivitesOfPersonAtDate(Tutperson person, LocalDate date) {
		activityDao.deleteListOfActivitiesOfPersonAtDate(person, date);
	}

}
