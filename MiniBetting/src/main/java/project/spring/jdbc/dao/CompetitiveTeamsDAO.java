package project.spring.jdbc.dao;

import java.util.List;

import project.spring.jdbc.domain.Competition;
import project.spring.jdbc.domain.CompetitiveTeams;
import project.spring.jdbc.domain.Team;

public interface CompetitiveTeamsDAO {
	public void insert(CompetitiveTeams compeTeam);
	public void insertBatch(final List<CompetitiveTeams> compeTeams);
	
	public CompetitiveTeams findById(int competitiveTeamsID);
	public CompetitiveTeams findByTeamID(String name);
	public CompetitiveTeams findByTeamName(String name);
	public List<CompetitiveTeams> findAll();
	
	public void deleteById(int competitiveTeamsID);
	public void deleteAll();
}
