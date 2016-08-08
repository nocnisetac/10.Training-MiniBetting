package project.spring.jdbc.domain;

public class Competition {
	private int competition_id;
	private String competition_name;
	private int sport_id;
	private int competition_capacity;
	
	public Competition() {};
	
	public Competition(int competition_id, String competition_name, int sport_id, int competition_capacity) {
		super();
		this.competition_id = competition_id;
		this.competition_name = competition_name;
		this.sport_id = sport_id;
		this.competition_capacity = competition_capacity;
	}

	public int getCompetition_id() {
		return competition_id;
	}
	public void setCompetition_id(int competition_id) {
		this.competition_id = competition_id;
	}
	public String getCompetition_name() {
		return competition_name;
	}
	public void setCompetition_name(String competition_name) {
		this.competition_name = competition_name;
	}
	public int getSport_id() {
		return sport_id;
	}
	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}
	public int getCompetition_capacity() {
		return competition_capacity;
	}
	public void setCompetition_capacity(int competition_capacity) {
		this.competition_capacity = competition_capacity;
	}

	@Override
	public String toString() {
		return "Competition [competition_id=" + competition_id + ", competition_name=" + competition_name + "]";
	}
	
}
