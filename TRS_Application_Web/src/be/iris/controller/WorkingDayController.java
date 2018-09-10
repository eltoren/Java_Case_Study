package be.iris.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import be.iris.session.view.WorkingDayBeanRemote;

@Named
@SessionScoped
public class WorkingDayController {
	
	@Inject
	private LoginController loginController;

	@EJB
	private WorkingDayBeanRemote workingDayBean;
	
	
	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public void checkIn(ActionEvent e){
		long pno = loginController.getPersonSelected().getPno();
		workingDayBean.StartNewWorkingDay(pno);
	}
	
	public void checkOut(){
		
	}
	
}
