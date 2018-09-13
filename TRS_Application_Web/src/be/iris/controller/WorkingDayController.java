package be.iris.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import be.iris.exceptions.WorkingDayException;
import be.iris.session.view.WorkingDayBeanRemote;

@Named
@RequestScoped
public class WorkingDayController {

	private long pno;
	@Inject
	private LoginController loginController;

	@Inject
	private ActionController actionController;
	@EJB
	private WorkingDayBeanRemote workingDayBean;
	
	
	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public void checkIn(ActionEvent e){
		
		pno = loginController.getPersonSelected().getPno();
		try{
		workingDayBean.StartNewWorkingDay(pno);
		actionController.sendAMessage("Check-in done", FacesMessage.SEVERITY_INFO);
		}catch(WorkingDayException wde){
			actionController.sendAMessage(wde.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	public void checkOut(ActionEvent e){
		pno = loginController.getPersonSelected().getPno();
		try{
			workingDayBean.endWorkingDay(pno);
			actionController.sendAMessage("Check-out done", FacesMessage.SEVERITY_INFO);
		}catch(WorkingDayException nwde){
			actionController.sendAMessage(nwde.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
}
