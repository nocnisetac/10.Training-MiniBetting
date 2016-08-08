package project.spring.jdbc.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.spring.jdbc.dao.CompetitionDAO;
import project.spring.jdbc.dao.CompetitiveTeamsDAO;
import project.spring.jdbc.dao.CompetitiveTeamsDetailsDAO;
import project.spring.jdbc.dao.SportDAO;
import project.spring.jdbc.dao.TeamDAO;
import project.spring.jdbc.dao.SportSympleDAO;
import project.spring.jdbc.domain.Competition;
import project.spring.jdbc.domain.CompetitiveTeams;
import project.spring.jdbc.domain.Sport;
import project.spring.jdbc.domain.Team;

public class App {

	public static void main(String[] args) {
	
			/* ============ 
			 *  MAKE BEANS
			 * ============
			 */
			ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			SportDAO sportDAO = (SportDAO) context.getBean("sportDAO");
			TeamDAO teamDAO = (TeamDAO) context.getBean("teamDAO");
			CompetitionDAO competitionDAO = (CompetitionDAO) context.getBean("competitionDAO");
			CompetitiveTeamsDAO competitiveTeamsDAO = (CompetitiveTeamsDAO) context.getBean("competitiveTeamsDAO");
			CompetitiveTeamsDetailsDAO detailsDAO = (CompetitiveTeamsDetailsDAO) context.getBean("competitiveTeamsDetailsDAO");
			
			/* ===============
			 *  FILL DATABASE 
			 * ===============
			 */
			sportDAO.insert(new Sport(1, "Basketball"));
			sportDAO.insert(new Sport(2, "Football"));
			
			teamDAO.insert(new Team(1, "Partizan"));
			teamDAO.insert(new Team(2, "Zvezda"));
			teamDAO.insert(new Team(3, "IvaBorovica"));
			teamDAO.insert(new Team(4, "Radnicki"));
			
			List<Team> teams = new ArrayList<Team>();
			teams.add(new Team(5, "Juventus"));
			teams.add(new Team(6, "PSG"));
			teams.add(new Team(7, "Inter"));
			teams.add(new Team(8, "Ajax"));
			teamDAO.insertBatchList(teams);  // Insert entire list...
			
			competitionDAO.insert(new Competition(1, "YUBA Liga", 1, 10));
			competitionDAO.insert(new Competition(2, "UEFA Cup", 2, 10));  
			
			competitiveTeamsDAO.insert(new CompetitiveTeams(1, 1, 1));  //1, YUBA Liga, Partizan
			competitiveTeamsDAO.insert(new CompetitiveTeams(2, 1, 2));	//2,          , Zvezda
			competitiveTeamsDAO.insert(new CompetitiveTeams(3, 1, 3));	//3,	   	  , IvaBorovica
			competitiveTeamsDAO.insert(new CompetitiveTeams(4, 1, 4));	//4,		  , Radnicki
			
			/* ================
			 *  QUERY DATABASE
			 * ================ 
			 */
			System.out.println(sportDAO.findAll());
			System.out.println(teamDAO.findAll());
			System.out.println(competitionDAO.findAll());
			System.out.println(competitiveTeamsDAO.findAll());
			// All teams from YUBA competition, in detail...
			System.out.println(detailsDAO.findAllFromCompetition(1));    
			
			/* ================
			 *  EMPTY DATABASE
			 * ================
			 */
			competitiveTeamsDAO.deleteAll();
			competitionDAO.deleteAll();
			teamDAO.deleteAll();
			sportDAO.deleteAll();
			       
	        // teamDAO.insertBatchQuery("UPDATE team SET team_name ='DSZDIF'");
	        
	        context.close(); 
	}
}