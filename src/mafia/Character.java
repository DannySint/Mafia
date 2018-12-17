package mafia;

enum PlayerState { ALIVE, ATTACKED, HEALED, DEAD }
enum Health { HEALTHY, POISONED_1, POISONED_2, POISONED_3, }

public class Character 
{
	//instance attributes (Role, Abilities) 
	private String name;
	private PlayerState playerState;
	private Health health;
	private Role role;
	
	//static attributes
	private static int count = 0;
	/**
	 * Characters constructor method
	 * @param name = String - name of player
	 * @param PlayerState = enum - Dead or Alive?
	 * @param cultFlag = Boolean - Whether the person being created is a cult member
	 */
    public Character(String name, PlayerState playerState, Health health, boolean cultFlag)
	{
		this.name = name;
		this.playerState = playerState;
    	this.health = health;
		this.role = new Role();
		if (cultFlag) {this.role.setRoleCult();}
		else if (!cultFlag) {this.role.setRoleBlue();}
		else {
			this.role.setRoleBlue();
			System.out.println("Error setting role");
			}
		count++;
	}
    
	//Getter Methods
	public String getName() {return name;}
	public PlayerState getPlayerstate() {return playerState;}
    public Health getHealth() {return health;}
	public Role getRole() {return role;}
	
	//Setter Methods
	public void setName(String name) {this.name = name;}
	public void setPlayerState(PlayerState playerState) {this.playerState = playerState;}
	public void setHealth(Health health) {this.health = health;}
	public void setRoleCult() {role.setRoleCult();}
	public void setRoleBlue() {role.setRoleBlue();}
	public void setRoleInvestigator() {role.setRoleInvestigator();}
}