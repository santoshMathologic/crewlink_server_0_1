/**
 * 
 */
package com.ibx.projects.crewlink.dao;

import java.util.Collection;
import java.util.List;



/**
 * @author khader
 *
 */
public interface IDao {

	Collection<?> loadList(String query);

	void saveInDb(Object object);

	void deleteFromDb(String query);

	void updateInDb(Object object);

	Object loadUniqueObject(String query);
	
	Object DeleteUniqueObject(String query);
	
	

	
}
