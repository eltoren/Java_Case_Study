package be.iris.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutcours;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.session.view.PersonBeanRemote;
import be.iris.session.view.PersonConectedBeanRemote;
import be.iris.session.view.ProjectBeanRemote;

@Named
@SessionScoped
public class ActionController implements Serializable{

	@EJB(name = "personBean")
	private PersonBeanRemote personBean;
	private String password;
	private String name;
	
	@EJB(name= "personConnectedBean")
	private PersonConectedBeanRemote personConnectedBean;
	
	private List<Tutperson> persons= new ArrayList<>();
	private List<String> listOfFirstNames = new ArrayList<>();
	private String project;
	@Inject 
	private Tutactivity activity;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	@EJB
	private ProjectBeanRemote projectBean;
	
	@EJB
	private ActivityBeanRemote activityBean;
	
	@Inject 
	private CalendarView calendar;
	
	private List<Tutcours> listofProjects = new ArrayList<>();
	private List<String> listProjectsNames = new ArrayList<>();
	
	

	

	public CalendarView getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarView calendar) {
		this.calendar = calendar;
	}

	public Tutactivity getActivity() {
		return activity;
	}

	public void setActivity(Tutactivity activity) {
		this.activity = activity;
	}

	public List<Tutcours> getListofProjects() {
		return listofProjects;
	}

	public void setListofProjects(List<Tutcours> listofProjects) {
		this.listofProjects = listofProjects;
	}

	public ProjectBeanRemote getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBeanRemote projectBean) {
		this.projectBean = projectBean;
	}

	public List<String> getListProjectsNames() {
		if(listofProjects.isEmpty()){
			this.setListofProjects(projectBean.getListInvoicedProject());
			for(Tutcours p : listofProjects){
				listProjectsNames.add(p.getCltitle());
			}
		}
		return listProjectsNames;
	}

	public void setListProjectsNames(List<String> listProjectsNames) {
		this.listProjectsNames = listProjectsNames;
	}

	private void sendAMessage(String msg, Severity error) {
		FacesMessage message = new FacesMessage(msg);
		message.setSeverity(error);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
	}

	
	public ActionController() {

	}

	public List<String> getListOfFirstNames() {
		if(persons.isEmpty()){
			persons = personBean.getAllPersons();
			for(Tutperson p : persons){
				listOfFirstNames.add(p.getPfname() + " " + p.getPlname());
			}
		}
		return listOfFirstNames;
	}

	public void setListOfFirstNames(List<String> listOfFirstNames) {
		
		this.listOfFirstNames = listOfFirstNames;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Tutperson> getPersons() {
		return persons;
	}

	public void setPersons(List<Tutperson> persons) {
		this.persons = persons;
	}

	public String login(){
		String firstName = name.split(" ")[0];
		String lastName = name.split(" ")[1];
		for(Tutperson p : persons){
			if(p.getPfname().equals(firstName) && p.getPlname().equals(lastName)){
				this.personConnectedBean.setConnectedPerson(p);
				break;
			}
		}
		if(personBean.iSLoginOk(this.personConnectedBean.getConnectedPerson(), password)){
			return "ActivityRegistration?faces-redirect=true";
		}else{
			this.sendAMessage("WRONG PASSWORD / EMAIL COMBINATION", FacesMessage.SEVERITY_ERROR);
			return "index";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonBeanRemote getPersonBean() {
		return personBean;
	}
	
	
	public void registerActivity(ActionEvent e){
		
		dateConversionsSetter();
		
			
		if(activity.getDate().isAfter(LocalDate.now())){
			this.sendAMessage("ENTER A VALID DATE, MAXIMUM IS TODAY", FacesMessage.SEVERITY_ERROR);
			return;
		}
		if(activity.getDate().getDayOfWeek().getValue() == 6 || activity.getDate().getDayOfWeek().getValue() == 7){
			this.sendAMessage("ENTER A VALID DATE, NOT A DAY OF THE WEEKEND", FacesMessage.SEVERITY_ERROR);
			return;
		}
		if(activity.getStartTime().toLocalTime().isAfter(LocalTime.of(20, 0)) || activity.getStartTime().toLocalTime().isBefore(LocalTime.of(5,0))){
			this.sendAMessage("ENTER A VALID STAR TIME, CANNOT WORK ON THE WRONGS HOURS", FacesMessage.SEVERITY_ERROR);
			return;
		}
		if(activity.getEndTime().toLocalTime().isAfter(LocalTime.of(20, 0)) || activity.getEndTime().toLocalTime().isBefore(LocalTime.of(5,0))){
			this.sendAMessage("ENTER A VALID END TIME, CANNOT WORK ON THE WRONGS HOURS", FacesMessage.SEVERITY_ERROR);
			return;
		}
//		for(Tutproject p : listofProjects){
//			if(project.equals(p.getPtitle())){
//				activity.setProject(p);
//				break;
//			}
		
//		}
		activity.setPerson(this.personConnectedBean.getConnectedPerson());
		
		try{
			activityBean.saveNewActivitie(activity);
		}catch(Exception ex){
			this.sendAMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	@Deprecated
	private void dateConversionsSetter() {
		int day = calendar.getDate().getDate();
		int month = calendar.getDate().getMonth();
		int year = calendar.getDate().getYear();
		LocalDate date = LocalDate.of(year, month, day);
		activity.setDate(date);
		activity.setStartTime(LocalDateTime.of(date, startTime));
		activity.setEndTime(LocalDateTime.of(date, endTime));
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	
	
	
}
