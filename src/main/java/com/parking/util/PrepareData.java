package com.parking.util;

import java.time.LocalDate;
import java.time.Month;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.parking.serialization.Usuario;

public class PrepareData {
	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Usuario u1 = new Usuario("7445268C", "Unai", LocalDate.of(2001, Month.DECEMBER, 12));
			
			pm.makePersistent(u1);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
}
