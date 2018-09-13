package be.iris.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;
import be.iris.session.view.WorkingDayBeanRemote;

@Named
@RequestScoped
public class CalculationSalaryController {

	private List<TutworkingDay> workingDays = new ArrayList<>();

	private String personName;
	private LocalDate startOfMonth;
	private LocalDate endOfMonth;
	private float pricePerHour;
	private float salary;
	private Boolean dataTableSalary = false;
	
	

	@Inject
	private LoginController loginController;

	@Inject
	private CalendarView calendar;

	@EJB
	private WorkingDayBeanRemote workingDayBean;

	public CalculationSalaryController() {
	}

	@Deprecated
	private void dateConversionsSetter() {
		int month = calendar.getDate().getMonth() + 1;
		int year = calendar.getDate().getYear() + 1900;
		startOfMonth = LocalDate.of(year, month, 1);
		endOfMonth = startOfMonth.plusMonths(1).minusDays(1);
	}

	public void calculateSalarie() {
		/*dataTableSalary =true;
		this.dateConversionsSetter();
		loginController.setSelectedPersonfromList(personName);
		Tutperson p = loginController.getSelectedPersonList();
		workingDays = workingDayBean.getListWorkigDaysOfPersonBetweenStartDateANdEndDate(p.getPno(), startOfMonth,
				endOfMonth);
		float timeWorked = getHoursWorkedInMonth();
		salary = pricePerHour * timeWorked;*/
		dataTableSalary = true;
	}
	
	private float getHoursWorkedInMonth() {
		float timeWorked = 0;
		for (TutworkingDay workingDay : workingDays) {
			LocalDateTime startTime = workingDay.getStartTime().toLocalDateTime();
			LocalDateTime endTime = workingDay.getEndTime().toLocalDateTime();
			int hours = (endTime.getHour() - startTime.getHour());
			int minuts = (endTime.getMinute() - startTime.getMinute());
			timeWorked += hours + ((minuts/60)*100);
		}
		return timeWorked;
	}

	public List<TutworkingDay> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<TutworkingDay> workingDays) {
		this.workingDays = workingDays;
	}

	public String getName() {
		return personName;
	}

	public void setName(String personName) {
		this.personName = personName;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public CalendarView getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarView calendar) {
		this.calendar = calendar;
	}

	public LocalDate getStartOfMonth() {
		return startOfMonth;
	}

	public void setStartOfMonth(LocalDate startOfMonth) {
		this.startOfMonth = startOfMonth;
	}

	public LocalDate getEndOfMonth() {
		return endOfMonth;
	}

	public void setEndOfMonth(LocalDate endOfMonth) {
		this.endOfMonth = endOfMonth;
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Boolean getDataTableSalary() {
		return dataTableSalary;
	}

	public void setDataTableSalary(Boolean dataTableSalary) {
		this.dataTableSalary = dataTableSalary;
	}
	
}