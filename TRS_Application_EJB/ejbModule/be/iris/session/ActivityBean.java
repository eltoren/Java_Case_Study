package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;

import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.dao.ActivityDao;
import be.iris.dao.ActivityImpl;
import be.iris.entities.Tutactivity;

import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	private ActivityDao activityDao = new ActivityImpl();

	public ActivityBean() {
	}

	@Override
	public void saveNewActivitie(Tutactivity activity) {
		activityDao.insertActivity(activity);

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
			//error
		}

	}

	@Override
	public List<Tutactivity> getAllActivities() {
		return activityDao.listAllActivity();
	}

	@Override
	public List<Tutactivity> getAllActivitiesOnDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPerson(Tutperson person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfProject(Tutproject Project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteActivitiesOfPerson(Tutperson person) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteActivitiesOfProject(Tutproject project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		// TODO Auto-generated method stub

	}

}

