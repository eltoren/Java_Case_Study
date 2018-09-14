package be.iris.entities;

import java.io.Serializable;
import java.sql.Date;


public class WorkingDayPK implements Serializable{



	private static final long serialVersionUID = 23934585316885000L;

	private long coworker;
	
	private Date date;

	
	public WorkingDayPK() {
		super();
	}

	public WorkingDayPK(long coworker, Date date) {
		super();
		this.coworker = coworker;
		this.date = date;
	}

	public long getCoworker() {
		return coworker;
	}

	public void setCoworker(long coworker) {
		this.coworker = coworker;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + Long.hashCode(coworker);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkingDayPK other = (WorkingDayPK) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (coworker != other.coworker)
			return false;
		return true;
	}
	
	

}