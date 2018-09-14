package be.iris.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name="salaryinput")
public class SalaryInput {
	
	private double numberOfHours;
	private double pricePerHour;
	
	public SalaryInput(){
		
	}
	
	public SalaryInput(double numberOfHours, double pricePerHour) {
		this.numberOfHours = numberOfHours;
		this.pricePerHour = pricePerHour;
	}
	
	public double getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public double getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	

}
