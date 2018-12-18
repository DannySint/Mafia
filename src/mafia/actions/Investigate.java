package mafia.actions;

import mafia.Player;

public class Investigate extends Action
{

    public Investigate(Player subject, Player recipient) {super(subject, recipient);}

    public Action actionPlayer()
    {
        Action action = null;
        action = new Investigate(getSubject(), getRecipient());
        return action;
    }

    public boolean execute() //executes the action
    {
        switch (getRecipient().getRole().getTeam())
        {
            case CULT : System.out.println("Player " + this.getRecipient().getName() + " is a member of the Cult!"); break;
            case BLUE : System.out.println("Player " + this.getRecipient().getName() + " is not a member of the Cult"); break;
        }
        return true;
    }

    public String toString()
    {
        return getSubject().getName() + " is investigating " + getRecipient().getName();
    }
    
    /*
    input = "Investigate";
    if (players[i].getRole().getAbility().haveActives(players, i, input)) // checks if user has ability)
    {
        input = "Investigate";
        do
        {
            System.out.println("Which player would you like to investigate?");
            inputInt = scanner.nextInt();
        } while (!(players[i].getRole().getAbility().validate(players, i, inputInt,
                input))); // validates user's input

        // actual investigating done here
        if (players[i].getRole().getAbility().investigate(players, i, inputInt)) // return true if member of cult
        {
            System.out.println("Player " + inputInt + " is a member of the Cult!");
        } else
        {
            System.out.println("Player " + inputInt + " is not a member of the Cult.");
        }
    }
    break;
    */
}
