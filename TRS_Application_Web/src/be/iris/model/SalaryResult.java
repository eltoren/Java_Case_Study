package be.iris.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement(name="salaryresult")
public class SalaryResult {

	private double numberOfHours;
	private double pricePerHour;
	private double salary;
	
	public SalaryResult(){}
	
	public SalaryResult(double numberOfHours, double pricePerHour, double salary) {
		super();
		this.numberOfHours = numberOfHours;
		this.pricePerHour = pricePerHour;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
