package mafia.actions;

import mafia.Player;
import mafia.PlayerState;

public class Kill extends Action
{   
    public Kill(Player subject, Player recipient)
    {
        super(subject, recipient);
    }
    
    public Action actionPlayer() 
    {
        Action action = null;
        action = new Kill(getSubject(), getRecipient());
        return action;
    }
    
    public boolean execute()
    {
        if (getRecipient().getRole().havePassives("nightDeathImmunity")) 
        {
            System.out.println("Player " + getRecipient().getName() + " was immune to your action");
            return false;
        } else 
        {
            this.getRecipient().setPlayerState(PlayerState.DEAD);
            return true;
        }
    }
    
    public String toString()
    {
        return getSubject().getName() + " is killing " + getRecipient().getName();
    }
    
    //old code for Killing
    /*
    if (players[i].getRole().getAbility().haveActives(players, i, input)) // check if user ability
    {
        do
        {
            System.out.println("Which player would you like to kill?");
            inputInt = scanner.nextInt();
        } while (!(players[i].getRole().getAbility().validate(players, i, inputInt, input))); // Validate user's input

        // actual killing done here
        if (players[i].getRole().getAbility().kill(players, i, inputInt)) 
        {
            Kill kill = new Kill(players[i], players[inputInt]);
            actions.add(kill);
            //players[inputInt].setPlayerState(PlayerState.DEAD);
        } else {
            System.out.println("Player " + inputInt + " was immune to your attack");
        }
    }
    break;
    */
}
