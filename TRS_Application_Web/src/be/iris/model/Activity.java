package be.iris.model;

public class Activity {
	

	private long aid;

	private String actDate;

	private String actDescription;

	private String actEndTime;

	private String actStartTime;
	
	private long person;
	

	private String project;


	public long getAid() {
		return aid;
	}


	public void setAid(long aid) {
		this.aid = aid;
	}


	public String getActDate() {
		return actDate;
	}


	public void setActDate(String actDate) {
		this.actDate = actDate;
	}


	public String getActDescription() {
		return actDescription;
	}


	public void setActDescription(String actDescription) {
		this.actDescription = actDescription;
	}


	public String getActEndTime() {
		return actEndTime;
	}


	public void setActEndTime(String actEndTime) {
		this.actEndTime = actEndTime;
	}


	public String getActStartTime() {
		return actStartTime;
	}


	public void setActStartTime(String actStartTime) {
		this.actStartTime = actStartTime;
	}


	public long getPerson() {
		return person;
	}


	public void setPerson(long person) {
		this.person = person;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}
	




}