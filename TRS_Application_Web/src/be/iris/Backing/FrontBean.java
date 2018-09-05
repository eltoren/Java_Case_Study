package be.iris.Backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;
import be.iris.entities.Tutproject;


@Named
@SessionScoped
public class FrontBean implements Serializable {


	private String activityName;
	private boolean bool_CW = false;   /* IW = independant Worker*/
	private boolean bool_ACC = false;	/* ACC = Accountant*/
	private boolean bool_MAN = false;  /* MAN = Manager*/
	private boolean bool_EMP = false;  /* EMP = Employee */
	

	
	@Inject 
	private CalendarView calendar;
	
	
	
	public void registerActivity(ActionEvent e){
		
			
	}



	public CalendarView getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarView calendar) {
		this.calendar = calendar;
	}

	
	public String registryActivity()
	{
		System.out.println("Link To activity registration page");
		return "ActivityRegistration";
	}

	public String analyse()
	{
		System.out.println("Link To analyse page");
		return "Analyse";
	}
	
	public String workingDay()
	{
		System.out.println("Link To activity registration page");
		return "WorkingDay";
	}
	
	public String calculation()
	{
		System.out.println("Link To activity registration page");
		return "Calculation";
	}
	
	public String goBack()
	{
		return "MainPage";
		
	}
	
	
	public String logout()
	{
		
		System.out.println("Logout --> clear session");
		bool_CW = false;  
		bool_ACC = false;	
		bool_MAN = false; 
		bool_EMP = false; 
		return "index";
	}



	public boolean isBool_CW() {
		return bool_CW;
	}



	public void setBool_CW(boolean bool_CW) {
		this.bool_CW = bool_CW;
	}



	public boolean isBool_ACC() {
		return bool_ACC;
	}



	public void setBool_ACC(boolean bool_ACC) {
		this.bool_ACC = bool_ACC;
	}



	public boolean isBool_MAN() {
		return bool_MAN;
	}



	public void setBool_MAN(boolean bool_MAN) {
		this.bool_MAN = bool_MAN;
	}



	public boolean isBool_EMP() {
		return bool_EMP;
	}



	public void setBool_EMP(boolean bool_EMP) {
		this.bool_EMP = bool_EMP;
	}




	
	
}
