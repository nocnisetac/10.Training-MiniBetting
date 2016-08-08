package project.spring.jdbc.domain;

public class CompetitiveTeams {
	
	int competitiveTeamsID;
	int competitionID;
	int teamID;
	
	public CompetitiveTeams() {}

	public CompetitiveTeams(int competitiveTeamsID, int competitionID, int teamID) {
		super();
		this.competitiveTeamsID = competitiveTeamsID;
		this.competitionID = competitionID;
		this.teamID = teamID;
	}

	public int getCompetitiveTeamsID() {
		return competitiveTeamsID;
	}

	public void setCompetitiveTeamsID(int competitiveTeamsID) {
		this.competitiveTeamsID = competitiveTeamsID;
	}

	public int getCompetitionID() {
		return competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	};
	
	@Override
	public String toString() {
		return "CompetitiveTeams [competitiveTeamsID=" + competitiveTeamsID + ", competitionID=" + competitionID
				+ ", teamID=" + teamID + "]";
	}

}
