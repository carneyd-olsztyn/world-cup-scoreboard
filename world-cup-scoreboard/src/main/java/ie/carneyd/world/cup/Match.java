/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup;

import java.time.LocalDateTime;

/**
 *
 * @author Acer
 */
public class Match {
    private int homeScore, awayScore, totalScore;
    private Team homeTeam, awayTeam;
    private LocalDateTime matchStart, matchEnd;
    
    public Match(Team homeTeam, Team awayTeam) {
        homeScore = 0;
        awayScore = 0;
        totalScore = 0;
        
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        
        this.matchStart = LocalDateTime.now();
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
    
    public void incrementHomeScore() {
        homeScore++;
        totalScore++;
    }
    
    public void incrementAwayScore() {
        awayScore++;
        totalScore++;
    }
    
    public void disallowHomeGoal() {
        homeScore--;
        totalScore--;
    }
    
    public void disallowAwayGoal() {
        awayScore--;
        totalScore--;
    }
}
