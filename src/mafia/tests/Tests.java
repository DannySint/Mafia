package mafia.tests;

import mafia.Health;
import mafia.Player;
import mafia.PlayerState;
import mafia.Role;
import mafia.roles.Investigator;
import mafia.roles.Killer;

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
            System.out.println("Ability: " + character2.getRole().getAbility());
        }
        
        public static void role() //role class
        {
            Role test1 = new Role();
            Role test2 = new Role();
            Role test3 = new Role();
            Role test4 = new Role();
            test1.setRoleCult(); //sets test1 to cult
            test2.setRoleBlue(); //sets test2 to blue
            test3.setRoleBlue(); //sets test3 to blue
            test4.setRoleBlue(); //sets test4 to blue
            System.out.println(test1); //outputs toString method of "Team: CULT \nName: Kill. Passive: P1. Active: A2. Timeframe: 2"
            System.out.println(test2); //outputs toString method of "Team: BLUE \nName: 0. Passive: 0. Active: 0. Timeframe: 0"
            System.out.println("Blue Number: " + getBlueNumber()); //outputs 2
            System.out.println("Cult Number: " + getCultNumber()); //outputs 1
        }

    }
