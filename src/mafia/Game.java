package mafia;

public class Game {

	public static void main(String[] args) 
	{
		//Method to create characters and assign them roles
		int numCharacters = 5;
		int cultCount = 0;
		int cultCharacter = 2;
		
		Characters characters[] = new Characters[numCharacters];
		
		for (int i = 0 ; i<numCharacters;i++)
		{
			characters[i] = new Characters("Danny", "Alive", true);
			}
		
		//Run numberPlayers / 1 time
		cultCharacter = (int)(Math.random() * numCharacters);
		//characters[cultCharacter].setTeam(Team.CULT);
		
		Characters[] players = new Characters[numCharacters];
		for (int i = 0; i<numCharacters;i++)
		{
			players[i] = new Characters("Danny","Alive",false);
			if (i == cultCharacter) {players[i].setRoleCult();}
			System.out.println("Character " + i + " is " + players[i].getRole());
		}
		
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
