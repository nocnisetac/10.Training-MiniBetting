package project.spring.jdbc.domain;

import java.util.List;

public class Sport {
	
	private int sport_id;
	
	private String sport_name;
	
	private List<Sport> list;

	public Sport(){
		this.sport_id = 0;
		this.sport_name = null;
		this.list = null;
	}
	
	public Sport(int sport_id, String sport_name) {
		this();
		this.sport_id = sport_id;
		this.sport_name = sport_name;
	}

	public int getSport_id() {
		return sport_id;
	}

	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}

	public String getSport_name() {
		return sport_name;
	}

	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}

	@Override
	public String toString() {
		return "Sport [sport_id=" + sport_id + ", sport_name=" + sport_name + "]";
	}

}
