package be.iris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the TUTPERSONS database table.
 * 
 */
@Named
@RequestScoped
@Entity
@Table(name="TUTPERSONS")
@NamedQuery(name="Tutperson.findAll", query="SELECT t FROM Tutperson t ")
@NamedNativeQuery(name="Tutperson.findPersonsLogs", query="SELECT * from tutpersons t where t.pno in (select p.pass_pno from tutpasswords p)",
resultClass=Tutperson.class)
public class Tutperson implements Serializable {
	private static final long serialVersionUID = 1L;

	//id, bi-directional one-to-one association to tutworkingday
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pno;

	private String padept;

	private String pfname;

	private String pfunc;

	@NotNull
	private String plname;

	private String psex;

	private String ptel;

	@OneToOne(mappedBy="tutperson")
	private Tutcompany cocPno;

	//bi-directional many-to-one association to Tutcompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PA_CONO")
	private Tutcompany tutcompany;
	
	@OneToMany(targetEntity=Tutactivity.class, mappedBy="person")
	private List<Tutactivity> activities = new ArrayList<>();
	
	@OneToMany(targetEntity=TutworkingDay.class, mappedBy="personId")
	private List<TutworkingDay> listWorkingDays = new ArrayList<>();  
	
	public Tutperson() {
	}

	public int getPno() {
		return this.pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPadept() {
		return this.padept;
	}

	public void setPadept(String padept) {
		this.padept = padept;
	}

	public String getPfname() {
		return this.pfname;
	}

	public void setPfname(String pfname) {
		this.pfname = pfname;
	}

	public String getPfunc() {
		return this.pfunc;
	}

	public void setPfunc(String pfunc) {
		this.pfunc = pfunc;
	}

	public String getPlname() {
		return this.plname;
	}

	public void setPlname(String plname) {
		this.plname = plname;
	}

	public String getPsex() {
		return this.psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public String getPtel() {
		return this.ptel;
	}

	public void setPtel(String ptel) {
		this.ptel = ptel;
	}



	public Tutcompany getTutcompany() {
		return this.tutcompany;
	}

	public void setTutcompany(Tutcompany tutcompany) {
		this.tutcompany = tutcompany;
	}

	public Tutcompany getCocPno() {
		return cocPno;
	}

	public void setCocPno(Tutcompany cocPno) {
		this.cocPno = cocPno;
	}

	public List<Tutactivity> getActivities() {
		return activities;
	}

	public void setActivities(List<Tutactivity> activities) {
		this.activities = activities;
	}
	
	
	public List<TutworkingDay> getListWorkingDays() {
		return listWorkingDays;
	}

	public void setListWorkingDays(List<TutworkingDay> listWorkingDays) {
		this.listWorkingDays = listWorkingDays;
	}

	public void addActivity(Tutactivity activity){
		this.getActivities().add(activity);
		activity.setPerson(this);
	}
	
	public void removeActivity(Tutactivity activity){
		this.getActivities().remove(activity);
		activity.setPerson(null);
	}
	
	public void addWorkingDay(TutworkingDay workingDay){
		this.getListWorkingDays().add(workingDay);
		workingDay.setPersonId(this);
	}
	
	public void removeWorkingDay(TutworkingDay workingDay){
		this.getListWorkingDays().remove(workingDay);
		workingDay.setPersonId(null);
	}
	public String toString(){
		return this.getPfname() + " " + this.getPlname();
	}

}