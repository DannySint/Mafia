package mafia;

import java.util.*;

public class Game {

	public static void displayCharacterData(Characters[] players, int i) //Administrative function
	{
		System.out.println("Character " + i + " is " + players[i].getRole().getName());
		System.out.println("Character " + i + " is " + players[i].getRole());
		System.out.println("Player Name: " + players[i].getName() +  ". Player State: " + players[i].getPlayerstate());
	}
	public static void displayCharacters(Characters[] players) //Player function
	{
		for (int i=0;i<players.length;i++)
		{
			System.out.print(players[i].getName() + ": Player " + i + ".");
			System.out.println(" Name: " + players[i].getName() +  ". Player State: " + players[i].getPlayerstate());
		}
		System.out.println();
	}

	public static void main(String[] args) throws InterruptedException 
	{
		String[] names = {"Danny","Jack","Kirito","Asuna","Edward","Alphone","Saber","Lancer","Archer","Rider","Caster","Beserker","Assassin","Avenger"};
		//Method to create characters and assign them roles
		int numCharacters = 6;
		int cultCharacter = 0;
		int investigatorCharacter = 0;
		
		//Assign a random person with the cult.
		cultCharacter = (int)(Math.random() * numCharacters);
		do
		{
			investigatorCharacter = (int)(Math.random() * numCharacters);
		}
		while (investigatorCharacter == cultCharacter); //do not override the cult member with the investigator
		Characters[] players = new Characters[numCharacters]; //creates new array for players
		for (int i = 0; i<numCharacters;i++)
		{
		    players[i] = new Characters(names[i],PlayerState.ALIVE,false);
			if (i == cultCharacter) {players[i].setRoleCult();}
			if ((i == investigatorCharacter) && players[i].getRole().getTeam().getTeam() == ETeam.BLUE) {players[i].setRoleInvestigator();}
			//displayCharacterData(players, i);
		}
		
		//Game loop
		Scanner scanner = new Scanner(System.in); 
		int inputInt = 0;
		String input = "";
		while ((gameEnd(players)) == "No")
		{
			for (int i=0;i<players.length;i++)
			{
				//displayCharacterData(players, i); //adminfunction
				displayCharacters(players); //playerfunction
				if ((players[i].getPlayerstate() == PlayerState.DEAD))
				{
					System.out.println("\nPlayer " + i + " is dead and cannot perform any actions");
				}
				else 
				{
					do 
					{
						System.out.println("Player: " + i + ", you are: " + players[i].getRole().getName());
						System.out.print("\nPlayer: " + i + ". Your passive abilities are: ");
						for (int j=0;j<players[i].getRole().getAbility().getTotalPassives();j++)
						{
							
							System.out.print(players[i].getRole().getAbility().getPassives(j));
							if (players[i].getRole().getAbility().getPassives(j) == "0" || (players[i].getRole().getAbility().getPassives(j) == "")) {break;} //stops printing abilities if ability is 0 (nothing)
							System.out.print(", ");
						}
						System.out.print("\nPlayer: " + i + ". Your active abilities are: ");
						for (int j=0;j<players[i].getRole().getAbility().getTotalActives();j++)
						{
							
							System.out.print(players[i].getRole().getAbility().getActives(j));
							if (players[i].getRole().getAbility().getActives(j) == "0") {break;} //stops printing abilities if ability is 0 (nothing)
							System.out.print(", ");
						}
						 
						System.out.println("\nWhich ability would you like to use?");
						input = scanner.next();
						switch(input)
						{
						case "Kill" : //currently immediately kills. Needs to kill at end of night.
							{
								if (players[i].getRole().getAbility().haveActives(players, i, input)) //check if user has ability

								{
									do 
									{
										System.out.println("Which player would you like to kill?"); 
										inputInt = scanner.nextInt();
									} while (!(players[i].getRole().getAbility().validate(players, i, inputInt, input))); //Validate user's input
									
									//actual killing done here
									if (players[i].getRole().getAbility().kill(players, i, inputInt))
										{players[inputInt].setPlayerState(PlayerState.DEAD);}
									else {System.out.println("Player " + inputInt + " was immune to your attack");}
								}
								else {System.out.println("You do not have that ability");}
								break;
							}
						case "Investigate" : case "Inv" : 
							{
								if (players[i].getRole().getAbility().haveActives(players,i,input)) //checks if user has ability)
								{
									input = "Investigate";
									do
									{
										System.out.println("Which player would you like to investigate?");
										inputInt = scanner.nextInt();
									} while (!(players[i].getRole().getAbility().validate(players, i , inputInt, input))); //validates user's input
									
									//actual investigating done here
									if (players[i].getRole().getAbility().investigate(players, i, inputInt)) //return true if member of cult
									{System.out.println("Player " + inputInt + " is a member of the Cult!");}
									else {System.out.println("Player " + inputInt + " is not a member of the Cult.");}
								}
								else {System.out.println("You do not have that ability");}
								break;
							}
						default :
							{break;}
						}
						if (!((players[i].getRole().getAbility().haveActives(players,i,input)))) 
							{System.out.println("That is not a valid ability. Please try again.");}
					} while (!(players[i].getRole().getAbility().haveActives(players,i,input)));
				}
			}
		}
		
		switch (gameEnd(players))
		{
			case "Blue" : {System.out.println("Blue team won! Congratulations"); break;}
			case "Cult" : {System.out.println("Cult won! You're all noobs"); break;}
			case "Draw" : {System.out.println("Draw..."); break;}
			default : {System.out.println("LUL. gameEnd somehow switched to default");}
		}
		Thread.sleep(1000);
		scanner.close();	
	}
	
	private static String gameEnd(Characters[] players) //test if victory condition has been met. Upgrade by getting win conditions from Teams.java
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
						//System.out.println("+1 Cult");
						cultNumber++; 
						break;
					} 
					else {break;}
				}
				case BLUE :
				{
					if (players[i].getPlayerstate() == PlayerState.ALIVE)
					{
						//System.out.println("+1 Blue");
						blueNumber++;
						break;
					}
					else {break;}
				}
			}
		}
		
		//1 cult and 1 player
		if (cultNumber == 1 && (blueNumber == 1 || blueNumber == 0))
		{
			System.out.println("There is 1 cult and 1 or 0 blues left alive.");
			return "Cult";
		}
		if (cultNumber == 0 && blueNumber >= 1)
		{
			System.out.println("There is 0 cult and 1 or more blue left alive");
			return "Blue";
		}
		if (cultNumber == 0 && blueNumber == 0)
		{
			System.out.println("Draw? Maybe..");
			return "Draw";
		}
		return "No";
	}
}
