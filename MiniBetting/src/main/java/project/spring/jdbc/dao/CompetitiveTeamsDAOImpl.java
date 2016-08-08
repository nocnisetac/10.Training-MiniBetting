package project.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import project.spring.jdbc.domain.Competition;
import project.spring.jdbc.domain.CompetitiveTeams;
import project.spring.jdbc.domain.Team;

public class CompetitiveTeamsDAOImpl extends JdbcDaoSupport implements CompetitiveTeamsDAO {

	public void insert(CompetitiveTeams compeTeam) {
		String sql = "INSERT INTO competitive_teams " + "(competitive_teams_id, competition_id, team_id) "
				+ "VALUES (?, ?, ?)";

		getJdbcTemplate().update(sql, new Object[] { 
				compeTeam.getCompetitiveTeamsID(), compeTeam.getCompetitionID(), compeTeam.getTeamID()
				});
	}

	public void insertBatch(List<CompetitiveTeams> compeTeams) {
		// TODO Auto-generated method stub
		
	}

	public CompetitiveTeams findById(int competitiveTeamsID) {
		// TODO Auto-generated method stub
		return null;
	}

	public CompetitiveTeams findByTeamID(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public CompetitiveTeams findByTeamName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CompetitiveTeams> findAll() {
		String sql = "SELECT * FROM competitive_teams";
		 
		List<CompetitiveTeams> compeTeams = new ArrayList<CompetitiveTeams>();
	 
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			CompetitiveTeams compeTeam = new CompetitiveTeams();
			compeTeam.setCompetitiveTeamsID(Integer.parseInt(String.valueOf(row.get("competitive_teams_id"))));
			compeTeam.setCompetitionID(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			compeTeam.setTeamID(Integer.parseInt(String.valueOf(row.get("team_id"))));
			compeTeams.add(compeTeam);
		}
		
		return compeTeams;
	}

	public void deleteById(int competitiveTeamsID) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		String sql = "DELETE FROM competitive_teams " +
		 	 	 "WHERE competitive_teams_id<?";
		getJdbcTemplate().update(sql, new Object[] { 1000 });
		
	}

	
	

}
