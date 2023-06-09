/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ie.carneyd.world.cup.scoreboard;

import ie.carneyd.world.cup.Team;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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
}
