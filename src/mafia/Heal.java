package mafia;

public class Heal extends Action
{

    public Heal(Character subject, Character recipient)
    {
        super(subject, recipient);
    }

    @Override
    public Action actionPlayer()
    {
        //add code to check the current ActionList to see if the recipient of the heal is a recipient of a heal.
        /*if (players[playerID].getPlayerstate() == PlayerState.ATTACKED) 
        {
            players[playerID].setPlayerState(PlayerState.HEALED);
            System.out.println("You were attacked but were healed.");
        }
        
        */
        return null;
        
    }

    @Override
    public boolean execute()
    {
        /*
        if (players[playerID].getPlayerstate() == PlayerState.ATTACKED) 
            {
                players[playerID].setPlayerState(PlayerState.HEALED);
                System.out.println("You were attacked but were healed.");
            }
        //Curing poison
        if ((players[playerID].getHealth() == Health.POISONED_1 || players[playerID].getHealth() == Health.POISONED_2 || players[playerID].getHealth() == Health.POISONED_3)) 
            {
                players[playerID].setHealth(Health.HEALTHY);
                System.out.println("You were cured of your poison");
            }
        return true;
        */
        return false;
        
    }

}
