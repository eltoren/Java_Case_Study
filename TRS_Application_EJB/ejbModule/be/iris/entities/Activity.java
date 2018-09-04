package be.iris.entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Activity {

	@Id
	@GeneratedValue
	private int activityId;
	// private Person person;
	private LocalDate date;
	private String startTime;
	private String endTime;
	// private Project project;
	private String description;

	public Activity() {
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	// public Person getPerson() {
	// return person;
	// }
	//
	// public void setPerson(Person person) {
	// this.person = person;
	// }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	// public Project getProject() {
	// return project;
	// }
	//
	// public void setProject(Project project) {
	// this.project = project;
	// }

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
				+ /*
					 * ", project=" + project.getTitle() + ", Person=" +
					 * Person.getFirstName + " " + Person.getLastName() +
					 */ "]";
	}

}