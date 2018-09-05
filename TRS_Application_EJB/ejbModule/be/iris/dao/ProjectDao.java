package be.iris.dao;

import java.util.List;

import javax.ejb.Local;

import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;

@Local
public interface ProjectDao {
	
	public List<Tutproject> listAllprojects();
	
	public List<Tutcours> listInvoicedProjects();
	
	public List<Tutproject> listAllNonInvoicedProjects();
	
	
}
