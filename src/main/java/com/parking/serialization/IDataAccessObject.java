package com.parking.serialization;

import java.util.List;

//This interface defines the basic methods of Data Access Object Pattern
//This interface uses the concept of a "template". 
//Classes implementing it must specify the concrete type on which the methods are applied.
public interface IDataAccessObject<DomainObject> {
	public boolean save(DomainObject object);
	public boolean delete(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject find(String param);
}
