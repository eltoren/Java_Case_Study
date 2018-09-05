 package be.iris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the TUTPROJECTS database table.
 * 
 */
@Named("project")
@RequestScoped
@Entity
@Table(name="TUTPROJECTS")
@NamedQuery(name="Tutproject.findAll", query="SELECT t FROM Tutproject t")
public class Tutproject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pid;

	private String protitle;

	@OneToMany(targetEntity=Tutactivity.class,mappedBy="project",fetch=FetchType.EAGER)
	private List<Tutactivity> activities = new ArrayList<>();
	public Tutproject() {
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getProtitle() {
		return this.protitle;
	}

	public void setProtitle(String protitle) {
		this.protitle = protitle;
	}
	

	
	public List<Tutactivity> getActivities() {
		return activities;
	}

	public void setActivities(List<Tutactivity> activities) {
		this.activities = activities;
	}
	
	
	public void addActivity(Tutactivity activity){
		activities.add(activity);
		activity.setProject(this);
	}

	public void removeActivity(Tutactivity activity){
		this.getActivities().remove(activity);
		activity.setProject(null);
	}

	

}