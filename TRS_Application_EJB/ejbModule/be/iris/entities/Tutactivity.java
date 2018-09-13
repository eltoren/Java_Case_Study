package be.iris.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the TUTACTIVITIES database table.
 * 
 */

@Entity(name="Tutactivity")
@Table(name="TUTACTIVITIES")
public class Tutactivity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7720086255696017210L;

	@Id
	@GeneratedValue
	private long aid;

	@Column(name="ACT_DATE")
	private Date actDate;

	@Column(name="ACT_DESCRIPTION")
	private String actDescription;

	@Column(name="ACT_END_TIME")
	private Timestamp actEndTime;

	@Column(name="ACT_START_TIME")
	private Timestamp actStartTime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PNO")
	private Tutperson person;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PID")
	private Tutproject project;
	

	public Tutactivity() {
	}

	public long getAid() {
		return this.aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public Date getActDate() {
		return this.actDate;
	}

	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}

	public String getActDescription() {
		return this.actDescription;
	}

	public void setActDescription(String actDescription) {
		this.actDescription = actDescription;
	}

	public Timestamp getActEndTime() {
		return this.actEndTime;
	}

	public void setActEndTime(Timestamp actEndTime) {
		this.actEndTime = actEndTime;
	}

	public Timestamp getActStartTime() {
		return this.actStartTime;
	}

	public void setActStartTime(Timestamp actStartTime) {
		this.actStartTime = actStartTime;
	}

	public Tutperson getPerson() {
		return person;
	}

	public void setPerson(Tutperson person) {
		this.person = person;
	}

	public Tutproject getProject() {
		return project;
	}

	public void setProject(Tutproject project) {
		this.project = project;
	}



}