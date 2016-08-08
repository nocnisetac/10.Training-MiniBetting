package project.spring.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import project.spring.jdbc.domain.Team;

public class TeamDAOImpl implements TeamDAO{
	
	private JdbcTemplate jdbcTemplate;
 
	public void setDataSource(DataSource dataSource) {
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
 
	public void insert(Team team) {
		
		String sql = "INSERT INTO team " +
				"(team_id, team_name) VALUES (?, ?)";
	 
			jdbcTemplate.update( sql,
									 new Object[] { team.getTeam_id(), team.getTeam_name()}
																		);
	}
	public void deleteById(int team_id) {
		String sql = "DELETE FROM team " +
				 "WHERE team_id=?";
		jdbcTemplate.update(sql, new Object[] {team_id} );
	}
	public void deleteAll () {
		String sql = "DELETE FROM team " +
			 	 "WHERE team_id<?";
		jdbcTemplate.update(sql, new Object[] { 1000 });
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Team findById(int team_id) {
		String sql = "SELECT * FROM team WHERE team_id = ?";
		Team team = (Team) jdbcTemplate.queryForObject(
				sql, new Object[] { team_id }, new BeanPropertyRowMapper(Team.class));
	 
		return team;
	}
	
	@SuppressWarnings("rawtypes")
	public List<Team> findAll() {
		String sql = "SELECT * FROM team";
	 
		List<Team> teams = new ArrayList<Team>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Team team = new Team();
			team.setTeam_id(Integer.parseInt(String.valueOf(row.get("team_id"))));
			team.setTeam_name((String)row.get("team_name"));
			teams.add(team);
		}
		
		return teams;
	}

	public String findNameById(int id) {
		String sql = "SELECT team_name FROM team WHERE team_id = ?";
		 
		String name = (String)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, String.class);
	 
		return name;
	}

	public void insertBatchSQL(final String sql){
		 
		jdbcTemplate.batchUpdate(new String[]{sql});
	 
	}
	public void insertBatchList(final List<Team> teams) {

		String sql = "INSERT INTO team " +
			"(team_id, team_name) VALUES (?, ?)";
		 
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
		 
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Team team = teams.get(i);
				ps.setLong(1, team.getTeam_id());
				ps.setString(2, team.getTeam_name());
			}
		 
			public int getBatchSize() {
				return teams.size();
			}
		});
	}

	public void insertBatchQuery(String sql) {

		jdbcTemplate.batchUpdate(new String[]{sql});
		
	}
	
}
