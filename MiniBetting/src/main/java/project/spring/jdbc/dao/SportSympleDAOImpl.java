package project.spring.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import project.spring.jdbc.domain.Sport;

/**
 * @author nocnosetac
 * 	This is the old fashion style, without JdbcTemplate
 * 	insert(sport), delete(sport_id), findByIdsport_id()
 */
public class SportSympleDAOImpl implements SportSympleDAO
{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(Sport sport){
 
		String sql = "INSERT INTO sport " +
				"(sport_id, sport_name) VALUES (?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sport.getSport_id());
			ps.setString(2, sport.getSport_name());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public void delete(int id) {
		String sql = "DELETE FROM sport " +
					 "WHERE sport_id=?";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	public Sport findById(int id){
 
		String sql = "SELECT * FROM sport WHERE sport_id = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			Sport sport = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sport = new Sport(
					rs.getInt("sport_id"),
					rs.getString("sport_name")
				);
			}
			rs.close();
			ps.close();
			return sport;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}