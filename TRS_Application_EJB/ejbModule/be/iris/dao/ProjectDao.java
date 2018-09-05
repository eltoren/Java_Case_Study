package be.iris.dao;

import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;

@Local
public interface ProjectDao {

	public void insertProject(Tutproject project);

	public void updateProject(Tutproject oldProject, Tutproject newProject);

	public void deleteProject(Tutproject project);

	public Tutproject getProject(Tutproject project);

	public List<Tutproject> listAllprojects();

	public List<Tutcours> listInvoicedProjects();

	public List<Tutproject> listAllNonInvoicedProjects();

}
