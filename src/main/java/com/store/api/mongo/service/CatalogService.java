package com.store.api.mongo.service;

import java.util.List;

import com.store.api.mongo.entity.Catalog;

/**
 * 
 * Revision History
 *
 * @author vincent,2014年11月10日 created it
 */
public interface CatalogService {
	
	public void save(Catalog entity);
	
	public void save(List<Catalog> entitys);
	
	public void remove(long id);
	
	public void remove(Catalog entity);
	
	public List<Catalog> findAllCatalog();
	
	public Catalog findByName(String name);
	
	public Catalog findOne(long id);

}
