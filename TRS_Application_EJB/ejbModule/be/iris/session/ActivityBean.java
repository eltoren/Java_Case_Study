package be.iris.session;

import javax.ejb.Stateless;

import be.iris.entities.Tutactivity;
import be.iris.session.view.ActivityBeanRemote;

@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

	
	
    public ActivityBean() {
    }
    
    

}
