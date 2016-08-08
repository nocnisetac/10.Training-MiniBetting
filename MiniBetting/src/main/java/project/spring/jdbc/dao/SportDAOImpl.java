package project.spring.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import project.spring.jdbc.domain.Sport;
import project.spring.jdbc.domain.SportRowMapper;

/**
 * @author nocnisetac
 * JdbcTemplate in action
 */ 
public class SportDAOImpl extends JdbcDaoSupport implements SportDAO {
	 
	public void insert(Sport sport) {

		String sql = "INSERT INTO sport " + "(sport_id, sport_name) VALUES (?, ?)";

								/* Use of Object array to pass PreparedStatement arguments, 
								 * we could also use PreparedStatementSetter implementation 
								 * but passing Object array seems easy to use.
								 */
		getJdbcTemplate().update(sql, new Object[] { sport.getSport_id(), sport.getSport_name() });
	}
	public void insertBatch(final List<Sport> sports) {

		String sql = "INSERT INTO sport " +
			"(sport_id, sport_name) VALUES (?, ?)";
		 
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
		 
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Sport sport = sports.get(i);
				ps.setLong(1, sport.getSport_id());
				ps.setString(2, sport.getSport_name());
			}
		 
			public int getBatchSize() {
				return sports.size();
			}

		});
	}
	
	@SuppressWarnings({ "unchecked" })
	public Sport findById(int id){
		 
		String sql = "SELECT * FROM sport WHERE sport_id = ?";

		// SportRowMapper, implemented from RowMapper, implementation to map the ResultSet data 
		// to Sport bean object in queryForObject() method.
		Sport sport = (Sport) getJdbcTemplate().queryForObject(sql, new Object[] { id }, new SportRowMapper());
	 
		return sport;
	}
	
	@SuppressWarnings("unchecked")
	public Sport findByName(String name) {
		String sql = "SELECT * FROM sport WHERE sport_id = ?";
		
		Sport sport = (Sport) getJdbcTemplate().queryForObject(sql, new Object[] {name}, new SportRowMapper());
		return sport;
	}
	
	/* With this method we can query for total number of rows. There are two ways to map the Result: 
	 * the easiest way is to use the BeanPropertyRowMapper (as shown here), but another way would be
	 * to create our own mapping.
	 */
	@SuppressWarnings("rawtypes")
	public List<Sport> findAll() {

		String sql = "SELECT * FROM sport";
	 
		List<Sport> sports = new ArrayList<Sport>();
	 
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map row : rows) {
			Sport sport = new Sport();
			sport.setSport_id(Integer.parseInt(String.valueOf(row.get("sport_id"))));
			sport.setSport_name((String)row.get("sport_name"));
			sports.add(sport);
		}
		return sports;
	}
	
	public void deleteById(int sport_id) {
		
		String sql = "DELETE FROM team " +
				 	 "WHERE team_id=?";
		getJdbcTemplate().update(sql, new Object[] { sport_id});
	}

	public void deleteAll() {
		String sql = "DELETE FROM sport " +
			 	 "WHERE sport_id<?";
		getJdbcTemplate().update(sql, new Object[] { 1000 });
	}
}
