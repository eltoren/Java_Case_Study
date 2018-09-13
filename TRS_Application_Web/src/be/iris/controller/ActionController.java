package be.iris.controller;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
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
import be.iris.entities.Tutproject;
import be.iris.exceptions.ActivityException;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.session.view.ProjectBeanRemote;
import be.iris.utilities.DateFormat;

@Named
@SessionScoped
public class ActionController implements Serializable {

	private static final long serialVersionUID = -8804029671948475633L;
	private Tutactivity activity;
	private Tutproject projectActivity;
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

	@Inject
	private LoginController loginController;

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
		if (listProjectsNames.isEmpty()) {
			listofProjects = projectBean.getAllProjects();
			for (Tutproject p : listofProjects) {
				listProjectsNames.add(p.getProtitle());
			}
		}
		return listProjectsNames;
	}

	public void setListProjectsNames(List<String> listProjectsNames) {
		this.listProjectsNames = listProjectsNames;
	}

	
	public void sendAMessage(String msg, Severity error) {
		FacesMessage message = new FacesMessage(msg);
		message.setSeverity(error);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
	}

	public ActionController() {
		activity = new Tutactivity();
		projectActivity = new Tutproject();
	}

	public void registerActivity(ActionEvent e) {
		activity = new Tutactivity();
		if(dateConversionsSetter()){
		activity.setActDescription(activityName);
		for (Tutproject p : listofProjects) {
			if (project.equals(p.getProtitle())) {
				project = p.getPid();
				break;
			}
		}
		try {
			activityBean.saveNewActivitie(activity, project, loginController.getPersonSelected().getPno());
			this.sendAMessage("Acitivity registered", FacesMessage.SEVERITY_INFO);
		} catch (ActivityException ex) {
			this.sendAMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
		}
	}

	@Deprecated
	private boolean dateConversionsSetter() {
		System.out.println(startTime.format(DateFormat.dtfHours));
		boolean returnedValue = true;
		int day = calendar.getDate().getDate();
		int month = calendar.getDate().getMonth() +1;
		int year = calendar.getDate().getYear() + 1900;
		LocalDate date = LocalDate.of(year, month, day);
		LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
		LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
		if (date.isAfter(LocalDate.now())) {
			this.sendAMessage("ENTER A VALID DATE, MAXIMUM IS TODAY", FacesMessage.SEVERITY_ERROR);
			returnedValue = false;
		}
		if (date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) {
			this.sendAMessage("ENTER A VALID DATE, NOT A DAY OF THE WEEKEND", FacesMessage.SEVERITY_ERROR);
			returnedValue = false;
		}
		if (startTime.isAfter(LocalTime.of(20, 0)) || startTime.isBefore(LocalTime.of(5, 0))) {
			this.sendAMessage("ENTER A VALID STAR TIME, CANNOT WORK ON THE WRONGS HOURS", FacesMessage.SEVERITY_ERROR);
			returnedValue = false;
		}
		if (endTime.isAfter(LocalTime.of(20, 0)) || endTime.isBefore(LocalTime.of(5, 0))) {
			this.sendAMessage("ENTER A VALID END TIME, CANNOT WORK ON THE WRONGS HOURS", FacesMessage.SEVERITY_ERROR);
			returnedValue = false;
		}
		if(endTime.isBefore(startTime)){
			this.sendAMessage("ENTER VALID HOURS, CANNOT END BEFORE BEGINNING RIGHT ?", FacesMessage.SEVERITY_ERROR);
			returnedValue = false;
		}
		activity.setActDate(Date.valueOf(date));
		activity.setActStartTime(Timestamp.valueOf(startDateTime));
		activity.setActEndTime(Timestamp.valueOf(endDateTime));
		return returnedValue;
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

	public String checkIn() {

		return "MainPage";
	}

	public String checkOut() {

		return "MainPage";
	}

}
