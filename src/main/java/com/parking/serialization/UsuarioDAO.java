package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.*;

public class UsuarioDAO implements IDataAccessObject<Usuario> {

	private static UsuarioDAO instance;
	private PersistenceManager pm = null;
	private PersistenceManagerFactory pmf = null;
	private Transaction tx = null;
	
	private UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
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
	public boolean save(Usuario object) {
		boolean result;

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

	@Override
	public boolean delete(Usuario object) {
		return true;
	}

	@Override
	public List<Usuario> getAll() {
		
		List<Usuario> usuarios = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Usuario> retExtent = pm.getExtent(Usuario.class, true);
			
			for (Usuario u : retExtent) {
				usuarios.add(u);
			}
						
			tx.commit();
			System.out.println("Lista de usuarios: " + usuarios);
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}

	@Override
	public Usuario find(String param) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Usuario result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE nombre == '" + param + "'");
			query.setUnique(true);
			result = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}


}