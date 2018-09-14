package be.iris.session;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.WorkingDayDao;
import be.iris.entities.TutworkingDay;
import be.iris.exceptions.WorkingDayException;
import be.iris.session.view.WorkingDayBeanRemote;

@Stateless(mappedName = "workingDayBean")
public class WorkingDayBean implements WorkingDayBeanRemote {

	@EJB(name = "workingDayDaoImpl")
	private WorkingDayDao workingDayDao;

	public WorkingDayBean() {
	}

	@Override
	public void StartNewWorkingDay(long person) throws WorkingDayException {
		TutworkingDay workingDay = new TutworkingDay();
		workingDay.setDate(LocalDate.now());
		workingDay.setStartTime(Timestamp.valueOf(LocalDateTime.now()));
		workingDayDao.insertWorkingDay(workingDay, person);
	}

	@Override
	public void endWorkingDay(long person) throws WorkingDayException {
		workingDayDao.updateWorkingDay(person);
	}


	@Override
	public void removeWorkingDay(long person, LocalDate date) {
		TutworkingDay workingDay = workingDayDao.getWorkigDaysOfPersonAtDate(person, date);
		workingDayDao.deleteWorkingDay(workingDay);
	}

	@Override
	public void removeWorkingDay(TutworkingDay workingDay) {
		workingDayDao.deleteWorkingDay(workingDay);
	}

	@Override
	public TutworkingDay getWorkingDay(TutworkingDay workingDay) {
		return workingDayDao.getWorkigDay(workingDay);
	}

	@Override
	public List<TutworkingDay> getAllWorkingDays() {
		return workingDayDao.listAllWorkigDays();
	}

	@Override
	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date) {
		return workingDayDao.getListWorkingDaysAtDate(date);
	}

	@Override
	public List<TutworkingDay> getListWorkigDaysOfPerson(long person) {
		return workingDayDao.getListWorkigDaysOfPerson(person);
	}

	@Override
	public TutworkingDay getWorkigDaysOfPersonAtDate(long person, LocalDate date) {
		return workingDayDao.getWorkigDaysOfPersonAtDate(person, date);
	}

	@Override
	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate) {
		return workingDayDao.getListWorkigDaysBetweenStartDateANdEndDate(startDate, endDate);
	}

	@Override
	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(long person,
			LocalDate startDate, LocalDate endDate) {
		return workingDayDao.getListWorkigDaysOfPersonBetweenStartDateANdEndDate(person, startDate, endDate);
	}

	
	public float getHoursWorkedInMonth(long person, LocalDate startDate, LocalDate endDate) {
		float timeWorked = 0;
		for (TutworkingDay workingDay : this.getListWorkigDaysOfPersonBetweenStartDateANdEndDate(person, startDate, endDate)) {
			LocalDateTime startTime = workingDay.getStartTime().toLocalDateTime();
			LocalDateTime endTime = workingDay.getEndTime().toLocalDateTime();
			int hours = (endTime.getHour() - startTime.getHour());
			int minuts = (endTime.getMinute() - startTime.getMinute());
			timeWorked += hours + ((minuts/60)*100);
		}
		return timeWorked;
	}

}
