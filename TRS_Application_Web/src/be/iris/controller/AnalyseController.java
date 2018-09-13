package be.iris.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.exceptions.ActivityException;
import be.iris.model.Activity;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.utilities.DateFormat;

@Named
@RequestScoped
public class AnalyseController {


	private List<Activity> listingActivities = new ArrayList<>();
	private List<String> descList = new ArrayList<>();
	private String name;
	
	@Inject
	private LoginController loginController;
	
	@Inject
	private ActionController actionController;
	
	private String project;


	@EJB
	private ActivityBeanRemote activityBean;
	
	public AnalyseController() {
	}

	public List<Activity> getListingActivities() {
		return listingActivities;
	}

	public void setListingActivities(List<Activity> listingActivities) {
		this.listingActivities = listingActivities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void personsChangeListener(AjaxBehaviorEvent e){
		loginController.setSelectedPersonfromList(name);
		Tutperson p = loginController.getSelectedPersonList();
		try{
		List<Tutactivity> list =activityBean.getAllActivitiesOfPerson(p.getPno());
		this.setListingActivities(ListActivityFromEntities(list));		
		}catch(ActivityException ae){
			actionController.sendAMessage(ae.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public void projectsChangeListener(AjaxBehaviorEvent e){
		String pid = "";
		project =(String) e.getComponent().getAttributes().get("value");
		for(Tutproject p : actionController.getListofProjects()){
			String qName = p.getProtitle();
			if(project.equals(qName)){
				pid = p.getPid();
				break;
			}
		}
		try{
			List<Tutactivity> list = activityBean.getAllActivitiesOfProject(pid);
			this.setListingActivities(ListActivityFromEntities(list));
		}catch(ActivityException ae){
				actionController.sendAMessage(ae.getMessage(), FacesMessage.SEVERITY_ERROR);
			}
		
	}

	public List<Activity> ListActivityFromEntities(List<Tutactivity> activities){
		List<Activity> list = new ArrayList<>();
		for(Tutactivity a : activities){
			Activity act = new Activity();
			act.setAid(a.getAid());
			act.setPerson(a.getPerson().getPno());
			act.setProject(a.getProject().getPid());
			act.setActDescription(a.getActDescription());
			act.setActDate(a.getActDate().toLocalDate().format(DateFormat.dtfDays));
			act.setActStartTime(a.getActStartTime().toLocalDateTime().toLocalTime().format(DateFormat.dtfHours));
			act.setActEndTime(a.getActEndTime().toLocalDateTime().toLocalTime().format(DateFormat.dtfHours));
			list.add(act);
		}
		return list;
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

	public List<String> getDescList() {
		return descList;
	}

	public void setDescList(List<String> descList) {
		this.descList = descList;
	}
	
	
}
