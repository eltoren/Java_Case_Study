package be.iris.entities;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
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
@RequestScoped
@Entity
@Table(name="TUTACTIVITIES")
@NamedQuery(name="Tutactivity.ListActivities", query="SELECT a from Tutactivity a")
public class Tutactivity {

	@Id
	@GeneratedValue
	@Column(name="AID")
	private int activityId;
	
	@ManyToOne
	@JoinColumn(name="PNO")
	private Tutperson person;
	
	@NotNull
	@Column(name="ACT_DATE", columnDefinition="DATE")
	private LocalDate date;
	
	@NotNull
	@Column(name="ACT_START_TIME", columnDefinition="TIMESTAMP")
	private LocalDateTime startTime;
	
	@NotNull
	@Column(name="ACT_END_TIME", columnDefinition="TIMESTAMP")
	private LocalDateTime endTime;
	
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
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