package be.iris.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Named
@Entity
@Table(name="TUTACTIVITIES")
@NamedQuery(name="Tutactivity.ListActivities", query="SELECT a from Tutactivity a")
public class Tutactivity {

	@Id
	@GeneratedValue
	@Column(name="AID")
	private int activityId;
	
	@Inject
	@Column(name="ACT_PNO")
	@ManyToOne
	@JoinColumn(name="PNO")
	private Tutperson person;
	
	@NotNull
	@Column(name="ACT_DATE")
	private LocalDate date;
	
	@NotNull
	@Column(name="ACT_START_TIME")
	private LocalTime startTime;
	
	@NotNull
	@Column(name="ACT_END_TIME")
	private LocalTime endTime;
	
	@Inject
	@Column(name="ACT_PID")
	@ManyToOne
	@JoinColumn(name="PID")
	private Tutproject project;
	
	@Column(name="ACT_DESCRIPTION", columnDefinition="CHAR(40)")
	@NotNull
	private String description;

	public Tutactivity() {
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	
	 public Tutperson getPerson() {
		return person;
	 }
	
	 public void setPerson(Tutperson person) {
	 this.person = person;
	 }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public Tutproject getProject() {
		return project;
	}

	public void setProject(Tutproject project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", description=" + description
				+ person.getPfname() + " " + person.getPlname() +   "]";
	}

}