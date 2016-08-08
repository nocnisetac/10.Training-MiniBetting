package project.spring.jdbc.dao;

import java.util.List;

import project.spring.jdbc.domain.Team;

public interface TeamDAO {
	
	public void insert(Team team);
	public void insertBatchList(final List<Team> teams);
	public void insertBatchQuery(final String sql);
	
	public Team findById(int team_id);
	public String findNameById(int id);
	public List<Team> findAll();
	
	public void deleteById(int team_id);
	public void deleteAll();

}
