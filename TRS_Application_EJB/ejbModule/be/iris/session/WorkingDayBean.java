package be.iris.session;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.WorkingDayDao;
import be.iris.entities.Tutperson;
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

	/*@Override
	public void StartNewWorkingDay(TutworkingDay workingDay) {
		workingDayDao.insertWorkingDay(workingDay);
	}
*/
	@Override
	public void endWorkingDay(long person) throws WorkingDayException {
//		TutworkingDay oldWorkingDay = workingDayDao.getWorkigDaysOfPersonAtDate(person, LocalDate.now());
//		TutworkingDay newWorkingDay = oldWorkingDay;
//		newWorkingDay.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
		workingDayDao.updateWorkingDay(person);
	}

	/*@Override
	public void endWorkingDay(TutworkingDay workingDay, long pno) {
		TutworkingDay oldWorkingDay = workingDay;
		TutworkingDay newWorkingDay = workingDay;
		newWorkingDay.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
		workingDayDao.updateWorkingDay(newWorkingDay, pno);
	}*/
/*
	@Override
	public void changeWorkingDay(TutworkingDay oldWorkingDay, TutworkingDay newWorkingDay) {
		workingDayDao.updateWorkingDay(oldWorkingDay, newWorkingDay);
	}*/

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

}
