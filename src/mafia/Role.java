package mafia;

public class Role {
	
    enum Team { CULT, BLUE}; 
    
	//instance variables
	private String name;
	private Ability ability = new Ability(zero, zero, zero, zero, 0);
	private Team team;
	
	//static variables
	private static final String zero = "0"; //placeholder for "no ability selected"
	private static int blueNumber;
	private static int cultNumber;
	private static int charactersNumber;
	
	public boolean setRoleCult() 
	{
		this.name = "Cult";
		this.setTeam(Team.CULT);
		//public Ability(String name, String passive1, String passive2, String active1, String active2, int timeframe) //2 actives constructor 2 passives
		this.ability = new Ability("nightDeathImmunity", zero ,"Kill", zero, 2); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0);
		return true;
	}
	public void setRoleBlue() 
	{
		this.name = "Blue Player";
		this.setTeam(Team.BLUE);
		this.ability = new Ability(zero , zero, zero, zero , 0);
	}
	public boolean setRoleInvestigator() //THE ONLY METHOD TO SET ROLE - otherwise counting chars fucks up 
	{
		this.name = "Investigator";
		this.setTeam(Team.BLUE);
		this.ability = new Ability("nightDeathImmunity", zero, "Investigate", zero, 0); //ability.setName(zero); ability.setPassive(zero); ability.setActive(zero); ability.setTimeFrame(0); 
		return true;
	}
	
   private void setTeam(Team team) 
    {   
        this.team = team;
        switch (this.team)
        {
            case CULT : {cultNumber++; charactersNumber++; break;}
            case BLUE : {blueNumber++; charactersNumber++; break;}
        }
    }
	
	public String getName() {return this.name;}
	public Team getTeam() {return this.team;}
	public Ability getAbility() {return this.ability;}
	public static int getBlueNumber() {return blueNumber;} //Need testing to ensure works correctly
	public static int getCultNumber() {return cultNumber;} //same
	public static int getCharactersNumber() {return charactersNumber;} //same
	public String toString() {return ("Role: " + name + "Team: " + team);} //+ "\nRole: " + ability.getName() + ". Passive1: " + ability.getPassives(0) + ". Passive2: " + ability.getPassives(1) + ". Active: " + ability.getActives(0) + ". Timeframe: "+ ability.getTimeframe());}
	
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
		System.out.println("Blue Number: " + getBlueNumber()); //outputs 2
		System.out.println("Cult Number: " + getCultNumber()); //outputs 1
	}
}