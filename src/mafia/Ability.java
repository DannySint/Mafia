package mafia;

public class Ability 
{
	private String name;
	private String passive;
	private int totalActives;
	private String active;
	//private String[] actives;
	private String[] actives = new String[2];
	private int timeframe;
	private int uses;
	
	/**
	 * Constructor
	 * @param name
	 * @param passive
	 * @param active
	 * @param timeframe
	 */
	//public Ability(String name, String passive, String active, int timeframe, int i)
	//{this.name=name;this.passive=passive;this.active=active;this.timeframe=timeframe;}
	
	public Ability(String name, String passive, String active1, String active2, int timeframe) //2 actives constructor
	{this.name=name;this.passive=passive;
	this.totalActives = 2;
	this.actives[0] = active1;
	this.actives[1] = active2;
	this.timeframe=timeframe;}
	
	//Getter methods
	public String getName() {return name;}
	public String getPassive() {return passive;}
	//public String getActive() {return active;}
	public String[] getActive() {return actives;}
	public String getActives(int i) 
	{
		return actives[i];
	}
	public int getTotalActives() {return totalActives;}
	public int getTimeframe() {return timeframe;}
	public int getUses() {return uses;}
	
	//Setter methods
	public void setName(String name) {this.name=name;}
	public void setPassive(String passive) {this.passive=passive;}
	public void setActive(String active) {this.active=active;}
	public void setActives(String actives, int Num) {this.actives[Num] = actives;}
	public void setTimeFrame(int timeframe) {this.timeframe=timeframe;}
	public void decrementUses(int uses) {this.uses--;}
	public void incrementUses(int uses) {this.uses--;}
	
	//toString method
	public String toString() {return ("Name: " + name + " Passive: " + passive + " Active: " + active + " Timeframe: " + timeframe);}
 	
	//Ability existence check
	public boolean haveActives(Characters[] players, int i, String input)
	{
		for (int activesInt=0;activesInt<actives.length;activesInt++)
		{
			if (players[i].getRole().getAbility().getActives(activesInt).equals(actives[activesInt])) {return true;}
			System.out.println("1. " + players[i].getRole().getAbility().getActives(activesInt));
			System.out.println("2. " + actives[activesInt]);
		}
		return false;
//		if (players[i].getRole().getAbility().getActive().equals(input)) {return true;} else {return false;}
	}
	
	//Abilities validation
	public boolean validate(Characters[] players, int i, int inputInt, String input) //validates check on yourself & dead people
	{
		if (i == inputInt) {System.out.println("You cannot " + input + " yourself. Please try again."); return false;}
		if (players[inputInt].getPlayerstate() == PlayerState.DEAD) {System.out.println("You cannot " + input + " a dead person"); return false;}
		return true;
	}
	
	//Kill ability
	public boolean kill(Characters[] players, int i, int inputInt)
	{
		if (players[inputInt].getRole().getAbility().getPassive() == "nightDeathImmunity") {return false;}
		else {return true;}
	}
	
	//Investigate ability
	public boolean investigate(Characters[] players, int i, int inputInt)
	{
		if (players[inputInt].getRole().getTeam().getTeam() == ETeam.CULT) {return true;}
		else {return false;}
	}

	public boolean poison(Characters character) //poison ability
	{
		if (character.getRole().getAbility().getPassive() == "poisonImmunity") {return false;}
		else {return true;}
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
}