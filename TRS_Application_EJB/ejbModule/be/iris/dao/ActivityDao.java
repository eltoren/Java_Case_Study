package be.iris.dao;

import java.util.List;

import be.iris.entities.Tutactivity;

public interface ActivityDao {
	
	
	public void insertActivity(Tutactivity activity);
	
	public void updateActivity(Tutactivity oldActivity, Tutactivity newActivity);
	
	public void deleteActivity(Tutactivity activity);
	
	public List<Tutactivity> listAllActivity();
	
	
}
