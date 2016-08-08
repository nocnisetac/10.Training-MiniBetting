package project.spring.jdbc.domain;

public class Team {
	private int team_id;
	private  String team_name;
	
	public Team() {};
	public Team(int team_id, String team_name) {
		this.team_id = team_id;
		this.team_name = team_name;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String toString() {
		return "Team [team_id: "+team_id+" ,team_name: "+team_name+"]";
	}
}
