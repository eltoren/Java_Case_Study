package be.iris.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(WorkingDayPK.class)
@Table(name="TUTWORKING_DAYS")
@NamedQuery(name="TutworkingDay.listWorkingDays", query="SELECT w from TutworkingDay w")
public class TutworkingDay {


	@Id
	@ManyToOne
	@JoinColumn(name="PNO")
	private Tutperson coworker;
	
	
	@Id
	@Column(name="WORKING_DATE")
	private Date date;
	
	
	@Column(name="START_TIME")
	@NotNull
	private Timestamp startTime;
	
	@Column(name="END_TIME")
	private Timestamp endTime;
	

	public TutworkingDay() {
	}

	public TutworkingDay(Tutperson coworker, LocalDate date, Timestamp startTime, Timestamp endTime) {
		super();
		this.coworker = coworker;
		this.date = Date.valueOf(date);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Tutperson getCoworker() {
		return coworker;
	}

	public void setCoworker(Tutperson coworker) {
		this.coworker = coworker;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDate(LocalDate date) {
		this.date = Date.valueOf(date);
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
	
}
