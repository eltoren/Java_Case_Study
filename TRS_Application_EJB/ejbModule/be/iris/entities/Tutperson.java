package be.iris.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
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
@Entity(name="Tutperson")
@Table(name="TUTPERSONS")
@NamedQuery(name="Tutperson.findAll", query="SELECT t FROM Tutperson t ")
@NamedNativeQueries({@NamedNativeQuery(name="Tutperson.findPersonsLogs", 
					query="SELECT * from tutpersons t where t.pno in (select p.pass_pno from tutpasswords p)",
					resultClass = Tutperson.class),
					@NamedNativeQuery(name="Tutperson.findPersonConnected", 
					query="SELECT * from tutpersons t where t.pno = :pno",
					resultClass = Tutperson.class)})
public class Tutperson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PNO")
	private long pno;

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
	
	@OneToMany(targetEntity=Tutactivity.class, mappedBy="person",fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	private List<Tutactivity> activities = new ArrayList<>();
	
	@Column(name="ptype")
	private String ptype;
	
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
		activities.add(activity);
		activity.setPerson(this);
	}
	
	public void removeActivity(Tutactivity activity){
		activities.remove(activity);
		activity.setPerson(null);
	}
	

	public String toString(){
		return this.getPfname() + " " + this.getPlname();
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	
}