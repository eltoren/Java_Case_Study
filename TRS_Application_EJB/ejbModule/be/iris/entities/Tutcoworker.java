/*package be.iris.entities;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Named("coworker")
@RequestScoped
@DiscriminatorValue("Coworker")
public class Tutcoworker extends Tutperson{

	@OneToMany(targetEntity=TutworkingDay.class, mappedBy="coworker")
	private List<TutworkingDay> listWorkingDays = new ArrayList<>();  
	
	public Tutcoworker(){
		super();
	}
	
	public List<TutworkingDay> getListWorkingDays() {
		return listWorkingDays;
	}

	public void setListWorkingDays(List<TutworkingDay> listWorkingDays) {
		this.listWorkingDays = listWorkingDays;
	}
	public void addWorkingDay(TutworkingDay workingDay){
		this.getListWorkingDays().add(workingDay);
		workingDay.setCoworker(this);
	}
	
	public void removeWorkingDay(TutworkingDay workingDay){
		this.getListWorkingDays().remove(workingDay);
		workingDay.setCoworker(null);
	}
}*/
