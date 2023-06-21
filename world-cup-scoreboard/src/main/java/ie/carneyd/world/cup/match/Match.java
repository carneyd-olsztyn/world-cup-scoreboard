/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup.match;

import ie.carneyd.world.cup.match.update.MatchGoal;
import ie.carneyd.world.cup.match.update.GoalUpdateType;
import ie.carneyd.world.cup.team.Team;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Match {
    private final int HALF_LENGTH = 45;
    
    private int homeScore, awayScore, totalScore;
    private final Team homeTeam, awayTeam;
    private final LocalDateTime matchStart;
    private LocalDateTime secondHalfStart, matchEnd;
    List<MatchGoal> goals;
    
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

    public List<MatchGoal> getGoals() {
        return goals;
    }

    public LocalDateTime getMatchStart() {
        return matchStart;
    }

    public LocalDateTime getSecondHalfStart() {
        return secondHalfStart;
    }

    public LocalDateTime getMatchEnd() {
        return matchEnd;
    }
    
    public void startSecondHalf() throws MatchException {
        if(matchStart != null && secondHalfStart == null) {
            secondHalfStart = LocalDateTime.now();
        } else {
            throw new MatchException("Match is not in progress, or second half is already in progress");
        }
    }
    
    public void finishMatch() throws MatchException {
        if(matchStart != null && secondHalfStart != null) {
            matchEnd = LocalDateTime.now();
        } else {
            throw new MatchException("Match is not in progress, or is finishing before the second half begins");
        }
    }
    
    public void incrementHomeScore(int goalscorerNumber, String goalscorerName, LocalDateTime goalTime) throws MatchException {
        if(matchStart != null && matchEnd == null) {
            if((secondHalfStart != null && secondHalfStart.isAfter(goalTime)) || 
                    (secondHalfStart == null) && matchStart.isAfter(goalTime)) {
                throw new MatchException("Goal Time is outside the current half");
            }
            
            MatchGoal goal = new MatchGoal();
            goal.setGoalTime(goalTime);
            goal.setHalf((secondHalfStart == null) ? Half.FIRST_HALF : Half.SECOND_HALF);
            goal.setGoalUpdateType(GoalUpdateType.HOME_GOAL_ALLOWED);
            goal.setGoalscorerNumber(goalscorerNumber);
            goal.setGoalscorerName(goalscorerName);
            
            goals.add(goal);
            
            homeScore++;
            totalScore++;
        } else {
            throw new MatchException("Match is not in progress");
        }
    }
    
    public void incrementAwayScore(int goalscorerNumber, String goalscorerName, LocalDateTime goalTime) throws MatchException {
        if(matchStart != null && matchEnd == null) {
            if((secondHalfStart != null && secondHalfStart.isAfter(goalTime)) || 
                    (secondHalfStart == null) && matchStart.isAfter(goalTime)) {
                throw new MatchException("Goal Time is outside the current half");
            }
            
            MatchGoal goal = new MatchGoal();
            goal.setGoalTime(goalTime);
            goal.setHalf((secondHalfStart == null) ? Half.FIRST_HALF : Half.SECOND_HALF);
            goal.setGoalUpdateType(GoalUpdateType.AWAY_GOAL_ALLOWED);
            goal.setGoalscorerNumber(goalscorerNumber);
            goal.setGoalscorerName(goalscorerName);
            
            goals.add(goal);
            
            awayScore++;
            totalScore++;
        } else {
            throw new MatchException("Match is not in progress");
        }
    }

    @Override
    public String toString() {
        return "Match{" + homeTeam + " " + homeScore + ":" + awayScore + " " + awayTeam + "}";
    }
    
    public String toFullString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Match{").append(homeTeam).append(" ").append(homeScore).append(":").append(awayScore).append(" ").append(awayTeam).append("}");
        for(MatchGoal goal : goals) {
            Duration duration = Duration.between(
                    ((secondHalfStart == null) ? matchStart : secondHalfStart), 
                    goal.getGoalTime());
            long goalMinute = (secondHalfStart == null) ? duration.toMinutes() : duration.toMinutes() + HALF_LENGTH;
            sb.append("\n\t").append((goal.getGoalUpdateType() == GoalUpdateType.HOME_GOAL_ALLOWED) 
                    ? homeTeam.getShortName()
                    : awayTeam.getShortName()).append("\t").append(goal.getGoalscorerName()).append(" (").append(goal.getGoalscorerNumber()).append(")\t")
                    .append(goalMinute).append("'");
        }
        return sb.toString();
    }
}
