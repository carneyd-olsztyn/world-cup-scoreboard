/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.carneyd.world.cup.match.comparator;

import ie.carneyd.world.cup.match.Match;
import java.util.Comparator;

/**
 *
 * @author Acer
 */
public class MatchComparator implements Comparator<Match> {

    @Override
    public int compare(Match m1, Match m2) {
        
        int totalScoreComparison = m2.getTotalScore() - m1.getTotalScore();
        
        if(totalScoreComparison != 0) return totalScoreComparison;
        
        return m2.getMatchStart().compareTo(m1.getMatchStart());
    }
    
}
