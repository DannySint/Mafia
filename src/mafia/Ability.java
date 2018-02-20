package mafia;

public class Ability 
{
	private String name;
	private String passive;
	private String active;
	private int timeframe;
	private int uses;
	
	/**
	 * Constructor
	 * @param name
	 * @param passive
	 * @param active
	 * @param timeframe
	 */
	public Ability(String name, String passive, String active, int timeframe)
	{this.name=name;this.passive=passive;this.active=active;this.timeframe=timeframe;}
	
	//Getter methods
	public String getName() {return name;}
	public String getPassive() {return passive;}
	public String getActive() {return active;}
	public int getTimeframe() {return timeframe;}
	
	//Setter methods
	public void setName(String name) {this.name=name;}
	public void setPassive(String passive) {this.passive=passive;}
	public void setActive(String active) {this.active=active;}
	public void setTimeFrame(int timeframe) {this.timeframe=timeframe;}
	
	//toString method
	public String toString() {return ("Name: " + name + " Passive: " + passive + " Active: " + active + " Timeframe: " + timeframe);}
 	
	//Cult abilities
	public boolean validate(Characters[] players, int i, int inputInt, String input) //validates check on yourself & dead people
	{
		if (i == inputInt) {System.out.println("You cannot " + input + " yourself. Please try again."); return false;}
		if (players[inputInt].getPlayerstate() == PlayerState.DEAD) {System.out.println("You cannot " + input + " a dead person"); return false;}
		return true;
	}
	public boolean kill(Characters[] players, int i, int inputInt)
	{
		if (players[inputInt].getRole().getAbility().getPassive() == "nightDeathImmunity") {return false;}
		else {return true;}
	}
	public boolean investigate(Characters[] players, int i, int inputInt)
	{
		if (players[inputInt].getRole().getTeam().getTeam() == ETeam.CULT) {return true;}
		else {return false;}
	}
	
	/*Code that was in Game.java
	if (players[i].getRole().getAbility().getActive() == "Kill")
	{
		do 
		{
			System.out.println("Which player would you like to kill?");
			inputInt = scanner.nextInt();
			if (i == inputInt) {System.out.println("You cannot kill yourself. Please try again.");}
			if (players[inputInt].getPlayerstate() == PlayerState.DEAD) 
			{
				System.out.println("You cannot kill a dead person");
			}
		} while ((players[inputInt].getPlayerstate() == PlayerState.DEAD) || i == inputInt);
		if (players[inputInt].getPlayerstate() == PlayerState.DEAD) 
			{}
		else 
			{players[inputInt].setPlayerState(PlayerState.DEAD);}
	}
	else {System.out.println("You do not have that ability");}*/
	
	public boolean poison(Characters character) //poison ability
	{
		if (character.getRole().getAbility().getPassive() == "poisonImmunity") {return false;}
		else {return true;}
	}
}