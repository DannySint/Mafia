package mafia;

public class Game {

	public static void main(String[] args) 
	{
		//Method to create players and assign them roles
		int numPlayers = 5;
		int cultCount = 0;
		int cultPerson = 0;
		
		Player players[] = new Player[numPlayers];
		
		for (int i = 0 ; i<numPlayers;i++)
		{
			players[i] = new Player();
		}
		
		//Run numberPlayers / 1 time
		cultPerson = (int)(Math.random() * numPlayers);
		players[cultPerson].setRole(Role.CULT);
		
		for (int i = 0; i<numPlayers;i++)
		{
			System.out.println("Person " + i + " is " + players[i].getRole());
		}
		
		
		
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
