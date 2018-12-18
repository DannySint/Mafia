package mafia.actions;

import mafia.Player;
import mafia.Health;
import mafia.PlayerState;

public class Heal extends Action
{

    public Heal(Player subject, Player recipient)
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
        //if the player is dead then set them to healed.
        //This works because the game will not let someone target a dead person so if they've been targeted but they're dead that means they were alive and hence have just been killed.
        this.getRecipient().setHealth(Health.HEALTHY);
        this.getRecipient().setPlayerState(PlayerState.ALIVE);
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
        return true;
        
    }

}
