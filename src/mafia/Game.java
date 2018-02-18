package mafia;

public class Game {

	private static String gameEnd(Characters[] players)
	{
		int cultNumber = 0, blueNumber = 0;
		for (int i=0;i<players.length;i++)
		{
			//Test how many players there are alive
			switch (players[i].getRole().getTeam().getTeam())
			{
				case CULT : 
				{
					if (players[i].getPlayerstate() == PlayerState.ALIVE) 
					{
						cultNumber++; break;
					} 
					else {break;}
				}
				case BLUE : blueNumber++; break;
			}
			
			//1 cult and 1 player
			if (cultNumber == 1 && (blueNumber == 1 || blueNumber == 0))
			{
				return "Cult";
			}
			if (cultNumber == 0)
			{
				return "Blue";
			}
		}
		return "No";
	}
	public static void main(String[] args) throws InterruptedException 
	{
		//Method to create characters and assign them roles
		int numCharacters = 5;
		int cultCount = 0;
		int cultCharacter = 2;
		
		cultCharacter = (int)(Math.random() * numCharacters);
		
		Characters[] players = new Characters[numCharacters];
		for (int i = 0; i<numCharacters;i++)
		{
			players[i] = new Characters("Danny",PlayerState.ALIVE,false);
			if (i == cultCharacter) {players[i].setRoleCult();}
			System.out.println("Character " + i + " is " + players[i].getRole());
		}
		
		//Game loop
		while ((gameEnd(players)) == "No")
		{
			
		}
		
		if (gameEnd(players) == "Blue")
		{
			System.out.println("Blue team won! Congratulations");
		}
		if (gameEnd(players) == "Cult")
		{
			System.out.println("Cult won! You're all noobs");
		}
		Thread.sleep(10000);
		
		/*for (int i = 0; i<(numCharacter/3); i++)
		{
			
			if (characters[cultPerson].getRole() == Role.CULT)
		    //Reject and make a new character CULT
			{
				i--;
			}
			//Make cult
			else
			{
				characters[i].setRole(Role.CULT);
			}
		}
		*/
	}
}
