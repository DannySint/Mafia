package mafia.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mafia.Game;
import mafia.Health;
import mafia.Player;
import mafia.PlayerState;
import mafia.roles.Blue;
import mafia.roles.Investigator;
import mafia.roles.Killer;

public class TestsPlayer
    {
        private Game game;
        private Player[] players;

        @BeforeAll
        public void setUp()
        {
            players = new Player[9];
            players[0] = new Player("test-Saber", PlayerState.ALIVE, Health.HEALTHY, new Killer()); 
            players[1]= new Player("test-Archer", PlayerState.ALIVE, Health.HEALTHY, new Investigator());
            players[2] = new Player("test-Lancer", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[3] = new Player("test-Rider", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[4] = new Player("test-Caster", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[5] = new Player("test-Assassin", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[6] = new Player("test-Beserker", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[7] = new Player("test-Avenger", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            players[8] = new Player("test-Ruler", PlayerState.ALIVE, Health.HEALTHY, new Blue());
            game = new Game(players);
            game.setup();
        }

        @Test //haveActives
        public void testHaveActivesCultist()
        {
            System.out.println();
            boolean cultKill = game.getPlayers()[0].getRole().haveActives("Kill");
            System.out.println(game.getPlayers()[0].getName());
            assertEquals(cultKill, true);
        }
        public void testHaveActivesInvest() 
        {
            boolean blueInvest = game.getPlayers()[1].getRole().haveActives("Investigate");
            //System.out.println(game.getPlayers()[1].getName());
            assertEquals(blueInvest, true);
        }
        public void testHaveActivesBlue()
        {
            boolean bluePlayer = game.getPlayers()[2].getRole().haveActives("0");
            assertEquals(bluePlayer, true);
        }
        
        @Test
        public void testNumberOfPlayers()
        {
            int noPlayers = game.getNumCharacters();
            System.out.println(noPlayers);
            assertEquals(noPlayers, 9);
            //assertEquals(game.getPlayers());
        }
    }
