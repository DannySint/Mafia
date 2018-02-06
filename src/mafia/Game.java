package mafia;

public class Game {

	public static void main(String[] args) 
	{
		//Method to create players and assign them roles
		int numPlayers = 3;
		int cultCount = 0;
		int cultPerson;
		
		Player players[] = new Player[5];
		
		//Run numberPlayers / 3 times
		cultPerson = (int)(Math.random() * 3);
		players[cultPerson].setRole(Role.CULT);
		System.out.println("Person " + cultPerson + "is cult");
		
		
		/*for (int i = 0; i<(numPlayers/3); i++)
		{
			
			if (players[cultPerson].getRole() == Role.CULT)
		    //Reject and make a new person CULT
			{
				i--;
			}
			//Make cult
			else
			{
				players[i].setRole(Role.CULT);
			}
		}
		*/
	}
}
