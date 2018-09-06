package be.iris.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.session.view.WorkingDayBeanRemote;

@Named
@SessionScoped
public class WorkingDayController {
	
	@EJB(name = "workingDayBean")
	private WorkingDayBeanRemote workingDayBean;
	
	@Inject
	private LoginController loginController;
	
	public void startWorkignDay() {
		System.out.println(loginController.getPersonSelected());
		workingDayBean.StartNewWorkingDay(loginController.getPersonSelected());
	}
	
	public void endWorkingDay() {
		System.out.println(loginController.getPersonSelected());
		workingDayBean.endWorkingDay(loginController.getPersonSelected());
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	

}
