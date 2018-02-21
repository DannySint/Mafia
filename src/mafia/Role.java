package mafia;

public class Role {
	
	//instance variables
	private static final String zero = "0"; //placeholder for "no ability selected"
	private String name;
	private Ability ability = new Ability(zero, zero, zero, zero, 0);
	private Team team = new Team();
	
	public boolean setRoleCult() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		name = "Cult";
		team.setTeam(ETeam.CULT);
		//public Ability(String name, String passive1, String passive2, String active1, String active2, int timeframe) //2 actives constructor 2 passives
		ability = new Ability("nightDeathImmunity", zero ,"Kill",zero,2); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0);
		return true;
	}
	public void setRoleBlue() 
	{
		name = "Blue Player";
		team.setTeam(ETeam.BLUE);
		ability = new Ability(zero , zero, zero, zero , 0);
	}
	public boolean setRoleInvestigator() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		name = "Investigator";
		team.setTeam(ETeam.BLUE);
		ability = new Ability("nightDeathImmunity", zero, "Investigate",zero, 0); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0); 
		return true;
	}
	public String getName() {return this.name;}
	public Team getTeam() {return this.team;}
	public Ability getAbility() {return this.ability;}
	public String toString() {return ("Team: " + team);} //+ "\nRole: " + ability.getName() + ". Passive1: " + ability.getPassives(0) + ". Passive2: " + ability.getPassives(1) + ". Active: " + ability.getActives(0) + ". Timeframe: "+ ability.getTimeframe());}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Role test1 = new Role();
		Role test2 = new Role();
		Role test3 = new Role();
		Role test4 = new Role();
		test1.setRoleCult(); //sets test1 to cult
		test2.setRoleBlue(); //sets test2 to blue
		test3.setRoleBlue(); //sets test3 to blue
		test4.setRoleBlue(); //sets test4 to blue
		System.out.println(test1); //outputs toString method of "Team: CULT \nName: Kill. Passive: P1. Active: A2. Timeframe: 2"
		System.out.println(test2); //outputs toString method of "Team: BLUE \nName: 0. Passive: 0. Active: 0. Timeframe: 0"
		System.out.println("Blue Number: " + Team.getBlueNumber()); //outputs 2
		System.out.println("Cult Number: " + Team.getCultNumber()); //outputs 1
	}
}