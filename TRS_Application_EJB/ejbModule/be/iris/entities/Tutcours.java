package be.iris.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TUTCOURSES database table.
 * 
 */
@Entity
@Table(name="TUTCOURSES")
@NamedQuery(name="Tutcours.findAll", query="SELECT t FROM Tutcours t")
public class Tutcours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="CID", columnDefinition="CHAR(4)")
	private String cid;

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

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

}