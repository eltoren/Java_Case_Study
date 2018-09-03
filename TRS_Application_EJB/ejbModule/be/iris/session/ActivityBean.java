package be.iris.session;

import javax.ejb.Stateless;

import be.iris.session.view.ActivityBeanRemote;

/**
 * Session Bean implementation class ActivityBean
 */
@Stateless(mappedName = "activityBean")
public class ActivityBean implements ActivityBeanRemote {

    /**
     * Default constructor. 
     */
    public ActivityBean() {
        // TODO Auto-generated constructor stub
    }

}
