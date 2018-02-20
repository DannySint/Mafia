package mafia;

enum PlayerState { ALIVE, POISONED_1, POISONED_2, POISONED_3, DEAD }

public class Characters 
{
	//instance attributes (Role, Abilities) 
	private String name;
	private PlayerState playerState;
	private Role role;
	
	//static attributes
	private static int count = 0;
	/**
	 * Characters constructor method
	 * @param name = String - name of player
	 * @param PlayerState = enum - Alive or Dead?
	 * @param cultFlag = Boolean - Whether the person being created is a cult member
	 */
	public Characters(String name, PlayerState playerState, boolean cultFlag)
	{
		this.name = name;
		this.role = new Role();
		if (cultFlag) {this.role.setRoleCult();}
		else if (!cultFlag) {this.role.setRoleBlue();}
		else {
			this.role.setRoleBlue();
			System.out.println("Error setting role");
			}
		this.playerState = playerState;
		count++;	
	}
	//Getter Methods
	public String getName() {return name;}
	public PlayerState getPlayerstate() {return playerState;}
	public Role getRole() {return role;}
	
	//Setter Methods
	public void setName(String name) {this.name = name;}
	public void setPlayerState(PlayerState playerState) {this.playerState = playerState;}
	public void setRoleCult() {role.setRoleCult();}
	public void setRoleBlue() {role.setRoleBlue();}
	public void setRoleInvestigator() {role.setRoleInvestigator();}
	
	public static void main(String[] args)
	{
		Characters character1 = new Characters("Danny", PlayerState.ALIVE, false);
		Characters character2 = new Characters("Jacky", PlayerState.ALIVE, false);
		//character1.role.setRoleCult();
		
		//if (character2.role.getAbility().kill(character1)) {character1.setPlayerState(PlayerState.DEAD);}
		
		System.out.println("Name: " + character1.getName());
		System.out.println("State: " + character1.getPlayerstate());
		System.out.println("Team: " + character1.role.getTeam());
		System.out.println("Ability: " + character1.role.getAbility());

		//character1.kill(character2);
		//System.out.println(character1.role.ability.kill(character2));
		
		System.out.println();
		
		System.out.println("Name: " + character2.getName());
		System.out.println("State: " + character2.getPlayerstate());
		System.out.println("Team: " + character2.role.getTeam());
		System.out.println("Ability: " + character2.role.getAbility());
	}
}