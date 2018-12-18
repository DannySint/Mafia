package mafia.actions;

import mafia.Player;

public abstract class Action
{
    private Player subject;
    private Player recipient;
    
    public Player getSubject() {return subject;}
    public void setSubject(Player subject) {this.subject = subject;}
    
    public Player getRecipient() {return recipient;}
    public void setRecipient(Player recipient) {this.recipient = recipient;}
    
    public Action(Player subject, Player recipient)
    {
        this.subject = subject;
        this.recipient = recipient;
    }
    /**
     * actionPlayer() takes a subject and a recipient and returns whether the action would be successful.
     * @return Action on success; @return null on failure
     */
    public abstract Action actionPlayer();
    
    /**
     * execute() executes the action. e.g. for Kill it sets their state to dead. 
     * @return true on success. @return false on failure.
     */
    public abstract boolean execute();
}
