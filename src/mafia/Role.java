package mafia;

public class Role {
	
	//instance variables
	String zero = "0"; //placeholder for "no ability selected"
	private Ability ability = new Ability(zero, zero, zero, zero, 0);
	private Team team = new Team();
	
	public boolean setRoleCult() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		team.setTeam(ETeam.CULT);
		ability = new Ability("KILL","nightDeathImmunity" ,"Kill",zero,2); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0);
		return true;
	}
	public void setRoleBlue() 
	{
		team.setTeam(ETeam.BLUE);
		ability = new Ability(zero , zero , zero, zero , 0);
	}
	public boolean setRoleInvestigator() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		team.setTeam(ETeam.BLUE);
		ability = new Ability("INVESTIGATE	","nightDeathImmunity","Investigate",zero,0); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0); 
		return true;
	}
	public Team getTeam() {return this.team;}
	public Ability getAbility() {return this.ability;}
	public String toString() {return ("Team: " + team + "\nName: " + ability.getName() + ". Passive: "+ ability.getPassive() + ". Active: " + ability.getActive() + ". Timeframe: "+ ability.getTimeframe());}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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