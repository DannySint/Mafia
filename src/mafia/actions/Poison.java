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

        if (getRecipient().getRole().havePassives("poisonImmunity")) {
            action = new Poison(getSubject(), getRecipient());
        } else 
        {
            System.out.println("Player " + getRecipient().getName() + " was immune to your action");
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
