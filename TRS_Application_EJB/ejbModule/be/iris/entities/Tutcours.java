package be.iris.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the TUTCOURSES database table.
 * 
 */
@Entity
@Table(name="TUTCOURSES")
@NamedNativeQuery(name="Tutcours.findAll", query="SELECT * FROM TUTCOURSES", resultClass=Tutcours.class)
public class Tutcours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="PID")
	private Tutproject project;

	@Column(name="CAPRICE", columnDefinition="NUMBER(4,2)")
	private long caprice;
	
	@Column(name="CDUR", columnDefinition="NUMBER")
	private int cdur;

	@Column(name="CLTITLE", columnDefinition="VARCHAR(60)")
	private String cltitle;

	@Column(name="CSTITLE", columnDefinition="CHAR(45)")
	private String cstitle;

	public Tutcours() {
	}

	

	public long getCaprice() {
		return this.caprice;
	}

	public void setCaprice(long caprice) {
		this.caprice = caprice;
	}

	public int getCdur() {
		return this.cdur;
	}

	public void setCdur(int cdur) {
		this.cdur = cdur;
	}

	public String getCltitle() {
		return this.cltitle;
	}

	public void setCltitle(String cltitle) {
		this.cltitle = cltitle;
	}

	public String getCstitle() {
		return this.cstitle;
	}

	public void setCstitle(String cstitle) {
		this.cstitle = cstitle;
	}



	public Tutproject getProject() {
		return project;
	}



	public void setProject(Tutproject project) {
		this.project = project;
	}

}