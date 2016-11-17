/**
 * 
 */
package com.ibx.projects.crewlink.service;

import java.util.Collection;

/**
 * @author santosh
 *
 */
public interface IService {

	public Collection<?> loadList(String query) ;

	public void saveInDb(Object object);

	public void deleteFromDb(String query);

	public void updateInDb(Object object);

	public Object loadUniqueObject(String query);
	
	public Object DeleteUniqueObject(String query);
	
	
	

}
