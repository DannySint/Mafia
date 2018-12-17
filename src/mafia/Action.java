package mafia;

import java.util.Scanner;

public abstract class Action
{
    private Character subject;
    private Character recipient;
    
    public Character getSubject() {return subject;}
    public void setSubject(Character subject) {this.subject = subject;}
    
    public Character getRecipient() {return recipient;}
    public void setRecipient(Character recipient) {this.recipient = recipient;}
    
    public Action(Character subject, Character recipient)
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
