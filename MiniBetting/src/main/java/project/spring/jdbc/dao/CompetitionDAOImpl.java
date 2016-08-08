package project.spring.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import project.spring.jdbc.domain.Competition;

public class CompetitionDAOImpl extends JdbcDaoSupport implements CompetitionDAO {

	public void insert(Competition compet) {
		String sql = "INSERT INTO competition " + "(competition_id, competition_name, sport_id, competition_capacity) "
					+ "VALUES (?, ?, ?,  ?)";

		getJdbcTemplate().update(sql, new Object[] { compet.getCompetition_id(), compet.getCompetition_name(), 
												compet.getSport_id(), compet.getCompetition_capacity()
																										});
	}

	public void insertBatch(final List<Competition> compets) {

		String sql = "INSERT INTO competition " + "(competition_id, competition_name, sport_id, competition_capacity) "
				+ "VALUES (?, ?, ?,  ?)";
		 
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Competition compet = compets.get(i);
				ps.setInt(1, compet.getCompetition_id());
				ps.setString(2, compet.getCompetition_name());
				ps.setInt(3, compet.getSport_id());
				ps.setInt(4, compet.getCompetition_capacity());
			}
		 
			public int getBatchSize() {
				return compets.size();
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Competition findById(int competition_id) {
		String sql = "SELECT * FROM competition WHERE competition_id = ?";

		Competition compet = (Competition) getJdbcTemplate().queryForObject( sql, new Object[] { competition_id }, 
																		new BeanPropertyRowMapper(Competition.class));
		return compet;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Competition findByName(String competition_name) {
		String sql = "SELECT * FROM competition WHERE competition_id = ?";
		
		Competition compet = (Competition) getJdbcTemplate().queryForObject( sql, new Object[] { competition_name }, 
				new BeanPropertyRowMapper(Competition.class));
		return compet;
	}

	@SuppressWarnings("rawtypes")
	public List<Competition> findAll() {

		String sql = "SELECT * FROM competition";
	 
		List<Competition> compets = new ArrayList<Competition>();
	 
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			Competition compet = new Competition();
			compet.setCompetition_id(Integer.parseInt(String.valueOf(row.get("competition_id"))));
			compet.setCompetition_name((String)row.get("competition_name"));
			compet.setSport_id(Integer.parseInt(String.valueOf(row.get("sport_id"))));
			compet.setCompetition_capacity(Integer.parseInt(String.valueOf(row.get("competition_capacity"))));
			compets.add(compet);
		}
		return compets;
	}

	public void deleteById(int competition_id) {
		String sql = "DELETE FROM competition " +
				 "WHERE competition_id=?";
		getJdbcTemplate().update(sql, new Object[] {competition_id} );
	}

	public void deleteAll() {
		String sql = "DELETE FROM competition " +
			 	 	 "WHERE competition_id<?";
		getJdbcTemplate().update(sql, new Object[] { 1000 });
	}

}
