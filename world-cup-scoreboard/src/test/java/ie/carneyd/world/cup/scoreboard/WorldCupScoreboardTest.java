/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ie.carneyd.world.cup.scoreboard;

import ie.carneyd.world.cup.match.Match;
import ie.carneyd.world.cup.match.MatchException;
import ie.carneyd.world.cup.team.Team;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Acer
 */
public class WorldCupScoreboardTest {
    Team uruguay = new Team("URU", "Uruguay"), paraguay = new Team("PAR", "Paraguay");
    
    public WorldCupScoreboardTest() {
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
    public void testMatchCreationZeroHomeScore() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertEquals(0, scoreboard.getCurrentMatches().get(0).getHomeScore());
    }
    
    @Test
    public void testMatchCreationZeroAwayScore() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertEquals(0, scoreboard.getCurrentMatches().get(0).getAwayScore());
    }
    
    @Test
    public void testMatchCreationZeroTotalScore() {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertEquals(0, scoreboard.getCurrentMatches().get(0).getTotalScore());
    }
    
    @Test
    public void testFirstHalfNotSecondHalf() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertNull(scoreboard.getCurrentMatches().get(0).getSecondHalfStart());
    }
    
    @Test
    public void testFirstHalf_CurrentMatchesNotEmpty() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertFalse(scoreboard.getCurrentMatches().isEmpty());
    }
    
    @Test
    public void testFirstHalf_CompletedMatchesEmpty() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        
        assertTrue(scoreboard.getCompletedMatches().isEmpty());
    }
    
    @Test
    public void testFinishMatch_CurrentMatchesEmpty() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        scoreboard.finishMatch(m);
        
        assertTrue(scoreboard.getCurrentMatches().isEmpty());
    }
    
    @Test
    public void testFinishMatch_CompletedMatchesNotEmpty() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        scoreboard.finishMatch(m);
        
        assertFalse(scoreboard.getCompletedMatches().isEmpty());
    }
    
    @Test
    public void testFinishMatch_MatchEndNotEmpty() throws MatchException {
        WorldCupScoreboard scoreboard = new WorldCupScoreboard();
        scoreboard.startMatch(uruguay, paraguay);
        Match m = scoreboard.getCurrentMatches().get(0);
        m.startSecondHalf();
        scoreboard.finishMatch(m);
        
        assertNotNull(m.getMatchEnd());
    }
    
    @Test
    public void firstHalfTest_CurrentMatchesHasThreeMatches() throws MatchException {
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
        
        List<Match> matches = worldCupScoreboard.getCurrentMatches();
        
        matches.get(0)
                .incrementHomeScore(10, "Suarez",
                        matches.get(0).getMatchStart().plusMinutes(6));
        
        matches.get(1)
                .incrementAwayScore(9, "McCarthy",
                        matches.get(1).getMatchStart().plusMinutes(17));
        
        matches.get(1)
                .incrementHomeScore(10, "Joselu",
                        matches.get(1).getMatchStart().plusMinutes(22));
        
        matches.get(2)
                .incrementHomeScore(9, "Wood", 
                        matches.get(2).getMatchStart().plusMinutes(27));
        
        assertEquals(3, worldCupScoreboard.getCurrentMatches().size());
    }
    
    @Test
    public void firstHalfTest_CompletedMatchesEmpty() throws MatchException {
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
        Team italy = new Team("ITA", "Italy");
        
        worldCupScoreboard.startMatch(uruguay, italy);
        
        Team spain = new Team("ESP", "Spain");
        Team southAfrica = new Team("RSA", "South Africa");
        
        worldCupScoreboard.startMatch(spain, southAfrica);
        
        Team newZealand = new Team("NZL", "New Zealand");
        Team ivoryCoast = new Team("CIV", "Cote d'Ivoire");
        
        worldCupScoreboard.startMatch(newZealand, ivoryCoast);
        
        List<Match> matches = worldCupScoreboard.getCurrentMatches();
        
        matches.get(0)
                .incrementHomeScore(10, "Suarez",
                        matches.get(0).getMatchStart().plusMinutes(6));
        
        matches.get(1)
                .incrementAwayScore(9, "McCarthy",
                        matches.get(1).getMatchStart().plusMinutes(17));
        
        matches.get(1)
                .incrementHomeScore(10, "Joselu",
                        matches.get(1).getMatchStart().plusMinutes(22));
        
        matches.get(2)
                .incrementHomeScore(9, "Wood", 
                        matches.get(2).getMatchStart().plusMinutes(27));
        
        assertTrue(worldCupScoreboard.getCompletedMatches().isEmpty());
    }
    
    @Test
    public void completeOneMatch_CompletedMatchesHasOneMatch() throws MatchException {
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
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
        
        assertEquals(1, worldCupScoreboard.getCompletedMatches().size());
    }
    
    @Test
    public void completeOneMatch_CurrentMatchesHasTwoMatches() throws MatchException {
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
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
        
        assertEquals(2, worldCupScoreboard.getCurrentMatches().size());
    }
    
    @Test
    public void endToEndTest_CurrentMatchesEmpty() throws MatchException {
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
        Team italy = new Team("ITA", "Italy");
        
        worldCupScoreboard.startMatch(uruguay, italy);
        
        Team spain = new Team("ESP", "Spain");
        Team southAfrica = new Team("RSA", "South Africa");
        
        worldCupScoreboard.startMatch(spain, southAfrica);
        
        Team newZealand = new Team("NZL", "New Zealand");
        Team ivoryCoast = new Team("CIV", "Cote d'Ivoire");
        
        worldCupScoreboard.startMatch(newZealand, ivoryCoast);
        
        List<Match> matches = worldCupScoreboard.getCurrentMatches();
        
        matches.get(0)
                .incrementHomeScore(10, "Suarez",
                        matches.get(0).getMatchStart().plusMinutes(6));
        
        matches.get(1)
                .incrementAwayScore(9, "McCarthy",
                        matches.get(1).getMatchStart().plusMinutes(17));
        
        matches.get(1)
                .incrementHomeScore(10, "Joselu",
                        matches.get(1).getMatchStart().plusMinutes(22));
        
        matches.get(2)
                .incrementHomeScore(9, "Wood", 
                        matches.get(2).getMatchStart().plusMinutes(27));
        
        for(Match m : matches) {
            m.startSecondHalf();
        }
        
        matches.get(2)
                .incrementAwayScore(9, "Drogba", 
                        matches.get(2).getSecondHalfStart().plusMinutes(8));
        
        matches.get(1)
                .incrementHomeScore(4, "Pedri", 
                        matches.get(1).getSecondHalfStart().plusMinutes(15));
        
        matches.get(0)
                .incrementAwayScore(11, "Quagliarella", 
                        matches.get(0).getSecondHalfStart().plusMinutes(23));
        
        for(int i = matches.size() - 1; i >= 0; i--) {
            worldCupScoreboard.finishMatch(matches.get(i));
        }
        
        assertTrue(worldCupScoreboard.getCurrentMatches().isEmpty());
    }
    
    @Test
    public void endToEndTest_CompletedMatchesNotEmpty() throws MatchException {
        WorldCupScoreboard worldCupScoreboard = new WorldCupScoreboard();
        
        Team italy = new Team("ITA", "Italy");
        
        worldCupScoreboard.startMatch(uruguay, italy);
        
        Team spain = new Team("ESP", "Spain");
        Team southAfrica = new Team("RSA", "South Africa");
        
        worldCupScoreboard.startMatch(spain, southAfrica);
        
        Team newZealand = new Team("NZL", "New Zealand");
        Team ivoryCoast = new Team("CIV", "Cote d'Ivoire");
        
        worldCupScoreboard.startMatch(newZealand, ivoryCoast);
        
        List<Match> matches = worldCupScoreboard.getCurrentMatches();
        
        matches.get(0)
                .incrementHomeScore(10, "Suarez",
                        matches.get(0).getMatchStart().plusMinutes(6));
        
        matches.get(1)
                .incrementAwayScore(9, "McCarthy",
                        matches.get(1).getMatchStart().plusMinutes(17));
        
        matches.get(1)
                .incrementHomeScore(10, "Joselu",
                        matches.get(1).getMatchStart().plusMinutes(22));
        
        matches.get(2)
                .incrementHomeScore(9, "Wood", 
                        matches.get(2).getMatchStart().plusMinutes(27));
        
        for(Match m : matches) {
            m.startSecondHalf();
        }
        
        matches.get(2)
                .incrementAwayScore(9, "Drogba", 
                        matches.get(2).getSecondHalfStart().plusMinutes(8));
        
        matches.get(1)
                .incrementHomeScore(4, "Pedri", 
                        matches.get(1).getSecondHalfStart().plusMinutes(15));
        
        matches.get(0)
                .incrementAwayScore(11, "Quagliarella", 
                        matches.get(0).getSecondHalfStart().plusMinutes(23));
        
        for(int i = matches.size() - 1; i >= 0; i--) {
            worldCupScoreboard.finishMatch(matches.get(i));
        }
        
        assertEquals(3, worldCupScoreboard.getCompletedMatches().size());
    }
}
