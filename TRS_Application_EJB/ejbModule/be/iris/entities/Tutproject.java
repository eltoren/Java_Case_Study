 package be.iris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the TUTPROJECTS database table.
 * 
 */

@Entity(name="Tutproject")
@Table(name="TUTPROJECTS")
@NamedQuery(name="Tutproject.findAll", query="SELECT t FROM Tutproject t")
//@XmlRootElement(name="project")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Tutproject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pid;

	private String protitle;

//	@XmlTransient
	@OneToMany(targetEntity=Tutactivity.class,mappedBy="project",fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
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