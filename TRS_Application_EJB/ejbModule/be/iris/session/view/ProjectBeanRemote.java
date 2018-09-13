package be.iris.session.view;

import java.util.List;

import javax.ejb.Remote;

import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;

@Remote
public interface ProjectBeanRemote {

	public void saveNewProject(Tutproject project);

	public void changeProject(Tutproject oldProject, Tutproject newProject);

	public void removeProject(Tutproject project);
	
	public Tutproject getProject(Tutproject project);

	public List<Tutproject> getAllProjects();

	public List<Tutcours> getListInvoicedProject();
	
	public Tutcours getInvoicedProject(String projectName);

	public List<Tutproject> getListNonInvoicesProjects();

}
