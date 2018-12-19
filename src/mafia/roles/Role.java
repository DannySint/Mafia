package mafia.roles;

import java.util.ArrayList;
import java.util.EnumMap;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Player;
import mafia.PlayerState;
import mafia.Team;

public abstract class Role { 
    
	//instance variables
	private String name;
	private ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>();
	private ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>();
	private Team team;

    protected boolean won;

	//static variables
	private static final String ZERO = "0"; //placeholder for "no ability selected"
	
	public Role(String name, ArrayList<AbilityPassive> passives, ArrayList<AbilityActive> actives, Team team)
	{
	    this.name = name;
	    this.passives = passives;
	    this.actives = actives;
	    this.team = team;
	}
	
    public boolean haveActives(String input)
    {
        if (actives.get(0) == null) {return false;}
        for (int i = 0; i < actives.size(); i++)
        {
            if (actives.get(i).getName().equals(input)) {return true;}
        }
        return false;
    }
    public boolean havePassives(String input)
    {
        if (passives.get(0) == null) {return false;}
        for (int i = 0; i < passives.size(); i++)
        {
            if (passives.get(i).getName().equals(input)) {return true;}
        }
        return false;
    }

	public String getName() {return this.name;}
	public Team getTeam() {return this.team;}
	
	
	public ArrayList<AbilityPassive> getPassives() {return passives;}
    public void setPassives(ArrayList<AbilityPassive> passives) {this.passives = passives;}
    public ArrayList<AbilityActive> getActives() {return actives;}
    public void setActives(ArrayList<AbilityActive> actives) {this.actives = actives;}
    public boolean isWon() {return won;}
    public void setWon(boolean won) {this.won = won;}
    
    //Abilities validation
    public boolean validate(Player subject, Player recipient, String action) //validates check on yourself & dead people
    {
        if (!subject.getRole().haveActives(action)) {System.out.println("You do not have this action: " + action + "."); return false;}
        if (subject.equals(recipient)) {System.out.println("You cannot " + action + " yourself. Please try again."); return false;}
        if (recipient.getPlayerstate() == PlayerState.DEAD) {System.out.println("You cannot " + action + " a dead person."); return false;}
        return true;
    }
    
    public abstract boolean victory(Player[] players);
    
	@Override
    public String toString()
    {
        return "Role [name=" + name + ", team=" + team + "]";
    }
}