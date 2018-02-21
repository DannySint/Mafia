package mafia;

public class Ability 
{
	//private String name;
	private int totalPassives;
	private String passive;
	private int totalActives;
	private String active;
	private String[] actives = new String[2];
	private String[] passives = new String[2];
	private int priority;
	private int timeframe;
	private int uses;
	
	/**
	 * Constructor
	 * @param passive
	 * @param active
	 * @param timeframe
	 */
	//public Ability(String name, String passive, String active, int timeframe, int i) //single active constructor - no longer used
	//{this.name=name;this.passive=passive;this.active=active;this.timeframe=timeframe;}
	
	/*public Ability(String name, String passive, String active1, String active2, int timeframe) //2 actives constructor 1 passive
	{
		this.name=name;
		this.passive=passive;
		this.totalActives = 2;
		this.actives[0] = active1;
		this.actives[1] = active2;
		this.timeframe=timeframe;
	}*/
	 
	public Ability(String passive1, String active1, String active2, int timeframe) //2 actives constructor 1 passive
	{
		this.totalPassives = 1;
		this.passives[0]=passive1;
		this.totalActives = 2;
		this.actives[0] = active1;
		this.actives[1] = active2;
		this.timeframe=timeframe;
	}
	
	public Ability(String passive1, String passive2, String active1, String active2, int timeframe) //2 actives constructor 2 passives
	{
		this.totalPassives = 2;
		this.passives[0]=passive1;
		this.passives[1]=passive2;
		this.totalActives = 2;
		this.actives[0] = active1;
		this.actives[1] = active2;
		this.timeframe=timeframe;
	}
	
	
	//Getter methods
	//public String getPassive() {return passive;} //unused
	public String[] getPassive() {return passives;}
	public String getPassives(int i) 
		{return passives[i];}
	public int getTotalPassives() {return totalPassives;}
	//public String getActive() {return active;} //unused
	public String[] getActive() {return actives;} //unused
	//public String getActiveArr() {return actives;}
	public String getActives(int i) 
		{return actives[i];}
	public int getTotalActives() {return totalActives;}
	public int getTimeframe() {return timeframe;}
	public int getUses() {return uses;}
	
	//Setter methods
	public void setPassive(String passive) {this.passive=passive;}
	public void setPassives(String passives, int Num) {this.passives[Num] = passives;}
	public void setActive(String active) {this.active=active;}
	public void setActives(String actives, int Num) {this.actives[Num] = actives;}
	public void setTimeFrame(int timeframe) {this.timeframe=timeframe;}
	public void decrementUses(int uses) {this.uses--;}
	public void incrementUses(int uses) {this.uses--;}
	
	//toString method
	public String toString() {return ("Passive1: " + passives[0] + ". Passive2: " + passives[1]  + ". Active1: " + actives[0] + ". Active2: " + actives[1] + ". Timeframe: " + timeframe);}
	
	//Ability existence check
	public boolean haveActives(Characters[] players, int i, String input)
	{
		for (int activesInt=0;activesInt<actives.length;activesInt++)
		{
			System.out.println("ActiveInt " + activesInt);
			System.out.println("1. " + players[i].getRole().getAbility().getActives(activesInt));
			System.out.println("2. " + actives[activesInt]);
			System.out.println(players[i].getRole().getAbility().getActives(activesInt).equals(actives[activesInt]));
			if (players[i].getRole().getAbility().getActives(activesInt).equals(actives[activesInt])) {return true;}
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
		for (int j=0;j<this.getTotalPassives();j++) 
		{
			if (players[inputInt].getRole().getAbility().getPassives(j) == "nightDeathImmunity") {return false;}
		}
		//if (players[inputInt].getRole().getAbility().getPassives(0) == "nightDeathImmunity") {return false;}
		//if (players[inputInt].getRole().getAbility().getPassives(1) == "nightDeathImmunity") {return false;}
		//if (players[inputInt].getRole().getAbility().getPassive() == "nightDeathImmunity") {return false;}
		return true;
	}
	
	//Investigate ability
	public boolean investigate(Characters[] players, int i, int inputInt)
	{
		if (players[inputInt].getRole().getTeam().getTeam() == ETeam.CULT) {return true;}
		else {return false;}
	}

	public boolean poison(Characters[] players, int i, int inputInt) //poison ability
	{
		for (int j=0;j<this.getTotalPassives();j++) 
		{
			if (players[inputInt].getRole().getAbility().getPassives(j) == "nightDeathImmunity") {return false;}
		}
		return true;
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