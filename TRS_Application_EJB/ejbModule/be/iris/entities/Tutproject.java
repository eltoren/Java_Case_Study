package be.iris.entities;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Named
@RequestScoped
@Entity
@SequenceGenerator(name = "generatorKeys")
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="TUTPROJECTS")
public class Tutproject {

	@Id @GeneratedValue
	@Column(name="PID")
	private String pid;
	
	@Column(name="PROTITLE", columnDefinition="CHAR(40)")
	@NotNull
	private String ptitle;
	
	@OneToMany(targetEntity=Tutactivity.class, mappedBy="project")
	private List<Tutactivity> activities = new ArrayList<>();
	
	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public Tutproject(){}
	
	
	public Tutproject(String pid, String ptitle) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
	}

	
	public Tutproject(String ptitle) {
		super();
		this.ptitle = ptitle;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public List<Tutactivity> getActivities() {
		return activities;
	}

	public void setActivities(List<Tutactivity> activities) {
		this.activities = activities;
	}
	
	
	public void addActivity(Tutactivity activity){
		this.getActivities().add(activity);
		activity.setProject(this);
	}

	public void removeActivity(Tutactivity activity){
		this.getActivities().remove(activity);
		activity.setProject(null);
	}
}
