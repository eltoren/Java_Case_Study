package be.iris.salaryapi.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.iris.salaryapi.model.SalaryInput;
import be.iris.salaryapi.model.SalaryResult;

@Path("salaries")
public class SalaryService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SalaryResult calculateSalary(SalaryInput input){
		double nrOfHours = input.getNumberOfHours();
		double pricePerHour = input.getPricePerHour();
		double total = nrOfHours*pricePerHour;
		return new SalaryResult(nrOfHours,pricePerHour,total);		
	}
}
