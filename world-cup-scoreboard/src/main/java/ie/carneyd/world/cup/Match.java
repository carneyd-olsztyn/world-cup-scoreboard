/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Match {
    private int homeScore, awayScore, totalScore;
    private Team homeTeam, awayTeam;
    private LocalDateTime matchStart, secondHalfStart, matchEnd;
    ArrayList<MatchGoal> goals;
    
    public Match(Team homeTeam, Team awayTeam) {
        homeScore = 0;
        awayScore = 0;
        totalScore = 0;
        
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        
        this.matchStart = LocalDateTime.now();
        
        goals = new ArrayList<>();
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
    
    public void startSecondHalf() {
        secondHalfStart = LocalDateTime.now();
    }
    
    public void finishMatch() {
        matchEnd = LocalDateTime.now();
    }
    
    public void incrementHomeScore(int number, String name) {
        if(matchStart != null && matchEnd == null) {
            MatchGoal goal = new MatchGoal();
            goal.setGoalTime(LocalDateTime.now());
            goal.setHalf((secondHalfStart == null) ? Half.FIRST_HALF : Half.SECOND_HALF);
            goal.setGoalUpdateType(GoalUpdateType.HOME_GOAL_ALLOWED);
            goal.setGoalscorerNumber(number);
            goal.setGoalscorerName(name);
            homeScore++;
            totalScore++;
        } else {
            // Match is not in progress
        }
    }
    
    public void incrementAwayScore(int number, String name) {
        if(matchStart != null && matchEnd == null) {
            MatchGoal goal = new MatchGoal();
            goal.setGoalTime(LocalDateTime.now());
            goal.setHalf((secondHalfStart == null) ? Half.FIRST_HALF : Half.SECOND_HALF);
            goal.setGoalUpdateType(GoalUpdateType.AWAY_GOAL_ALLOWED);
            goal.setGoalscorerNumber(number);
            goal.setGoalscorerName(name);
            awayScore++;
            totalScore++;
        } else {
            // Match is not in progress
        }
    }
    
//    public void disallowHomeGoal(int number, String name) {
//        if(matchEnd != null) {
//            homeScore--;
//            totalScore--;
//        } else {
//            // Match is over
//        }
//    }
//    
//    public void disallowAwayGoal(int number, String name) {
//        if(matchEnd != null) {
//            awayScore--;
//            totalScore--;
//        } else {
//            // Match is over
//        }
//    }
}
