package be.iris.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;
import be.iris.model.SalaryInput;
import be.iris.model.SalaryResult;
import be.iris.session.view.WorkingDayBeanRemote;

@SuppressWarnings("serial")
@Named("calculationSalaryController")
@SessionScoped
public class CalculationSalaryController implements Serializable {

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

	public String calculateSalary() {
		dataTableSalary = true;
		this.dateConversionsSetter();
		Tutperson p = this.rightPerson();
		float timeWorked = workingDayBean.getHoursWorkedInMonth(p.getPno(), startOfMonth, endOfMonth);
		Client client = ClientBuilder.newClient();
		
		String baseUri = "http://localhost:9080/salaryapi/salaryservice/salaries";
		WebTarget target = client.target(baseUri);
		
		SalaryInput input = new SalaryInput(timeWorked,pricePerHour);
		
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);	
		Response response = builder.post(Entity.entity(input,MediaType.APPLICATION_JSON));
		SalaryResult result = response.readEntity(SalaryResult.class);
		salary = (float) result.getSalary();
		return "CalculationSalary";
		
	}
	


	public List<TutworkingDay> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<TutworkingDay> workingDays) {
		this.workingDays = workingDays;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
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

	public Tutperson rightPerson(){
		Tutperson person = null;
		String[] names = personName.split(" ");
		String firstName = names[0];
		String lastName ="";
		for(int i =1; i < names.length; i++){
			lastName += names[i];
		}
			
		for(Tutperson p : loginController.getPersons()){
			if(firstName.trim().equalsIgnoreCase(p.getPfname().trim()) && 
					lastName.trim().equalsIgnoreCase(p.getPlname().trim())){
						person = p;
						break;
					}
		}
		if(person == null){
			return null;
		}else{
			return person;
		}
	}
}