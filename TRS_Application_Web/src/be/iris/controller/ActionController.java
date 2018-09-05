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
import be.iris.utilities.DateFormat;

@Named
@SessionScoped
public class ActionController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8804029671948475633L;
	@EJB(name = "personBean")
	private PersonBeanRemote personBean;
	private String password;
	private String name;
	
	@EJB(name= "personConnectedBean")
	private PersonConectedBeanRemote personConnectedBean;
	
	private List<Tutperson> persons= new ArrayList<>();
	private List<String> listOfFirstNames = new ArrayList<>();
	@Inject 
	@Named("activity")
	private Tutactivity activity;
	
	@Inject
	@Named("project")
	private Tutproject projectActivity;

	@Inject
	@Named("person")
	private Tutperson personConnected;
	private String project;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	private String activityName;
	@EJB
	private ProjectBeanRemote projectBean;
	
	@EJB
	private ActivityBeanRemote activityBean;
	
	@Inject 
	private CalendarView calendar;
	
	private List<Tutproject> listofProjects = new ArrayList<>();
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

	public List<Tutproject> getListofProjects() {
		return listofProjects;
	}

	public void setListofProjects(List<Tutproject> listofProjects) {
		this.listofProjects = listofProjects;
	}

	public ProjectBeanRemote getProjectBean() {
		return projectBean;
	}

	public void setProjectBean(ProjectBeanRemote projectBean) {
		this.projectBean = projectBean;
	}

	public List<String> getListProjectsNames() {
		if(listProjectsNames.isEmpty()){
			listofProjects = projectBean.getAllProjects();
			for(Tutproject p : listofProjects){
				listProjectsNames.add(p.getProtitle());
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
				personConnected = p;
				break;
			}
		}
		if(personBean.iSLoginOk(personConnected, password)){
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
		activity.setDescription(activityName);
		activity.setPerson(personConnected);
			
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
		for(Tutproject p : listofProjects){
			if(project.equals(p.getProtitle())){
				p.addActivity(activity);
				break;
		}
		
		}
		System.out.println(personConnected.getPfname());
		try{
			activityBean.saveNewActivitie(activity);
		}catch(Exception ex){
			this.sendAMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	@Deprecated
	private void dateConversionsSetter() {
		int day = calendar.getDate().getDate() + 1;
		int month = calendar.getDate().getMonth() +1;
		int year = calendar.getDate().getYear() + 1900;
		LocalDate date = LocalDate.of(year, month, day);
		activity.setDate(date);
		activity.setStartTime(LocalDateTime.of(date, startTime));
		activity.setEndTime(LocalDateTime.of(date, endTime));
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

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Tutproject getProjectActivity() {
		return projectActivity;
	}

	public void setProjectActivity(Tutproject projectActivity) {
		this.projectActivity = projectActivity;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProject() {
		return project;
	}
	
	
	
}
