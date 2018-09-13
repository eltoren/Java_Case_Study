package be.iris.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.exceptions.ActivityException;

@Local
public interface ActivityDao {

	public void insertActivity(Tutactivity activity, String pid, long pno)
			throws ActivityException ;

	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity);

	public void deleteActivity(Tutactivity activity);

	public List<Tutactivity> listAllActivity();
	
	//extra methods

	public List<Tutactivity> getAllActivitiesAtDate(LocalDate date);

	public List<Tutactivity> getAllActivitiesOfPerson(long person)
			throws ActivityException ;

	public List<Tutactivity> getAllActivitiesOfPersonAtDate(Tutperson person, LocalDate date);

	public List<Tutactivity> getAllActivitiesOfProject(String project)
			throws ActivityException ;

	public List<Tutactivity> getAllActivitiesOfProjectAtDate(Tutproject project, LocalDate date);

	public List<Tutactivity> getAllActivitiesOfPersonWorkingAtProject(Tutperson person, Tutproject project);

	public List<Tutactivity> getAllActivitiesOfPersonWorkigAtProjectOnDate(Tutperson person, Tutproject project,
			LocalDate date);

	public void deleteListOfActivitiesOnDate(LocalDate date);

	public void deleteListOfActivitiesOfPerson(Tutperson person);

	public void deleteListOfActivitiesOfProject(Tutproject project);

	public void deleteListOfActivitiesofProjectAtDate(Tutproject project, LocalDate date);

	public void deleteListOfActivitiesOfPersonAtDate(Tutperson person, LocalDate date);
}
