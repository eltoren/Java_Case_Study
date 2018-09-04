package be.iris.session.view;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Activity;

@Remote
public interface ActivityBeanRemote {
	
	public void saveNewActivitie(Activity activity);
	
	public List<Activity> getAllActivities();
	public List<Activity> getAllActivitiesOfPerson(Person person);
	public List<Activity> getAllActivitesOfPersonAtDate(Person person, LocalDate date);
	public List<Activity> getAllActivitiesOfProject(Project Project);
	public List<Activity> getAllActivitiesOfProjectAtDate(Project project, LocalDate date);
	public List<Activity> getAllActivitiesOfPersonWorkingAtProject();
	public List<Activity> getAllActivitiesOfPersonWorkingAtProjectOnDate();
	
	

}
