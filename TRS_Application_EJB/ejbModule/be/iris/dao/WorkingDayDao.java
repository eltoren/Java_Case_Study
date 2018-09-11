package be.iris.dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;
import be.iris.exceptions.NoWorkingDayInProgressException;

@Local
public interface WorkingDayDao {

	public void insertWorkingDay(TutworkingDay workingDay, long person);

	public void updateWorkingDay(long person) throws NoWorkingDayInProgressException;

	public void deleteWorkingDay(TutworkingDay workingDay);

	public TutworkingDay getWorkigDay(TutworkingDay workingDay);

	public List<TutworkingDay> listAllWorkigDays();

	// extra methods

	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date);

	public List<TutworkingDay> getListWorkigDaysOfPerson(long person);

	public TutworkingDay getWorkigDaysOfPersonAtDate(long person, LocalDate date);

	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate);

	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(long person,
			LocalDate startDate, LocalDate endDate);

}
