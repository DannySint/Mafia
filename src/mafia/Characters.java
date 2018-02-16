package mafia;

enum Team {	CULT, BLUE };

public class Characters 
{
	//instance attributes (Role, Abilities) 
	private String name;
	private String playerState;
	private Role role;
	
	//static attributes
	private static int count = 0;
	
	public Characters()
	{
		count++;
		
	}
	
	public Team getRole()
	{
		return this.team;
	}

	public boolean setCult(Team r)
	{
		if (this.Role == Team.CULT)
		{
			return false;
		}
		else
		{
			this.team = Team.CULT;
			return true;
		}
		
	}
	public boolean setTeam(Team r)
	{
		if (this.team == Team.CULT)
		{
			return false;
		}
		else
		{
			this.team = Team.CULT;
			return true;
		}
	}
}