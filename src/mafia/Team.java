package mafia;

enum ETeam { CULT, BLUE };

public class Team 
{
	private ETeam team;
	private static int blueNumber;
	private static int cultNumber;
	private static int charactersNumber;
	
	//Constructor Method
	Team() {}
	
	//Getter methods
	public ETeam getTeam() {return team;}
	public static int getBlueNumber() {return blueNumber;} //Need testing to ensure works correctly
	public static int getCultNumber() {return cultNumber;} //same
	public static int getCharactersNumber() {return charactersNumber;} //same
	
	//Setter Methods
	public void setTeam(ETeam team) //DO NOT SET TEAMS THROUGH THIS METHOD DIRECTLY. MUST SET TEAMS USING Role.java 
	{	
		this.team = team;
		switch (this.team)
		{
			case CULT : {cultNumber++; charactersNumber++; break;}
			case BLUE : {blueNumber++; charactersNumber++; break;}
		}
	}
	
	public String toString() {return ("" + getTeam());}
	
}