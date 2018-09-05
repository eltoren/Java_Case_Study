package be.iris.dao;

import java.time.LocalDate;
import java.util.List;

import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;

public interface WorkingDayDao {
	
	public void insertWorkingDay(TutworkingDay workingDay);
	
	public void updateWorkingDay(TutworkingDay oldWorkingDay, TutworkingDay newWorkingDay);
	
	public void deleteWorkingDay(TutworkingDay workingDay);
	
	public TutworkingDay getWorkigDay(TutworkingDay workingDay);
	
	public List<TutworkingDay> listAllWorkigDays();
	
	// extra methods
	
	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date);
	
	public List<TutworkingDay> getListWorkigDaysOfPerson(Tutperson person);
	
	public TutworkingDay getWorkigDaysOfPersonAtDate(Tutperson person, LocalDate date);
	
	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate);
	
	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(Tutperson person, LocalDate startDate, LocalDate endDate);

	
}
