package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;


public class CocheDAO extends DataAccessObjectBase implements IDataAccessObject<Coche> {

		private static CocheDAO instance;	
		
		private CocheDAO() { }
		
		public static CocheDAO getInstance() {
			if (instance == null) {
				instance = new CocheDAO();
			}		
			
			return instance;
		}	
		
		@Override
		public void save(Coche object) {
			super.saveObject(object);
		}

		@Override
		public void delete(Coche object) {
			super.deleteObject(object);
		}

		@Override
		public List<Coche> getAll() {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			List<Coche> coches = new ArrayList<>();

			try {
				tx.begin();
				
				Extent<Coche> retExtent = pm.getExtent(Coche.class, true);
				
				for (Coche c : retExtent) {
					coches.add(c);
				}
							
				tx.commit();
				System.out.println("Lista de coches: " + coches);
			} catch (Exception ex) {
				System.out.println("  $ Error querying all challenges: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}

			return coches;
		}

		@Override
		public Coche find(String param) {		
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			Coche result = null; 

			try {
				tx.begin();
				
				Query<?> query = pm.newQuery("SELECT FROM " + Coche.class.getName() + " WHERE nombre == '" + param + "'");
				query.setUnique(true);
				result = (Coche) query.execute();
				
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
