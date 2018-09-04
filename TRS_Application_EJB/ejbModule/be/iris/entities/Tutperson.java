package be.iris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity
@Table(name="TUTPERSONS")
@NamedQuery(name="Tutperson.findAll", query="SELECT t FROM Tutperson t")
public class Tutperson implements Serializable {
	private static final long serialVersionUID = 1L;

	//id, bi-directional one-to-one association to tutworkingday
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToOne(mappedBy="personId")
	private long pno;

	
	private String padept;

	private String pfname;

	private String pfunc;

	@NotNull
	private String plname;

	private String psex;

	private String ptel;

	@Inject
	@Column(name="COC_PNO")
	@OneToOne
	@JoinColumn(name="CONO")
	private Tutcompany cocPno;

	//bi-directional many-to-one association to Tutcompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PA_CONO")
	private Tutcompany tutcompany;
	
	@OneToMany(targetEntity=Tutactivity.class, mappedBy="person")
	private List<Tutactivity> activities = new ArrayList<>();

	public Tutperson() {
	}

	public long getPno() {
		return this.pno;
	}

	public void setPno(long pno) {
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
	
	
	public void addActivity(Tutactivity activity){
		this.getActivities().add(activity);
		activity.setPerson(this);
	}
	
	public void removeActivity(Tutactivity activity){
		this.getActivities().remove(activity);
		activity.setPerson(null);
	}
	
	public String toString(){
		return this.getPfname() + " " + this.getPlname();
	}

}