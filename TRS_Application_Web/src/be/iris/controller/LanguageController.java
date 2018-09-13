
package be.iris.controller;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class LanguageController implements Serializable{

	private String language="en";
	
	public void changeCurrentLanguage(ActionEvent ae) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot viewRoot = context.getViewRoot();
		String language = (String)ae.getComponent().getAttributes().get("value");
		this.setLanguage(language);
		viewRoot.setLocale(new Locale(language));
	}

	public static String getMessage(String msg){
		String defaultProperties = "be.abis.ex.properties.languageRessources";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale usedLocale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(defaultProperties, usedLocale);
		String message = bundle.getString(msg);
		return message;
	}
	
	
	public static void sendAMessage(String msg, Severity error) {
		FacesMessage message = new FacesMessage(msg);
		message.setSeverity(error);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


}


