package mafia;

public class Ability 
{
	private String name;
	private String passive;
	private String active;
	private int timeframe;
	
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
	public boolean kill(Characters character)
	{
		if (character.getRole().getAbility().getPassive() == "Immune") {return false;}
		else {return true;}
	}
}