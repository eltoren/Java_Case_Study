package be.iris.session.view;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;

@Remote
public interface ActivityBeanRemote {

	public void saveNewActivitie(Tutactivity activity);

	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity);

	public void updateListOfActivities(List<Tutactivity> activities, List<Tutactivity> newActivities);

	public List<Tutactivity> getAllActivities();

	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date);

	public List<Tutactivity> getAllActivitiesOfPerson(Tutperson person);

	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date);

	public List<Tutactivity> getAllActivitiesOfProject(Tutproject Project);

	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date);

	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project);

	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date);

	public void deleteActivity(Tutactivity activity);

	public void deleteListOfActivities(List<Tutactivity> activities);

	public void deleteActivitiesOnDate(LocalDate date);

	public void deleteActivitiesOfPerson(Tutperson person);

	public void deleteActivitiesOfPersonAtDate(Tutperson person, LocalDate date);

	public void deleteActivitiesOfProject(Tutproject project);

	public void deleteActivitiesOfProjectAtDate(Tutproject project, LocalDate date);

	public void deleteListOfActivitesOfPersonAtDate(Tutperson person, LocalDate date);
}
