package project.spring.jdbc.dao;

import java.util.List;

import project.spring.jdbc.domain.CompetitiveTeamsDetails;

public interface CompetitiveTeamsDetailsDAO {
	public List<CompetitiveTeamsDetails> findAllFromCompetition(int competition_id);
}
