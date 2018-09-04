package be.iris.session.view;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Tutactivity;

@Remote
public interface ActivityBeanRemote {
	
	public void saveNewActivitie(Tutactivity activity);
	
	public List<Tutactivity> getAllActivities();
	public List<Tutactivity> getAllActivitiesOfPerson(Person person);
	public List<Tutactivity> getAllActivitesOfPersonAtDate(Person person, LocalDate date);
	public List<Tutactivity> getAllActivitiesOfProject(Project Project);
	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Project project, LocalDate date);
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject();
	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProjectOnDate();
	
	

}
