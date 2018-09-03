package be.iris.session;

import be.iris.session.view.ActivityBeanRemote;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
