package be.iris.Backing;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import be.iris.PrimFaceController.CalendarView;


@Named
@SessionScoped
public class FrontBean implements Serializable {

	private String activityName;

	
	@Inject 
	private CalendarView calendar;
	
	
	public String register()
	{
		System.out.println("Hello");
		System.out.println(activityName +  " " + calendar.getDate() + " " + calendar.getTimeStartWork() + " " + calendar.getTimeEndWork());
		return "ActivityRegistration";
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	

	public CalendarView getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarView calendar) {
		this.calendar = calendar;
	}

	
	
	
}
