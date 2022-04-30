package com.parking.serialization;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

//This class defines the basic methods of the DAO pattern.
public class DataAccessObjectBase {	
	protected static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	
	public boolean deleteObject(Object object) {
		boolean result=false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();			
			pm.deletePersistent(object);			
			tx.commit();
			result=true;
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
			result=false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return result;
	}
	
	public boolean saveObject(Object object) {
		boolean result=false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
			result=true;
		} catch (Exception ex) {
			System.out.println(" $ Error storing an object: " + ex.getMessage());
			result=false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return result;
	}
}