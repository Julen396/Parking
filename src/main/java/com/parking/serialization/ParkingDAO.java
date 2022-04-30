package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class ParkingDAO extends DataAccessObjectBase implements IDataAccessObject<Parking> {

	private static ParkingDAO instance;	
	
	private ParkingDAO() { }
	
	public static ParkingDAO getInstance() {
		if (instance == null) {
			instance = new ParkingDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public boolean save(Parking object) {
		super.saveObject(object);
		return true;
	}

	@Override
	public boolean delete(Parking object) {
		super.deleteObject(object);
		return true;
	}

	@Override
	public List<Parking> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Parking> parkings = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Parking> retExtent = pm.getExtent(Parking.class, true);
			
			for (Parking p : retExtent) {
				parkings.add(p);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all challenges: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return parkings;
	}

	@Override
	public Parking find(String param) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Parking result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Parking.class.getName() + " WHERE nombre == '" + param + "'");
			query.setUnique(true);
			result = (Parking) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Challenge: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

}