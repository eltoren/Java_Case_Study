package be.iris.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.iris.dao.ProjectDao;
import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;
import be.iris.session.view.ProjectBeanRemote;

@Stateless(mappedName = "projectBean")
public class ProjectBean implements ProjectBeanRemote {

	@EJB(name = "projectImpl")
	private ProjectDao projectDao;

	public ProjectBean() {
	}

	@Override
	public void saveNewProject(Tutproject project) {
		projectDao.insertProject(project);
	}

	@Override
	public void changeProject(Tutproject oldProject, Tutproject newProject) {
		projectDao.updateProject(oldProject, newProject);
	}

	@Override
	public void removeProject(Tutproject project) {
		projectDao.deleteProject(project);
	}

	@Override
	public Tutproject getProject(Tutproject project) {
		return projectDao.getProject(project);
	}

	@Override
	public List<Tutproject> getAllProjects() {
		return projectDao.listAllprojects();
	}

	// needs more impl
	// don't know meaning
	@Override
	public List<Tutcours> getListInvoicedProject() {
		return projectDao.listInvoicedProjects();
	}

	// needs more impl
	// don't know meaning
	@Override
	public List<Tutproject> getListNonInvoicesProjects() {
		return projectDao.listAllNonInvoicedProjects();
	}

}
