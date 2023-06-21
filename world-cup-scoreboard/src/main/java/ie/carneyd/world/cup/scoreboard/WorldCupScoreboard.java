/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ie.carneyd.world.cup.scoreboard;

import ie.carneyd.world.cup.match.Match;
import ie.carneyd.world.cup.match.MatchException;
import ie.carneyd.world.cup.team.Team;
import ie.carneyd.world.cup.match.comparator.MatchComparator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Acer
 */
public class WorldCupScoreboard {
    private List<Match> currentMatches = new ArrayList<>();
    private List<Match> completedMatches = new ArrayList<>();
    
    public List<Match> getCurrentMatches() {
        return currentMatches;
    }
    
    public List<Match> getCompletedMatches() {
        return completedMatches;
    }
    
    public void startMatch(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        
        currentMatches.add(match);
    }
    
    public void finishMatch(Match toFinish) throws MatchException {
        toFinish.finishMatch();
        
        completedMatches.add(toFinish);
        
        currentMatches.remove(toFinish);
    }
    
    public List<Match> generateSummaryList(List<Match> matches) {
        List<Match> sortedMatches = matches.stream().sorted(new MatchComparator()).collect(Collectors.toList());
        
        return sortedMatches;
    }
    
    public void printFullScoreboard(List<Match> matches) {
        for(Match match : matches) {
            System.out.println(match.toFullString());
        }
    }
    
    public void printScoreboard(List<Match> matches) {
        for(Match match : matches) {
            System.out.println(match.toString());
        }
    }

    public static void main(String[] args) throws MatchException {
        System.out.println("World Cup Scoreboard");
        
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
        Team uruguay = new Team("URU", "Uruguay");
        Team italy = new Team("ITA", "Italy");
        
        worldCupScoreboard.startMatch(uruguay, italy);
        
        Team spain = new Team("ESP", "Spain");
        Team southAfrica = new Team("RSA", "South Africa");
        
        worldCupScoreboard.startMatch(spain, southAfrica);
        
        Team newZealand = new Team("NZL", "New Zealand");
        Team ivoryCoast = new Team("CIV", "Cote d'Ivoire");
        
        worldCupScoreboard.startMatch(newZealand, ivoryCoast);
        
        worldCupScoreboard.getCurrentMatches().get(0)
                .incrementHomeScore(10, "Suarez",
                        worldCupScoreboard.getCurrentMatches().get(0).getMatchStart().plusMinutes(6));
        
        worldCupScoreboard.getCurrentMatches().get(1)
                .incrementAwayScore(9, "McCarthy",
                        worldCupScoreboard.getCurrentMatches().get(1).getMatchStart().plusMinutes(17));
        
        worldCupScoreboard.getCurrentMatches().get(1)
                .incrementHomeScore(10, "Joselu",
                        worldCupScoreboard.getCurrentMatches().get(1).getMatchStart().plusMinutes(22));
        
        worldCupScoreboard.getCurrentMatches().get(2)
                .incrementHomeScore(9, "Wood", 
                        worldCupScoreboard.getCurrentMatches().get(2).getMatchStart().plusMinutes(27));
        
        for(Match m : worldCupScoreboard.getCurrentMatches()) {
            m.startSecondHalf();
        }
        
        worldCupScoreboard.getCurrentMatches().get(2)
                .incrementAwayScore(9, "Drogba", 
                        worldCupScoreboard.getCurrentMatches().get(2).getSecondHalfStart().plusMinutes(8));
        
        worldCupScoreboard.getCurrentMatches().get(1)
                .incrementHomeScore(4, "Pedri", 
                        worldCupScoreboard.getCurrentMatches().get(1).getSecondHalfStart().plusMinutes(15));
        
        worldCupScoreboard.getCurrentMatches().get(0)
                .incrementAwayScore(11, "Quagliarella", 
                        worldCupScoreboard.getCurrentMatches().get(0).getSecondHalfStart().plusMinutes(23));
        
        worldCupScoreboard.finishMatch(worldCupScoreboard.getCurrentMatches().get(1));
        
        List<Match> sortedMatches = worldCupScoreboard.generateSummaryList(worldCupScoreboard.getCurrentMatches());
        
        for(Match match : sortedMatches) {
            System.out.println(match.toFullString());
        }
    }
}
