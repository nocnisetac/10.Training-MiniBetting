package project.spring.jdbc.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class SportRowMapper implements RowMapper	{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Sport sport = new Sport();
			sport.setSport_id(rs.getInt("sport_id"));
			sport.setSport_name(rs.getString("sport_name"));
			return sport;
		}
}
