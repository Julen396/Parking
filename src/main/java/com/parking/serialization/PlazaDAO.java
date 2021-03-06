package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.*;

public class PlazaDAO implements IDataAccessObject<Plaza> {

	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf = null;
	private Transaction tx = null;
	private static PlazaDAO instance;

	private PlazaDAO() {
		//pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//pm = pmf.getPersistenceManager();
	}

	public static PlazaDAO getInstance() {
		if (instance == null) {
			instance = new PlazaDAO();
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
	public boolean save(Plaza object) {
		boolean result;

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
			result=true;
		} catch (Exception ex) {
			System.out.println(" $ Error storing a place: " + ex.getMessage());
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
	public boolean delete(Plaza object) {
		return true;
	}

	@Override
	public List<Plaza> getAll() {
		List<Plaza> plazas = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Plaza> retExtent = pm.getExtent(Plaza.class, true);
			
			for (Plaza p : retExtent) {
				plazas.add(p);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all places: " + ex.getMessage());
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
			System.out.println("  $ Error querying a places: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}

}
