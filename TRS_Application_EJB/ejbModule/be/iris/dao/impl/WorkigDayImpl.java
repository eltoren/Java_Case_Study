package be.iris.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.iris.dao.WorkingDayDao;
import be.iris.entities.Tutperson;
import be.iris.entities.TutworkingDay;
import be.iris.exceptions.WorkingDayException;

@Stateless(mappedName = "workingDayDaoImpl")
public class WorkigDayImpl implements WorkingDayDao {

	@PersistenceContext(unitName = "TRSAppJpa")
	EntityManager em;

	@Override
	public void insertWorkingDay(TutworkingDay workingDay, long pno) 
	throws WorkingDayException{
		try {
			if(this.getWorkingDay(workingDay.getDate(), pno) != null)
				throw new WorkingDayException("You have already checked in !");
			Tutperson p = em.find(Tutperson.class, pno);
			workingDay.setCoworker(p);
			
			em.persist(workingDay);

		} catch (Exception re ) {
			throw new WorkingDayException("You have already checked in !");
		}

	}

	@Override
	public void updateWorkingDay(long pno) throws WorkingDayException{
		try {
			
			Date date = Date.valueOf(LocalDate.now());
			TutworkingDay wd = getWorkingDay(date, pno);
			if(wd == null){
				throw new WorkingDayException("You Have to check in before checking out !");
			}
			wd.setEndTime(Timestamp.valueOf(LocalDateTime.now()));
			em.merge(wd);

		} catch (RuntimeException re) {
			throw new WorkingDayException("A problem occured while trying to check out : " + re.getMessage());
		}

	}
	@SuppressWarnings("unchecked")
	public TutworkingDay getWorkingDay(Date date, long pno){
		String queryString = "Select w.* from TUTWORKING_DAYS w  where w.WORKING_DATE = ? and w.PNO = ?";
		Query  query= em.createNativeQuery(queryString, TutworkingDay.class);
		query.setParameter(1, date);
		query.setParameter(2, pno);
		List<TutworkingDay> wd = (List<TutworkingDay>)query.getResultList();
		if(!wd.isEmpty()){
			return wd.get(0);
		}else{
			return null;
		}
	}
	@Override
	public void deleteWorkingDay(TutworkingDay workingDay) {
		try {

			em.merge(workingDay);
			em.remove(workingDay);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}

	}

	@Override
	public TutworkingDay getWorkigDay(TutworkingDay workingDay) {
		TutworkingDay returnWorkingDay = new TutworkingDay();
		try {

			returnWorkingDay = em.find(TutworkingDay.class, workingDay);

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return returnWorkingDay;
	}

	@Override
	public List<TutworkingDay> listAllWorkigDays() {
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {

			TypedQuery<TutworkingDay> query = em.createNamedQuery("TutworkingDay.listWorkingDays", TutworkingDay.class);
			listWorkingDays = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkingDaysAtDate(LocalDate date) {
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {

			String sql = "select w from tutworkingDay w where w.date = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, Date.valueOf(date));
			listWorkingDays = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysOfPerson(long person) {
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {

			String sql = "select w from tutworkingDay w where w.coworker = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person);
			listWorkingDays = query.getResultList();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@Override
	public TutworkingDay getWorkigDaysOfPersonAtDate(long person, LocalDate date) {
		TutworkingDay returnWorkingDay = new TutworkingDay();
		try {

			String sql = "select w from tutworkingDay w where w.coworker = ? and w.date = ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person);
			query.setParameter(2, Date.valueOf(date));
			returnWorkingDay = (TutworkingDay) query.getSingleResult();

		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return returnWorkingDay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysBetweenStartDateANdEndDate(LocalDate startDate, LocalDate endDate) {
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
		try {
			String sql = "select w from tutworkingDay w where w.date between  ? and ?";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, Date.valueOf(startDate));
			query.setParameter(2, Date.valueOf(endDate));
			listWorkingDays = query.getResultList();
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
		return listWorkingDays;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TutworkingDay> getListWorkigDaysOfPersonBetweenStartDateANdEndDate(long person,
			LocalDate startDate, LocalDate endDate) {
		List<TutworkingDay> listWorkingDays = new ArrayList<>();
			String sql = "select w.* from tutworking_Days w where w.pno = ? and w.working_date > ? and w.working_date < ? ";
			Query query = em.createNativeQuery(sql, TutworkingDay.class);
			query.setParameter(1, person);
			query.setParameter(2, Date.valueOf(startDate));
			query.setParameter(3, Date.valueOf(endDate));
			for(TutworkingDay wd  : (List<TutworkingDay>) query.getResultList()){
				em.detach(wd);
				listWorkingDays.add(wd);
			}

		
		return listWorkingDays;
	}

}
