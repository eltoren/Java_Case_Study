package be.iris.session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.WorkingDayDao;
import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;
import be.iris.session.view.WorkingDayBeanRemote;

@Stateless(mappedName = "workingDayBean")
public class WorkingDayBean implements WorkingDayBeanRemote {

	@EJB(name = "workingDayDaoImpl")
	private WorkingDayDao workingDayDao;

	public WorkingDayBean() {
	}

	@Override
	public void StartNewWorkingDay(Tutperson person) {
		TutworkingDay workingDay = new TutworkingDay(person, LocalDate.now(), LocalDateTime.now(), null);
		workingDayDao.insertWorkingDay(workingDay);
	}

	@Override
	public void StartNewWorkingDay(TutworkingDay workingDay) {
		workingDayDao.insertWorkingDay(workingDay);
	}

	@Override
	public void endWorkingDay(Tutperson person) {
		TutworkingDay oldWorkingDay = workingDayDao.getWorkigDaysOfPersonAtDate(person, LocalDate.now());
		TutworkingDay newWorkingDay = oldWorkingDay;
		newWorkingDay.setEndTime(LocalDateTime.now());
		workingDayDao.updateWorkingDay(oldWorkingDay, newWorkingDay);
	}

	@Override
	public void endWorkingDay(TutworkingDay workingDay) {
		TutworkingDay oldWorkingDay = workingDay;
		TutworkingDay newWorkingDay = workingDay;
		newWorkingDay.setEndTime(LocalDateTime.now());
		workingDayDao.updateWorkingDay(oldWorkingDay, newWorkingDay);
	}

	@Override
	public void changeWorkingDay(TutworkingDay oldWorkingDay, TutworkingDay newWorkingDay) {
		workingDayDao.updateWorkingDay(oldWorkingDay, newWorkingDay);
	}

	@Override
	public void removeWorkingDay(Tutperson person, LocalDate date) {
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
	public List<TutworkingDay> getListWorkigDaysOfPerson(Tutperson person) {
		return workingDayDao.getListWorkigDaysOfPerson(person);
	}

	@Override
	public TutworkingDay getWorkigDaysOfPersonAtDate(Tutperson person, LocalDate date) {
		return workingDayDao.getWorkigDaysOfPersonAtDate(person, date);
	}

	@Override
	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate) {
		return workingDayDao.getListWorkigDaysBetweenStartDateANdEndDate(startDate, endDate);
	}

	@Override
	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(Tutperson person,
			LocalDate startDate, LocalDate endDate) {
		return workingDayDao.getListWorkigDaysOfPersonBetweenStartDateANdEndDate(person, startDate, endDate);
	}

}
