package mafia;

public class Characters 
{
	//instance attributes (Role, Abilities) 
	private String name;
	private String playerState;
	private Role role;
	
	//static attributes
	private static int count = 0;
	/**
	 * Characters constructor method
	 * @param name = Name of player
	 * @param playerState = Alive or Dead?
	 * @param cultFlag = Whether the person being created is a cult member
	 */
	public Characters(String name, String playerState, boolean cultFlag)
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
	public String getPlayerstate() {return playerState;}
	public Role getRole() {return role;}
	
	//Setter Methods
	public void setName(String name) {this.name = name;}
	public void setPlayerState(String playerState) {this.playerState = playerState;}
	
	//Ability method
	/* 
	 * 
	 */
	public boolean kill(Characters character) {character.setPlayerState("Dead"); return true;}
	
	public static void main(String[] args)
	{
		//Characters[] characters = new Characters[3];
		//characters[0].getRole();
		Characters character1 = new Characters("Danny", "Alive", true);
		Characters character2 = new Characters("Jack", "Alive", false);
		character1.role.setRoleCult();
		
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