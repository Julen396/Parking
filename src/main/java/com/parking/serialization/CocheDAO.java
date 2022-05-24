package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.*;


public class CocheDAO implements IDataAccessObject<Coche> {

    private static CocheDAO instance;
    private PersistenceManager pm = null;
    private PersistenceManagerFactory pmf = null;
    private Transaction tx = null;

    private CocheDAO() {
    }

    public static CocheDAO getInstance() {
        if (instance == null) {
            instance = new CocheDAO();
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
    public boolean save(Coche object) {
		boolean result;

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
			result=true;
		} catch (Exception ex) {
			System.out.println(" $ Error storing a vehicle: " + ex.getMessage());
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
    public boolean delete(Coche object) {
        return true;
    }

    @Override
    public List<Coche> getAll() {
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
            System.out.println("  $ Error querying all vehicles: " + ex.getMessage());
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

            Query<?> query = pm.newQuery("SELECT FROM " + Coche.class.getName() + " WHERE matricula == '" + param + "'");
            query.setUnique(true);
            result = (Coche) query.execute();

            tx.commit();
        } catch (Exception ex) {
            System.out.println("  $ Error querying a vehicle: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }

        return result;
    }


}
