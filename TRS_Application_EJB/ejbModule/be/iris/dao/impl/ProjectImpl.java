package be.iris.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.iris.dao.ProjectDao;
import be.iris.entities.Tutcours;
import be.iris.entities.Tutproject;

@Stateless(mappedName = "projectImpl")
public class ProjectImpl implements ProjectDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	EntityManager em;

	@Override
	public void insertProject(Tutproject project) {
		try {

			em.persist(project);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void updateProject(Tutproject oldProject, Tutproject newProject) {
		try {

			Tutproject project = em.find(Tutproject.class, oldProject);
			project.setProtitle(newProject.getProtitle());
			project.setActivities(newProject.getActivities());

			em.merge(project);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
			re.printStackTrace();
		}

	}

	@Override
	public void deleteProject(Tutproject project) {
		try {

			em.merge(project);
			em.remove(project);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public Tutproject getProject(Tutproject project) {
		Tutproject returnProject = new Tutproject();
		try {

			returnProject = em.find(Tutproject.class, project);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return returnProject;
	}

	@Override
	public List<Tutproject> listAllprojects() {
		List<Tutproject> listProjects = new ArrayList<>();
		try {
				Query q =  em.createNamedQuery("Tutproject.findAll");
				for(Tutproject p : (List<Tutproject>) q.getResultList()){
					//em.detach(p);
				listProjects.add(p);
				}
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listProjects;
	}

	@Override
	public List<Tutcours> listInvoicedProjects() {
		List<Tutcours> listProjects = new ArrayList<>();
		try {
			TypedQuery<Tutcours> query = em.createNamedQuery("Tutcours.findAll",Tutcours.class);
			for(Tutcours c : query.getResultList()){
				em.detach(c);
				listProjects.add(c);
			}
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listProjects;
	}

	@Override
	public List<Tutproject> listAllNonInvoicedProjects() {
		List<Tutproject> listProjects = new ArrayList<>();
		try {

			TypedQuery<Tutproject> query = em.createNamedQuery("Tutproject.listProjects", Tutproject.class);
			listProjects = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listProjects;
	}

}
