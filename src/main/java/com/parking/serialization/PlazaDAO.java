package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class PlazaDAO extends DataAccessObjectBase implements IDataAccessObject<Plaza> {

	private static PlazaDAO instance;	
	
	private PlazaDAO() { }
	
	public static PlazaDAO getInstance() {
		if (instance == null) {
			instance = new PlazaDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(Plaza object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Plaza object) {
		super.deleteObject(object);
	}

	@Override
	public List<Plaza> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Plaza> plazas = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Plaza> retExtent = pm.getExtent(Plaza.class, true);
			
			for (Plaza p : retExtent) {
				plazas.add(p);
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

		return plazas;
	}

	@Override
	public Plaza find(String param) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Plaza result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Plaza.class.getName() + " WHERE plaza_id == '" + param + "'");
			query.setUnique(true);
			result = (Plaza) query.execute();
			
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
