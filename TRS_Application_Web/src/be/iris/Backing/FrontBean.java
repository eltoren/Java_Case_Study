package be.iris.Backing;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.PrimFaceController.CalendarView;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class FrontBean implements Serializable {

	private boolean bool_CW = false; /* IW = independant Worker */
	private boolean bool_ACC = false; /* ACC = Accountant */
	private boolean bool_MAN = false; /* MAN = Manager */
	private boolean bool_EMP = false; /* EMP = Employee */
	private boolean coworkerBoolean = false;
	private boolean projectBoolean = false;
	

	@Inject
	private CalendarView calendar;

	public CalendarView getCalendar() {
		return calendar;
	}

	public void setCalendar(CalendarView calendar) {
		this.calendar = calendar;
	}

	public String registryActivity() {
	
		return "ActivityRegistration?faces-redirect=true";
	}

	public String analysePersons() {
		this.setCoworkerBoolean(true);
		this.setProjectBoolean(false);
		return "Analyse";
	}
	
	public String analyseProjects() {
		this.setCoworkerBoolean(false);
		this.setProjectBoolean(true);
		return "Analyse";
	}

	

	public String calculation() {
		return "CalculationSalary?faces-redirect=true";
	}

	public String goBack() {
		return "MainPage?faces-redirect=true";

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

	public boolean isCoworkerBoolean() {
		return coworkerBoolean;
	}

	public void setCoworkerBoolean(boolean coworkerBoolean) {
		this.coworkerBoolean = coworkerBoolean;
	}

	public boolean isProjectBoolean() {
		return projectBoolean;
	}

	public void setProjectBoolean(boolean projectBoolean) {
		this.projectBoolean = projectBoolean;
	}
	
	
	
}
