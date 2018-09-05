package be.iris.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutactivity;
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
	
	private List<Tutproject> listofProjects = new ArrayList<>();
	private List<String> listProjectsNames = new ArrayList<>();
	
	public void registerActivity(ActionEvent e){
		
		for(Tutproject p : listofProjects){
			if(project.equals(p.getProtitle())){
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
		if(listofProjects.isEmpty()){
			this.setListofProjects(projectBean.getAllProjects());
			for(Tutproject p : listofProjects){
				listProjectsNames.add(p.getProtitle());
			}
		}
		return listProjectsNames;
	}

	public void setListProjectsNames(List<String> listProjectsNames) {
		this.listProjectsNames = listProjectsNames;
	}

	
}
