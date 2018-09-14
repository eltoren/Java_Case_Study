package be.iris.session.view;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.TutworkingDay;
import be.iris.exceptions.WorkingDayException;

@Remote
public interface WorkingDayBeanRemote {
	
	public void StartNewWorkingDay(long pno) throws WorkingDayException;
	
	public void endWorkingDay(long pno) throws WorkingDayException;
	
	public void removeWorkingDay(long person, LocalDate date);
	
	public void removeWorkingDay(TutworkingDay workingDay);
	
	public TutworkingDay getWorkingDay(TutworkingDay workingDay);
	
	public List<TutworkingDay> getAllWorkingDays();
	
	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date);

	public List<TutworkingDay> getListWorkigDaysOfPerson(long person);

	public TutworkingDay getWorkigDaysOfPersonAtDate(long person, LocalDate date);

	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate);

	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(long person,
			LocalDate startDate, LocalDate endDate);
	
	public float getHoursWorkedInMonth(long person, LocalDate startDate, LocalDate endDate);

}
