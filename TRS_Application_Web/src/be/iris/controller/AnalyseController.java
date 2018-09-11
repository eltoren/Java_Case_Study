package be.iris.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;

import be.iris.entities.Tutactivity;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;

@Named
@RequestScoped
public class AnalyseController {

	private List<Tutactivity> listingActivities = new ArrayList<>();

	private String name;
	
	private Tutproject tutproject;

	@EJB
	private ActivityBeanRemote activityBean;
	
	public AnalyseController() {
		tutproject = new Tutproject();
	}

	public List<Tutactivity> getListingActivities() {
		return listingActivities;
	}

	public void setListingActivities(List<Tutactivity> listingActivities) {
		this.listingActivities = listingActivities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tutproject getTutproject() {
		return tutproject;
	}

	public void setTutproject(Tutproject tutproject) {
		this.tutproject = tutproject;
	}
	
	public void personsChangeListener(ValueChangeListener e){
		
	}
	
	public void projectsChangeListener(ValueChangeListener e){
		
	}
}
