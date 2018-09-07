package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.ActivityDao;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	@EJB(name ="activityImpl")
	private ActivityDao activityDao;

	public ActivityBean() {
	}

	@Override
	public void saveNewActivitie(Tutactivity activity, String pid, int pno) {
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
	public List<Tutactivity> getAllActivitiesOfPerson(Tutperson person) {
		return activityDao.getAllActivitiesOfPerson(person);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		return activityDao.getAllActivitiesOfPersonAtDate(person, date);
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfProject(Tutproject project) {
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
