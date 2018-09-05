package be.iris.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
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
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(project);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void updateProject(Tutproject oldProject, Tutproject newProject) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			Tutproject project = em.find(Tutproject.class, oldProject);
			project.setPid(newProject.getPid());
			project.setPtitle(newProject.getPtitle());
			project.setActivities(newProject.getActivities());

			// not gonna work
			// id not set...
			// not able to set a new one
			// or will it work?
			// check update from person of activity plz

			em.persist(project);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}

	}

	@Override
	public void deleteProject(Tutproject project) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(project);
			em.remove(project);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}

	}

	@Override
	public Tutproject getProject(Tutproject project) {
		EntityTransaction tx = em.getTransaction();
		Tutproject returnProject = new Tutproject();
		try {
			tx.begin();

			returnProject = em.find(Tutproject.class, project);

			tx.commit();
		} catch (RuntimeException re) {
			try {
				tx.rollback();
			} catch (RollbackException rbe) {
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return returnProject;
	}

	@Override
	public List<Tutproject> listAllprojects() {
		List<Tutproject> listProjects = new ArrayList<>();
		try {

			TypedQuery<Tutproject> query = em.createNamedQuery("Tutproject.listProjects", Tutproject.class);
			listProjects = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listProjects;
	}

	@Override
	public List<Tutcours> listInvoicedProjects() {
		// TODO Auto-generated method stub
		// i don't know what this is for
		return null;
	}

	@Override
	public List<Tutproject> listAllNonInvoicedProjects() {
		// TODO Auto-generated method stub
		// i don't know what this is for
		return null;
	}

}