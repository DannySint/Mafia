package mafia;

enum Role {	CULT, BLUE };

public class Player 
{
	private Role role;
	private static int count = 0;
	
	public Player()
	{
		count++;
	}
	public Player(Role r)
	{
		this.role = Role.BLUE;
	}
	
	public Role getRole()
	{
		return this.role;
	}

	public boolean setRole(Role r)
	{
		if (this.role == Role.CULT) 
		{
			return false;
		}
		else
		{
			this.role = Role.CULT;
			return true;
		}
	}
}