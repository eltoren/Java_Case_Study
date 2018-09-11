package be.iris.PrimFaceController;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import be.iris.entities.Tutperson;
import be.iris.session.view.PersonBeanRemote;

 
@Named(value="dtSalaryView")
@ViewScoped
public class DataTableView implements Serializable {
     
	
	private List<Tutperson> persons = new ArrayList<>();
	private List<Tutperson> coWorker = new ArrayList<>();
	
	@EJB(name = "personBean")
	private PersonBeanRemote personBean;
	
	@PostConstruct
   	public void ConstructionList()
	{
	persons = personBean.getAllPersons();
	
		for (Tutperson temp : persons) {
			if(temp.getPtype().equals("Coworker"))
			coWorker.add(temp);
		
		}
	}


	public List<Tutperson> getPersons() {
		return persons;
	}

	public void setPersons(List<Tutperson> persons) {
		this.persons = persons;
	}


	public PersonBeanRemote getPersonBean() {
		return personBean;
	}


	public void setPersonBean(PersonBeanRemote personBean) {
		this.personBean = personBean;
	}


	public List<Tutperson> getCoWorker() {
		return coWorker;
	}


	public void setCoWorker(List<Tutperson> coWorker) {
		this.coWorker = coWorker;
	}
	
	
}