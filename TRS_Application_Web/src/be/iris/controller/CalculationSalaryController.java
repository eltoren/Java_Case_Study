package be.iris.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.entities.TutworkingDay;
import be.iris.exceptions.ActivityException;
import be.iris.model.Activity;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.session.view.WorkingDayBeanRemote;
import be.iris.utilities.DateFormat;

@Named
@RequestScoped
public class CalculationSalaryController {

	private List<TutworkingDay> workingDays = new ArrayList<>();

	private String name;
	private LocalDate startOfMonth;
	private LocalDate endOfMonth;
	private float pricePerHour;
	private float salary;
	private Boolean dataTableSalary = false;
	
	

	@Inject
	private LoginController loginController;

	@Inject
	private ActionController actionController;

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
		loginController.setSelectedPersonfromList(name);
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public ActionController getActionController() {
		return actionController;
	}

	public void setActionController(ActionController actionController) {
		this.actionController = actionController;
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