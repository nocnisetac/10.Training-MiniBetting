package project.spring.jdbc.dao;

import java.util.List;

import project.spring.jdbc.domain.Competition;

public interface CompetitionDAO {
	public void insert(Competition compet);
	public void insertBatch(final List<Competition> compets);
	
	public Competition findById(int id);
	public Competition findByName(String name);
	public List<Competition> findAll();
	
	public void deleteById(int competition_id);
	public void deleteAll();
}
