package be.iris.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.session.view.ProjectBeanRemote;

@Named
@RequestScoped
public class ActivitityController {

private String project;
	
	@Inject 
	private Tutactivity activity;
	
	@EJB
	private ProjectBeanRemote projectBean;
	
	@EJB
	private ActivityBeanRemote activityBean;
	
	@Inject 
	private CalendarView calendar;
	
	private List<Tutcours> listofProjects = new ArrayList<>();
	private List<String> listProjectsNames = new ArrayList<>();
	
	@Deprecated
	public void registerActivity(ActionEvent e){
		int day = calendar.getDate().getDate();
		int month = calendar.getDate().getMonth();
		int year = calendar.getDate().getYear();
			activity.setDate(LocalDate.of(year, month, day));
			
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
			if(project.equals(p.getPtitle())){
				activity.setProject(p);
				break;
			}
		
		}
	
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	

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
		System.out.println("YOHOU");
		if(listofProjects.isEmpty()){
			System.out.println("HELLo");
			this.setListofProjects(projectBean.getListInvoicedProject());
			for(Tutproject p : listofProjects){
				listProjectsNames.add(p.getPtitle());
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

	
}
