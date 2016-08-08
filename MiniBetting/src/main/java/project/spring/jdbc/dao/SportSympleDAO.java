package project.spring.jdbc.dao;

import project.spring.jdbc.domain.Sport;

/**
 * @author nocnosetac
 * 	This is the old fashion style, without JdbcTemplate
 * 	insert(sport), delete(sport_id), findByIdsport_id()
 */
public interface SportSympleDAO {

	public void insert(Sport employee);
	public Sport findById(int id);
	public void delete(int id);
}