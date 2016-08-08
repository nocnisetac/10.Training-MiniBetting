package project.spring.jdbc.dao;

import java.util.List;

import project.spring.jdbc.domain.Sport;

public interface SportDAO {

	public void insert(Sport sport);
	public void insertBatch(final List<Sport> sports);
	
	public Sport findById(int id);
	public Sport findByName(String name);
	public List<Sport> findAll();
	
	public void deleteById(int sport_id);
	public void deleteAll();
}
