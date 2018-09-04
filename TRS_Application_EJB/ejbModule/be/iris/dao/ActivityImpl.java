package be.iris.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import be.iris.entities.Tutactivity;

public class ActivityImpl implements ActivityDao {

	@PersistenceContext(unitName="TRSAppJpa")
	EntityManager em;
	
	@Override
	public void insertActivity(Tutactivity activity) {
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			
			em.persist(activity);
			
			tx.commit();
			
		}catch(RuntimeException re){
			try{
				tx.rollback();
			}catch(RollbackException rbe){
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
	}

	@Override
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity) {
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			
			Tutactivity act = em.find(Tutactivity.class, oldActivity.getActivityId());
			act.setDate(newActivity.getDate());
			act.setDescription(newActivity.getDescription());
			act.setEndTime(newActivity.getEndTime());
			act.setStartTime(newActivity.getStartTime());
			act.setPerson(newActivity.getPerson());
			act.setProject(newActivity.getProject());
			
			em.persist(act);
			
			tx.commit();
			
		}catch(RuntimeException re){
			try{
				tx.rollback();
			}catch(RollbackException rbe){
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
	}

	@Override
	public void deleteActivity(Tutactivity activity) {
		EntityTransaction tx = em.getTransaction();
		try{
			tx.begin();
			
			em.merge(activity);
			em.remove(activity);
			
			tx.commit();
			
		}catch(RuntimeException re){
			try{
				tx.rollback();
			}catch(RollbackException rbe){
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		
	}

	@Override
	public List<Tutactivity> listAllActivity() {
		EntityTransaction tx = em.getTransaction();
		List<Tutactivity> listActivities = new ArrayList<>();
		try{
			tx.begin();
			
			TypedQuery<Tutactivity> query = em.createNamedQuery("Tutactivity.ListActivities", Tutactivity.class);
			listActivities = query.getResultList();
			
			tx.commit();
			
		}catch(RuntimeException re){
			try{
				tx.rollback();
			}catch(RollbackException rbe){
				System.err.println(rbe.getMessage());
			}
			System.err.println(re.getMessage());
		}
		return listActivities;
	}

}
