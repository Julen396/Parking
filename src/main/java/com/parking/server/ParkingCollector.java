package com.parking.server;

import java.util.ArrayList;

import com.parking.serialization.Parking;
import com.parking.serialization.ParkingDAO;
import com.parking.serialization.Plaza;

public class ParkingCollector {
	public ArrayList<Parking> addParking(Parking parking){
		synchronized(this) {
			ArrayList<Plaza> listaP = new ArrayList<Plaza>();
			for (int i=0; i<parking.getNumPlazas(); i++) {
				Plaza p = new Plaza();
				p.setCoche(null);
				p.setPiso(1);
				p.setPosicion(i);
				p.setZona("A");
				listaP.add(p);
			}
			parking.setPlazas(listaP);
			ParkingDAO.getInstance().save(parking);
			return (ArrayList<Parking>) ParkingDAO.getInstance().getAll();
		}
	}
}
