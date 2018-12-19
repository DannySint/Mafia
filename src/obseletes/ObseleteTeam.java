package obseletes;

enum DeadTeam { CULT, BLUE };
enum ETeam {CULT, BLUE };
public class ObseleteTeam 
{
	private ETeam team;
	private static int blueNumber;
	private static int cultNumber;
	private static int charactersNumber;
	
	//Constructor Method
	ObseleteTeam() {}
	
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