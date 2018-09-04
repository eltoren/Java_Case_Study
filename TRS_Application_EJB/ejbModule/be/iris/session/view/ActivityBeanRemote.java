package be.iris.session.view;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Activity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;

@Remote
public interface ActivityBeanRemote {
	
	public void saveNewActivitie(Activity activity);
	
	public void updateActivity(Activity activity);
	public void updateListOfActivities(List<Activity> activities);
	
	public List<Activity> getAllActivities();
	public List<Activity> getAllActivitiesOnDate(LocalDate date);
	public List<Activity> getAllActivitiesOfPerson(Tutperson person);
	public List<Activity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date);
	public List<Activity> getAllActivitiesOfProject(Tutproject Project);
	public List<Activity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date);
	public List<Activity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project);
	public List<Activity> getAllActivitiesOfPersonWorkingAtProjectOnDate(Tutperson person, Tutproject project, LocalDate date);
	
	public void deleteActivity(Activity activity);
	public void deleteListOfActivities(List<Activity> activities);
	public void deleteActivitiesOnDate(LocalDate date);
	public void deleteActivitiesOfPerson(Tutperson person);
	public void deleteActivitiesOfPersonAtDate(Tutperson person, LocalDate date);
	public void deleteActivitiesOfProject(Tutproject project);
	public void deleteActivitiesOfProjectAtDate(Tutproject project, LocalDate date);
	
}
