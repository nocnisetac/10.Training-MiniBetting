package project.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import project.spring.jdbc.domain.CompetitiveTeamsDetails;

public class CompetitiveTeamsDetailsDAOImpl extends JdbcDaoSupport implements CompetitiveTeamsDetailsDAO {

	public List<CompetitiveTeamsDetails> findAllFromCompetition(int competition_id) {
		String sql = "SELECT competitive_teams.competitive_teams_id AS idid,"
				   + "team.team_name AS tname,"
				   + "competition.competition_name AS cname "
				   + "FROM team "
				   + "INNER JOIN competitive_teams "
				   + "INNER JOIN competition "
				   + "ON team.team_id=competitive_teams.team_id "
				   + "AND competitive_teams.competition_id=competition.competition_id "
				   + "WHERE competitive_teams.competition_id=?";
		
		List<CompetitiveTeamsDetails> details = new ArrayList<CompetitiveTeamsDetails>();
		 
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, competition_id);
		for (Map row : rows) {
			CompetitiveTeamsDetails compet = new CompetitiveTeamsDetails();
			compet.setCompetitiveTeamsID(Integer.parseInt(String.valueOf(row.get("idid"))));
			compet.setTeamName((String)row.get("tname"));
			compet.setCompetitionName((String)row.get("cname"));
			details.add(compet);
		}
		return details;
	}

}
