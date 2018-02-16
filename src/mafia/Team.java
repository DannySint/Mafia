package mafia;

enum ETeam { CULT, BLUE };

public class Team 
{
	private ETeam team;
	private static int blueNumber;
	private static int cultNumber;
	
	
	Team()
	{
		
	}
	
	public int getBlueNumber() {return blueNumber;}
	public int getCultNumber() {return cultNumber;}
	
}