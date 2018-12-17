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
	
	public String[] getPassive() {return passives;}
	public String getPassives(int i) 
		{return passives[i];}
	public int getTotalPassives() {return totalPassives;}
	public String[] getActive() {return actives;} //unused
	public String getActives(int i)
		{return actives[i];}
	public int getTotalActives() {return totalActives;}
	public int getTimeframe() {return timeframe;}
	public int getUses() {return uses;}
	
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
   public boolean haveActives(Character subject, String input)
    {
        for (int activesInt=0;activesInt<actives.length;activesInt++)
        {
            if (subject.getRole().getAbility().getActives(activesInt).equals(input)) {return true;}
        }
        return false;
    }

	//Abilities validation
	public boolean validate(Character subject, Character recipient, String action) //validates check on yourself & dead people
	{
		if (subject.equals(recipient)) {System.out.println("You cannot " + action + " yourself. Please try again."); return false;}
		if (recipient.getPlayerstate() == PlayerState.DEAD) {System.out.println("You cannot " + action + " a dead person."); return false;}
		if (!subject.getRole().getAbility().haveActives(subject, action)) {System.out.println("You do not have this action: " + action + "."); return false;}
		return true;
	}
	

	


	public boolean poison(Character[] players, int playerID, int inputInt) //poison ability
	{
		for (int j=0;j<this.getTotalPassives();j++) 
		{
			if (players[inputInt].getRole().getAbility().getPassives(j) == "nightDeathImmunity") {return false;}
		}
		return true;
	}
}