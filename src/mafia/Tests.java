package mafia;

public class Tests
    {

        public Tests()
            {
                // TODO Auto-generated constructor stub
            }

        public static void main(String[] args)
        {
            Character character1 = new Character("Danny", PlayerState.ALIVE, Health.HEALTHY, false);
            Character character2 = new Character("Jacky", PlayerState.ALIVE, Health.HEALTHY, false);
            //character1.role.setRoleCult();
            
            //if (character2.role.getAbility().kill(character1)) {character1.setPlayerState(PlayerState.DEAD);}
            
            System.out.println("Name: " + character1.getName());
            System.out.println("State: " + character1.getPlayerstate());
            System.out.println("Team: " + character1.getRole().getTeam());
            System.out.println("Ability: " + character1.getRole().getAbility());

            //character1.kill(character2);
            //System.out.println(character1.role.ability.kill(character2));
            
            System.out.println();
            
            System.out.println("Name: " + character2.getName());
            System.out.println("State: " + character2.getPlayerstate());
            System.out.println("Team: " + character2.getRole().getTeam());
            System.out.println("Ability: " + character2.getRole().getAbility());
        }

    }
