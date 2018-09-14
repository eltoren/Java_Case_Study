
package be.iris.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@SuppressWarnings("serial")
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


}


