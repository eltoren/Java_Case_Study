package be.iris.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Named
@RequestScoped
@Entity
@IdClass(WorkingDayPK.class)
@Table(name="TUTWORKING_DAYS")
@NamedQuery(name="TutworkingDay.listWorkingDays", query="SELECT w from TutworkingDay w")
public class TutworkingDay {


	@Id
	@ManyToOne
	@JoinColumn(name="pno")
	private Tutperson coworker;
	
	
	@Id
	@Column(name="WORKING_DATE", columnDefinition="DATE")
	private LocalDate date;
	
	@Column(name="START_TIME", columnDefinition="TIMESTAMP")
	@NotNull
	private LocalDateTime startTime;
	
	@Column(name="END_TIME", columnDefinition="TIMESTAMP")
	private LocalDateTime endTime;
	

	public TutworkingDay() {
	}

	public TutworkingDay(Tutperson coworker, LocalDate date, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.coworker = coworker;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Tutperson getCoworker() {
		return coworker;
	}

	public void setCoworker(Tutperson coworker) {
		this.coworker = coworker;
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
	
	
	
}
