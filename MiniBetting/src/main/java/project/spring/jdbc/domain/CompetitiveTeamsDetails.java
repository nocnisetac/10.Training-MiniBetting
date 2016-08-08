package project.spring.jdbc.domain;

public class CompetitiveTeamsDetails {
	private int competitiveTeamsID;
	private String teamName;
	private String competitionName;
	
	public CompetitiveTeamsDetails () {}

	public CompetitiveTeamsDetails(int competitiveTeamsID, String teamName, String competitionName) {
		super();
		this.competitiveTeamsID = competitiveTeamsID;
		this.teamName = teamName;
		this.competitionName = competitionName;
	}

	public int getCompetitiveTeamsID() {
		return competitiveTeamsID;
	}

	public void setCompetitiveTeamsID(int competitiveTeamsID) {
		this.competitiveTeamsID = competitiveTeamsID;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCompetitionName() {
		return competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	@Override
	public String toString() {
		return "CompetitiveTeamsDetails [competitiveTeamsID=" + competitiveTeamsID + ", teamName=" + teamName
				+ ", competitionName=" + competitionName + "]";
	}
	
}
