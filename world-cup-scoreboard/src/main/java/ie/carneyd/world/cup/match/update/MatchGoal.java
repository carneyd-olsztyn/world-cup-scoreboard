/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup.match.update;

import ie.carneyd.world.cup.match.Half;
import java.time.LocalDateTime;

/**
 *
 * @author Acer
 */
public class MatchGoal {
    
    private GoalUpdateType goalUpdateType;
    private Half half;
    private LocalDateTime goalTime;
    private int goalscorerNumber;
    private String goalscorerName;

    public GoalUpdateType getGoalUpdateType() {
        return goalUpdateType;
    }
    public void setGoalUpdateType(GoalUpdateType goalUpdateType) {
        this.goalUpdateType = goalUpdateType;
    }

    public Half getHalf() {
        return half;
    }
    public void setHalf(Half half) {
        this.half = half;
    }

    public LocalDateTime getGoalTime() {
        return goalTime;
    }
    public void setGoalTime(LocalDateTime goalTime) {
        this.goalTime = goalTime;
    }

    public int getGoalscorerNumber() {
        return goalscorerNumber;
    }
    public void setGoalscorerNumber(int goalscorerNumber) {
        this.goalscorerNumber = goalscorerNumber;
    }

    public String getGoalscorerName() {
        return goalscorerName;
    }
    public void setGoalscorerName(String goalscorerName) {
        this.goalscorerName = goalscorerName;
    }
}
