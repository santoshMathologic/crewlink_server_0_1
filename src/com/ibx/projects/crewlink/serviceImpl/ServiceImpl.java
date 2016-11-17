/**
 * 
 */
package com.ibx.projects.crewlink.serviceImpl;
import java.util.Collection;

import com.ibx.projects.crewlink.dao.IDao;
import com.ibx.projects.crewlink.daoImpl.DaoImpl;
import com.ibx.projects.crewlink.service.IService;


/**
 * @author khader
 *
 */
public class ServiceImpl implements IService{
	
	private IDao dao = new DaoImpl();
	

	/**
	 * @return the dao
	 */
	public IDao getDao() {
		return dao;
	}


	/**
	 * @param dao the dao to set
	 */
	public void setDao(IDao dao) {
		this.dao = dao;
	}


	public Collection<?> loadList(String query) {
		
		return dao.loadList(query) ;
	}


	@Override
	public void saveInDb(Object object) {
		dao.saveInDb(object);
	}


	@Override
	public void deleteFromDb(String query) {
		dao.deleteFromDb(query);
	}


	@Override
	public void updateInDb(Object object) {
		
		dao.updateInDb(object);
	}


	@Override
	public Object loadUniqueObject(String query) {
		return	dao.loadUniqueObject(query);
		 
	}


	@Override
	public Object DeleteUniqueObject(String query) {
		// TODO Auto-generated method stub
		return dao.DeleteUniqueObject(query);
	}

}
