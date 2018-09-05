package be.iris.PrimFaceController;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;


@Named
@RequestScoped
public class CalendarView implements Serializable {
         
//    
	private Date date;
//	private Date timeStartWork;
//	private Date timeEndWork;
//     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
  public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
  }
 
   public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
    
//    
//
//    public Date getTimeStartWork() {
//		return timeStartWork;
//	}
//
//	public void setTimeStartWork(Date timeStartWork) {
//		this.timeStartWork = timeStartWork;
//	}
//
//	public Date getTimeEndWork() {
//		return timeEndWork;
//	}
//
//	public void setTimeEndWork(Date timeEndWork) {
//		this.timeEndWork = timeEndWork;
//	}

	public CalendarView() {}
//	public CalendarView(Date date, Date date1, Date date2) {
//		super();
//		this.date = date;
//		this.timeStartWork = timeStartWork;
//		this.timeEndWork = timeEndWork;
//	}
// 
   
}