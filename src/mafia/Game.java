package mafia;

import java.util.*;

public class Game {

	public static void displayCharacterData(Characters[] players, int i) //Administrative function
	{
		System.out.println("Character " + i + " is " + players[i].getRole());
		System.out.println("Character Name: " + players[i].getName() +  " Player State: " + players[i].getPlayerstate());
	}
	public static void displayCharacters(Characters[] players) //Player function
	{
		for (int i=0;i<players.length;i++)
		{
			System.out.print("Character " + i + " is " + players[i].getRole());
			//System.out.print("Character " + i);
			System.out.println(" Name: " + players[i].getName() +  ". Player State: " + players[i].getPlayerstate());
		}
	}

	public static void main(String[] args) throws InterruptedException 
	{
		//Method to create characters and assign them roles
		int numCharacters = 6;
		int cultCount = 0;
		int cultCharacter = 0;
		int investigatorCharacter = 0;
		
		cultCharacter = (int)(Math.random() * numCharacters);
		do
		{
			investigatorCharacter = (int)(Math.random() * numCharacters);
		}
		while (investigatorCharacter == cultCharacter);
		Characters[] players = new Characters[numCharacters];
		for (int i = 0; i<numCharacters;i++)
		{
		    players[i] = new Characters("Danny",PlayerState.ALIVE,false);
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
				displayCharacters(players);
				//displayCharactersData(players, i);
				if ((players[i].getPlayerstate() == PlayerState.DEAD))
				{
					System.out.println("Player " + i + " is dead and cannot perform any actions");
				}
				else 
				{
					do 
					{
						System.out.println("\nPlayer: " + i + ". Your active abilities are: " + players[i].getRole().getAbility().getActive());
						System.out.println("Which ability would you like to use?");
						input = scanner.next();
						switch(input)
						{
						case "Kill" : //currently immediately kills. Needs to kill at end of night.
							{
								if (players[i].getRole().getAbility().getActive() == "Kill")
								{
									do 
									{
										System.out.println("Which player would you like to kill?");
										inputInt = scanner.nextInt();
										if (i == inputInt) {System.out.println("You cannot kill yourself. Please try again.");}
										if (players[inputInt].getPlayerstate() == PlayerState.DEAD) 
										{
											System.out.println("You cannot kill a dead person");
										}
									} while ((players[inputInt].getPlayerstate() == PlayerState.DEAD) || i == inputInt);
									if (players[inputInt].getPlayerstate() == PlayerState.DEAD) 
										{}
									else 
										{players[inputInt].setPlayerState(PlayerState.DEAD);}
								}
								else {System.out.println("You do not have that ability");}
							break;
							}
							
						case "Investigate" : case "Inv" : 
						{
							if (players[i].getRole().getAbility().getActive() == "Investigate")
							{
								input = "Investigate";
								do
								{
									System.out.println("Which player would you like to investigate?");
									inputInt = scanner.nextInt();
									if (i == inputInt) {System.out.println("You cannot investigate yourself. Please try again.");}
									if (players[inputInt].getPlayerstate() == PlayerState.DEAD) 
									{
										System.out.println("You cannot investigate a dead person");
									}
								} while ((players[inputInt].getPlayerstate() == PlayerState.DEAD) || i == inputInt);
								//Code for Investigate
								if (players[inputInt].getRole().getTeam().getTeam() == ETeam.CULT) {System.out.println("Player " + inputInt + " is a member of the Cult!");}
								else {System.out.println("Player " + inputInt + " is not a member of the Cult.");}
							}
							else {System.out.println("You do not have that ability");}
						break;
						}
						default :
							{break;}
						}
						//System.out.println("Active: " + players[i].getRole().getAbility().getActive() + " input: " + input);
						if (!(input.equals(players[i].getRole().getAbility().getActive()))) {System.out.println("That is not a valid ability. Please try again.");}
					} while (!(input.equals(players[i].getRole().getAbility().getActive())));
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
