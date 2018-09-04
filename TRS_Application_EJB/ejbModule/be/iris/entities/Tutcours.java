package be.iris.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Named
@Entity
@Table(name="TUTCOURSES")
@NamedQuery(name="Tutcours.findAll", query="SELECT t FROM Tutcours t")
@PrimaryKeyJoinColumn(name="PID")
public class Tutcours extends Tutproject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pid;

	private BigDecimal caprice;

	private BigDecimal cdur;

	private String cltitle;

	private String cstitle;

	public Tutcours() {
	}

	public String getCid() {
		return this.pid;
	}

	public void setCid(String cid) {
		this.pid = cid;
	}

	public BigDecimal getCaprice() {
		return this.caprice;
	}

	public void setCaprice(BigDecimal caprice) {
		this.caprice = caprice;
	}

	public BigDecimal getCdur() {
		return this.cdur;
	}

	public void setCdur(BigDecimal cdur) {
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