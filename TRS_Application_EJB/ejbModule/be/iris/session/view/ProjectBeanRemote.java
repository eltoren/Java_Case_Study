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

	// i don't know
	public List<Tutcours> getListInvoicedProject();

	// i don't know
	public List<Tutproject> getListNonInvoicesProjects();

}
