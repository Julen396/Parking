package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.*;

public class ParkingDAO implements IDataAccessObject<Parking> {

	private static ParkingDAO instance;
	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf = null;
	private Transaction tx = null;

	private ParkingDAO() { }
	
	public static ParkingDAO getInstance() {
		if (instance == null) {
			instance = new ParkingDAO();
		}		
		
		return instance;
	}

	public void setPM(PersistenceManager pm) {
		this.pm = pm;
	}

	public void setTransaction(Transaction tx) {
		this.tx = tx;
	}
	
	@Override
	public boolean save(Parking object) {
		boolean result;

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
			result=true;
		} catch (Exception ex) {
			System.out.println(" $ Error storing a parking: " + ex.getMessage());
			result=false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return result;
	}

	@Override
	public boolean delete(Parking object) {
		return true;
	}

	@Override
	public List<Parking> getAll() {
		
		List<Parking> parkings = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Parking> retExtent = pm.getExtent(Parking.class, true);
			
			for (Parking p : retExtent) {
				parkings.add(p);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all parkings: " + ex.getMessage());
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
			System.out.println("  $ Error querying a parking: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

}