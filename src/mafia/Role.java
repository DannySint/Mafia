package mafia;

import java.util.ArrayList;
import java.util.EnumMap;

public class Role { 
    
	//instance variables
	private String name;
	//private Ability ability = new Ability(ZERO, ZERO, ZERO, ZERO, 0);
	private ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>();
	private ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>();
	private Team team;

	
	//static variables
	private static final String ZERO = "0"; //placeholder for "no ability selected"
	
	public Role(String name, ArrayList<AbilityPassive> passives, ArrayList<AbilityActive> actives, Team team)
	{
	    this.name = name;
	    this.passives = passives;
	    this.actives = actives;
	    this.team = team;    
	}
	
	/*
	public boolean setRoleCult() 
	{
		this.name = "Cult";
		this.setTeam(Team.CULT);
		//public Ability(String name, String passive1, String passive2, String active1, String active2, int timeframe) //2 actives constructor 2 passives
		this.ability = new Ability("nightDeathImmunity", ZERO ,"Kill", ZERO, 2); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0);
		return true;
	}
	public void setRoleBlue() 
	{
		this.name = "Blue Player";
		this.setTeam(Team.BLUE);
		this.ability = new Ability(ZERO , ZERO, ZERO, ZERO , 0);
	}
	public boolean setRoleInvestigator() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		this.name = "Investigator";
		this.setTeam(Team.BLUE);
		this.ability = new Ability("nightDeathImmunity", ZERO, "Investigate", ZERO, 0); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0); 
		return true;
	}
	
   private void setTeam(Team team) 
    {   
        this.team = team;
        switch (this.team)
        {
            case CULT : {cultNumber++; charactersNumber++; break;}
            case BLUE : {blueNumber++; charactersNumber++; break;}
        }
    }
    */
   //Ability existence check
	
    public boolean haveActives(String input)
    {
        for (int i = 0; i < actives.size(); i++)
        {
            if (actives.get(i).getName().equals(input)) {return true;}
        }
        return false;
    }
    public boolean havePassives(String input)
    {
        for (int i = 0; i < passives.size(); i++)
        {
            if (passives.get(i).getName().equals(input)) {return true;}
        }
        return false;
    }
    /*
    public boolean haveActives(String input)
    {
        for (int activesInt = 0; activesInt < getAbility().getTotalActives(); activesInt++)
        {
            if (this.getAbility().getActives(activesInt).equals(input)) {return true;}
        }
        return false;
    }
   */
	public String getName() {return this.name;}
	public Team getTeam() {return this.team;}
	
	
	//public Ability getAbility() {return this.ability;}
	public ArrayList<AbilityPassive> getPassives() {return passives;}
    public void setPassives(ArrayList<AbilityPassive> passives) {this.passives = passives;}
    public ArrayList<AbilityActive> getActives() {return actives;}
    public void setActives(ArrayList<AbilityActive> actives) {this.actives = actives;}
	
    //Abilities validation
    public boolean validate(Player subject, Player recipient, String action) //validates check on yourself & dead people
    {
        if (!subject.getRole().haveActives(action)) {System.out.println("You do not have this action: " + action + "."); return false;}
        if (subject.equals(recipient)) {System.out.println("You cannot " + action + " yourself. Please try again."); return false;}
        if (recipient.getPlayerstate() == PlayerState.DEAD) {System.out.println("You cannot " + action + " a dead person."); return false;}
        return true;
    }
    
	@Override
    public String toString()
    {
        return "Role [name=" + name + ", passives=" + passives + ", actives=" + actives + ", team=" + team + "]";
    }
}