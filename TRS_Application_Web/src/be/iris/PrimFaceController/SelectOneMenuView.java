package be.iris.PrimFaceController;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class SelectOneMenuView {
 
    private String project;
 
    
    public String getProject() {
        return project;
    }
 
    public void setConsole(String project) {
        this.project = project;
    }
 
   
}