package mafia.actions;

import mafia.Health;
import mafia.Player;

public class Poison extends Action
{

    public Poison(Player subject, Player recipient)
    {
        super(subject, recipient);
    }
    
    public Action actionPlayer() 
    {
        Action action = null;

        if (getRecipient().getRole().havePassives("poisonImmunity")) 
        {
            System.out.println("Player " + getRecipient().getName() + " was immune to your action.");
        }
        else
        {
            switch (getRecipient().getHealth())
            {
            case POISONED_3 : case POISONED_2 : case POISONED_1 :
                System.out.println(getRecipient().getName() + " is already poisoned.");
                break;
            default:
                System.out.println(getRecipient().getName() + " was poisoned!");
                getRecipient().setHealth(Health.POISONED_1);
                break;
            }
        }
        return action;
    }

    @Override
    public boolean execute()
    {
        this.getRecipient().setHealth(Health.POISONED_1);
        return true;
    }
}
