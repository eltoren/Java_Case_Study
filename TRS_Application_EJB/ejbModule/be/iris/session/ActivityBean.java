package be.iris.session;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;

import be.iris.entities.Tutactivity;
import be.iris.entities.Tutperson;
import be.iris.entities.Tutproject;
import be.iris.session.view.ActivityBeanRemote;
import be.iris.session.view.Project;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	
	
    public ActivityBean() {
    }


}
