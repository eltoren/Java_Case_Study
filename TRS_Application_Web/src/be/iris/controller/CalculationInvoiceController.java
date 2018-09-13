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
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutcours;
import be.iris.session.view.ProjectBeanRemote;

@Named
@RequestScoped
public class CalculationInvoiceController {

	private List<Tutactivity> activities = new ArrayList<>();

	private String projectName;
	private LocalDate startOfMonth;
	private LocalDate endOfMonth;
	private float pricePerHour;
	private float price;

	@Inject
	private CalendarView calendar;

	@EJB
	private ProjectBeanRemote projectBean;

	public CalculationInvoiceController() {
	}

	@Deprecated
	private void dateConversionsSetter() {
		int month = calendar.getDate().getMonth() + 1;
		int year = calendar.getDate().getYear() + 1900;
		startOfMonth = LocalDate.of(year, month, 1);
		endOfMonth = startOfMonth.plusMonths(1).minusDays(1);
	}

	public void calculateInvoice() {
		this.dateConversionsSetter();
		Tutcours c = projectBean.getInvoicedProject(projectName);
		
		activities =  c.getProject().getActivities();
		this.filterActivitiesInMonth();
		
			
		
		float timeWorked = getHoursWorkedOnProject();
		price = pricePerHour * timeWorked;
	}	
	
	private void filterActivitiesInMonth() {
		List<Tutactivity> list = new ArrayList<>();
		for (Tutactivity tutactivity : activities) {
			LocalDate actDate = tutactivity.getActDate().toLocalDate();
			if (actDate.isAfter(startOfMonth.minusDays(1)) && actDate.isBefore(endOfMonth.plusDays(1))) {
				list.add(tutactivity);
			}
		}
		this.setActivities(list);
	}
	
	private float getHoursWorkedOnProject() {
		float timeWorked = 0;
		for (Tutactivity activity : activities) {
			LocalDateTime startTime = activity.getActStartTime().toLocalDateTime();
			LocalDateTime endTime = activity.getActEndTime().toLocalDateTime();
			int hours = (endTime.getHour() - startTime.getHour());
			int minuts = (endTime.getMinute() - startTime.getMinute());
			timeWorked += hours + ((minuts/60)*100);
		}
		return timeWorked;
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
		return price;
	}

	public void setSalary(float salary) {
		this.price = salary;
	}

	public List<Tutactivity> getActivities() {
		return activities;
	}

	public void setActivities(List<Tutactivity> list) {
		this.activities = list;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}