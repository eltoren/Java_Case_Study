package be.iris.PrimFaceController;
import javax.inject.Named;


@Named
public class SelectOneMenuView {
 
    private String project;
    private String analyse;
 
    
    public String getProject() {
        return project;
    }
 
    public void setProject(String project) {
        this.project = project;
    }

	public String getAnalyse() {
		return analyse;
	}

	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
 
//	public void onSelectShowDataTable(String choice){
//		choice = this.analyse;
//		switch(choice)
//		{
//		case "Activitylist" :
//			
//			System.out.println("Changer datatable");
//			
//			break;
//		case "Projectlist" :
//			System.out.println("Changer datatable");
//			
//			break;
//		case "Employeelist" :
//			
//			System.out.println("Changer datatable");
//			break;
//				
//		}
//		
//	}
//  
       
}