/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ie.carneyd.world.cup.match;

import ie.carneyd.world.cup.scoreboard.WorldCupScoreboard;
import ie.carneyd.world.cup.team.Team;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Acer
 */
public class MatchTest {
    Team uruguay = new Team("URU", "Uruguay"), paraguay = new Team("PAR", "Paraguay");
    
    public MatchTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testStartSecondHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        scoreboard.getCurrentMatches().get(0).startSecondHalf();
        
        assertNotNull(scoreboard.getCurrentMatches().get(0).getSecondHalfStart());
    }
    
    @Test
    public void testStartSecondHalf_CalledTwice() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        scoreboard.getCurrentMatches().get(0).startSecondHalf();
        assertThrows(MatchException.class, () -> scoreboard.getCurrentMatches().get(0).startSecondHalf());
    }
    
    @Test
    public void testFinishMatch_SecondHalfNotStarted() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        assertThrows(MatchException.class, () -> scoreboard.getCurrentMatches().get(0).finishMatch());
    }
    
    @Test
    public void testFinishMatch_SecondHalfStarted() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        m.finishMatch();
        
        assertNotNull(scoreboard.getCurrentMatches().get(0).getMatchEnd());
    }
    
    @Test
    public void testIncrementHomeScore_FirstHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.incrementHomeScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getHomeScore());
    }
    
    @Test
    public void testIncrementAwayScore_FirstHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.incrementAwayScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getAwayScore());
    }
    
    @Test
    public void testIncrementHomeScore_GoalsList() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.incrementHomeScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getGoals().size());
    }
    
    @Test
    public void testIncrementAwayScore_GoalsList() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.incrementAwayScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getGoals().size());
    }
    
    @Test
    public void testIncrementHomeScore_SecondHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        m.incrementHomeScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getHomeScore());
    }
    
    @Test
    public void testIncrementAwayScore_SecondHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        m.incrementAwayScore(0, "goalscorerName", LocalDateTime.now());
        
        assertEquals(1, m.getAwayScore());
    }
    
    @Test
    public void testIncrementHomeScore_AfterMatch() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        m.finishMatch();
        
        assertThrows(MatchException.class, 
                () -> m.incrementHomeScore(0, "goalscorerName", LocalDateTime.now()));
    }
    
    @Test
    public void testIncrementAwayScore_AfterMatch() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        m.finishMatch();
        
        assertThrows(MatchException.class, 
                () -> m.incrementAwayScore(0, "goalscorerName", LocalDateTime.now()));
    }
    
    @Test
    public void testIncrementHomeScore_BeforeMatch() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        
        assertThrows(MatchException.class, 
                () -> m.incrementHomeScore(0, "goalscorerName", LocalDateTime.now().minusDays(3)));
    }
    
    @Test
    public void testIncrementAwayScore_BeforeMatch() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        
        assertThrows(MatchException.class, 
                () -> m.incrementAwayScore(0, "goalscorerName", LocalDateTime.now().minusDays(3)));
    }
    
    @Test
    public void testToString() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        
        assertTrue(m.toString().startsWith("Match{"+uruguay.getShortName()));
    }
    
    @Test
    public void testToFullString() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        
        assertTrue(m.toFullString().startsWith("Match{"+uruguay.getShortName()));
    }
}
