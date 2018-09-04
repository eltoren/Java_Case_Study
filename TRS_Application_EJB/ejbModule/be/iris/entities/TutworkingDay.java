package be.iris.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Named
@Entity
@IdClass(WorkingDayPK.class)
@Table(name="TUTWORKING_DAYS")
public class TutworkingDay {

	@Inject
	@Id
	@Column(name="WORKING_PNO")
	@OneToOne
	@JoinColumn(name="pno")
	@NotNull
	private Tutperson personId;
	
	
	@Id
	@Column(name="WORKING_DATE")
	@NotNull
	private LocalDate date;
	
	@Column(name="START_TIME", columnDefinition="TIMESTAMP")
	@NotNull
	private LocalTime startTime;
	
	@Column(name="END_TIME", columnDefinition="TIMESTAMP")
	@NotNull
	private LocalTime endTime;
	

	public TutworkingDay() {
	}

	public TutworkingDay(Tutperson personId, LocalDate date, LocalTime startTime, LocalTime endTime) {
		super();
		this.personId = personId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Tutperson getPersonId() {
		return personId;
	}

	public void setPersonId(Tutperson personId) {
		this.personId = personId;
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
	
	
	
}
