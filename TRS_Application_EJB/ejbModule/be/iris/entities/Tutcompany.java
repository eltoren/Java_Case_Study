package be.iris.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="TUTCOMPANIES")
@NamedQuery(name="Tutcompany.findAll", query="SELECT t FROM Tutcompany t")
public class Tutcompany implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cono;

	private String cobankno;

	private String cocountr;

	@NotNull
	private String coname;

	@NotNull
	private String costreet;

	private String costrno;

	private String cotel;

	@NotNull
	private String cotown;

	private String cotownno;

	private String covat;

	//bi-directional many-to-one association to Tutperson
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COC_PNO")
	private Tutperson tutperson;

	//bi-directional many-to-one association to Tutperson
	@OneToMany(mappedBy="tutcompany")
	private List<Tutperson> employees;

	public Tutcompany() {
	}

	public long getCono() {
		return this.cono;
	}

	public void setCono(long cono) {
		this.cono = cono;
	}

	public String getCobankno() {
		return this.cobankno;
	}

	public void setCobankno(String cobankno) {
		this.cobankno = cobankno;
	}

	public String getCocountr() {
		return this.cocountr;
	}

	public void setCocountr(String cocountr) {
		this.cocountr = cocountr;
	}

	public String getConame() {
		return this.coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public String getCostreet() {
		return this.costreet;
	}

	public void setCostreet(String costreet) {
		this.costreet = costreet;
	}

	public String getCostrno() {
		return this.costrno;
	}

	public void setCostrno(String costrno) {
		this.costrno = costrno;
	}

	public String getCotel() {
		return this.cotel;
	}

	public void setCotel(String cotel) {
		this.cotel = cotel;
	}

	public String getCotown() {
		return this.cotown;
	}

	public void setCotown(String cotown) {
		this.cotown = cotown;
	}

	public String getCotownno() {
		return this.cotownno;
	}

	public void setCotownno(String cotownno) {
		this.cotownno = cotownno;
	}

	public String getCovat() {
		return this.covat;
	}

	public void setCovat(String covat) {
		this.covat = covat;
	}

	public Tutperson getTutperson() {
		return this.tutperson;
	}

	public void setTutperson(Tutperson tutperson) {
		this.tutperson = tutperson;
	}

	public List<Tutperson> getTutpersons() {
		return this.employees;
	}

	public void setTutpersons(List<Tutperson> employees) {
		this.employees = employees;
	}

	public Tutperson addEmployees(Tutperson employees) {
		getTutpersons().add(employees);
		tutperson.setTutcompany(this);

		return tutperson;
	}

	public Tutperson removeTutperson(Tutperson employees) {
		getTutpersons().remove(employees);
		tutperson.setTutcompany(null);

		return tutperson;
	}
	
	public String toString(){
		return this.getConame() +"  " + this.getCocountr();
	}

}