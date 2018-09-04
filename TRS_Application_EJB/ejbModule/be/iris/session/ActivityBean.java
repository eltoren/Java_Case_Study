package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;

import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.entities.Tutactivity;

import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	// need jpa controller for it

	public ActivityBean() {
	}

	@Override
	public void saveNewActivitie(Tutactivity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateActivity(Tutactivity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateListOfActivities(List<Tutactivity> activities) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Tutactivity> getAllActivities() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteListOfActivities(List<Tutactivity> activities) {
		// TODO Auto-generated method stub

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
