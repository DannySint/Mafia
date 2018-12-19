package mafia.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mafia.Game;
import mafia.Health;
import mafia.Player;
import mafia.PlayerState;
import mafia.roles.Killer;
import mafia.roles.blue.Investigator;
import mafia.roles.blue.RandomBlue;

public class TestsPlayer
    {
        private Game game;
        private Player[] players;
        private boolean debug = true;

        @BeforeEach
        public void setUp()
        {
            
            TestsPlayer testsPlayer = new TestsPlayer();
            if (testsPlayer.debug) {System.out.println("Before starting");}
            testsPlayer.players = new Player[9];
            testsPlayer.players[0] = new Player("test-Saber", PlayerState.ALIVE, Health.HEALTHY, new Killer()); 
            testsPlayer.players[1]= new Player("test-Archer", PlayerState.ALIVE, Health.HEALTHY, new Investigator());
            testsPlayer.players[2] = new Player("test-Lancer", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[3] = new Player("test-Rider", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[4] = new Player("test-Caster", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[5] = new Player("test-Assassin", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[6] = new Player("test-Beserker", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[7] = new Player("test-Avenger", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.players[8] = new Player("test-Ruler", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            testsPlayer.game = new Game(testsPlayer.players);
            //testsPlayer.game.setup();
        }

        @Test //haveActives
        public void testHaveActivesCultist()
        {
            if (debug) {System.out.println("TestActivesCultish");}
            if (debug) {System.out.println(game);}
            if (debug) {System.out.println(game.getPlayers());}
            if (debug) {System.out.println(game.getPlayers()[0]);}
            if (debug) {System.out.println(game.getPlayers()[0].getRole());}
            if (debug) {System.out.println(game.getPlayers()[0].getRole().haveActives("Kill"));}
            boolean cultKill = game.getPlayers()[0].getRole().haveActives("Kill");

            System.out.println(game.getPlayers()[0].getName());
            assertEquals(cultKill, true);
        }
        public void testHaveActivesInvest() 
        {
            if (debug) {System.out.println("TestActivesInvestigator");}
            boolean blueInvest = game.getPlayers()[1].getRole().haveActives("Investigate");
            //System.out.println(game.getPlayers()[1].getName());
            assertEquals(blueInvest, true);
        }
        public void testHaveActivesBlue()
        {
            if (debug) {System.out.println("TestActivesBlue");}
            boolean bluePlayer = game.getPlayers()[2].getRole().haveActives("0");
            assertEquals(bluePlayer, true);
        }
        
        @Test
        public void testNumberOfPlayers()
        {
            if (debug) {System.out.println("TestActivesInvestigator");}
            int noPlayers = game.getNumCharacters();
            System.out.println(noPlayers);
            assertEquals(noPlayers, 9);
            //assertEquals(game.getPlayers());
        }
    }
