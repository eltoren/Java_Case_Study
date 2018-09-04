package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;

import be.iris.entities.Activity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	// need jpa controller for it
	
    public ActivityBean() {
    }

	@Override
	public void saveNewActivitie(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOnDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfPerson(Tutperson person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfProject(Tutproject Project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivitiesOfPersonWorkingAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListOfActivities(List<Activity> activities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActivity(Activity activity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteListOfActivities(List<Activity> activities) {
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
