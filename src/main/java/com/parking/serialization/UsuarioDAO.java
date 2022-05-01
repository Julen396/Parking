package com.parking.serialization;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario> {

	private static UsuarioDAO instance;	
	
	private UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public boolean save(Usuario object) {
		super.saveObject(object);
		return true;
	}

	@Override
	public boolean delete(Usuario object) {
		super.deleteObject(object);
		return true;
	}

	@Override
	public List<Usuario> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
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