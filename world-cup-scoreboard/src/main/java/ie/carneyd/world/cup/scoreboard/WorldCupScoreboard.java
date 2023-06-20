/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ie.carneyd.world.cup.scoreboard;

import ie.carneyd.world.cup.Match;
import ie.carneyd.world.cup.Team;
import java.util.ArrayList;
import java.util.List;

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
    
    public void startMatch(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        
        currentMatches.add(match);
    }
    
    public void finishMatch(Match toFinish) {
        toFinish.finishMatch();
        
        completedMatches.add(toFinish);
        
        currentMatches.remove(toFinish);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
