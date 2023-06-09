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
    
    public List<Match> getCurrentMatches() {
        return currentMatches;
    }
    
    public void startMatch(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        
        currentMatches.add(match);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
