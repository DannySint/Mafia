package mafia.tests;

import mafia.Health;
import mafia.Player;
import mafia.PlayerState;
import mafia.roles.Killer;
import mafia.roles.Role;
import mafia.roles.blue.Investigator;
import mafia.roles.blue.RandomBlue;

public class Tests
    {

        public Tests()
            {
                // TODO Auto-generated constructor stub
            }

        public static void player() //Player class
        {
            Player character1 = new Player("Danny", PlayerState.ALIVE, Health.HEALTHY, new Killer());
            Player character2 = new Player("Jack", PlayerState.ALIVE, Health.HEALTHY, new Investigator());
            //character1.role.setRoleCult();
            
            //if (character2.role.getAbility().kill(character1)) {character1.setPlayerState(PlayerState.DEAD);}
            
            System.out.println("Name: " + character1.getName());
            System.out.println("State: " + character1.getPlayerstate());
            System.out.println("Team: " + character1.getRole().getTeam());
            System.out.println("Ability: " + character1.getRole().getActives());

            //character1.kill(character2);
            //System.out.println(character1.role.ability.kill(character2));
            
            System.out.println();
            
            System.out.println("Name: " + character2.getName());
            System.out.println("State: " + character2.getPlayerstate());
            System.out.println("Team: " + character2.getRole().getTeam());
            System.out.println("Passives: " + character2.getRole().getPassives());
            System.out.println("Actives: " + character2.getRole().getActives());
        }
        
        public static void role() //role class
        {
            Role test1 = new Killer();
            Role test2 = new Investigator();
            Role test3 = new RandomBlue();
            Role test4 = new RandomBlue();
            System.out.println(test1); //outputs toString method of "Team: CULT \nName: Kill. Passive: P1. Active: A2. Timeframe: 2"
            System.out.println(test2); //outputs toString method of "Team: BLUE \nName: 0. Passive: 0. Active: 0. Timeframe: 0"
            System.out.println(test3);
            System.out.println(test4);
            
        }
    }
