package mafia;

import java.util.*;
import java.awt.*;
import javax.swing.JFrame;

import mafia.Team;
import mafia.actions.Action;
import mafia.actions.Heal;
import mafia.actions.Investigate;
import mafia.actions.Kill;
import mafia.roles.Killer;
import mafia.roles.blue.Investigator;
import mafia.roles.blue.RandomBlue;

public class Game
{

    private int numCharacters;
    private int cultCharacter;
    private int investigatorCharacter;
    private static String[] NAMES = { "Danny", "Jack", "Kirito", "Asuna", "Edward", "Alphonse", "Saber", "Lancer", "Archer",
            "Rider", "Caster", "Beserker", "Assassin", "Avenger", "placeholdername", "placeholdername",
            "placeholdername", "placeholdername", "placeholdername", "placeholdername", "placeholdername",
            "placeholdername", "placeholdername", };
    private Player[] players;
    
    public int getNumCharacters() {return players.length;}
    public int getCultCharacter() {return cultCharacter;}
    public int getInvestigatorCharacter() {return investigatorCharacter;}
    
    public int getPlayerNumber() {return teams.size();} //doesn't actually work, needs to be changed to a loop to get the ints of each team.
    public int getBlueNumber() {return teams.get(Team.BLUE);}
    public int getCultNumber() {return teams.get(Team.CULT);}
    
    private static EnumMap<Team, Integer> teams = new EnumMap<>(Team.class);
    
    public Player[] getPlayers() {return players;}
    public void setPlayers(Player[] players) {this.players = players;}
    
    public Game(Player[] players) 
    {
        this.players = players; 
        this.numCharacters = players.length;
    }
    
    public static void incrementTeam(Team team) 
    {
        if (teams.containsValue(team)) {teams.replace(team, teams.get(team) + 1);} 
        else {teams.put(team, 1);}
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Player[] players = new Player[2];
        //function that sets everyone to their respective roles.
        //game.setup();
        players[0] = new Player("game-Danny", PlayerState.ALIVE, Health.HEALTHY, new Killer()); 
        players[1]= new Player("game-Jack", PlayerState.ALIVE, Health.HEALTHY, new Investigator());
        //players[2] = new Player("game-Saber", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
        //players[3] = new Player("game-Archer", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
        
        Game game = new Game(players);

        game.gameLoop();
    }
    
    public void setup()
    {
        // Method to setup a game, create characters and then assign them roles
        
        // Assign a random person with the cult.
        int cultCharacter = ((int) (Math.random() * getNumCharacters()));
        players[cultCharacter] = new Player("game-Cult", PlayerState.ALIVE, Health.HEALTHY, new Killer());
        
        int investCharacter;
        do
        {
            investCharacter = ((int) (Math.random() * getNumCharacters()));
        } while (getInvestigatorCharacter() == getCultCharacter()); // does not override the cult member with the investigator; creates new array for players.
        players[investCharacter] = new Player("game-Investigator", PlayerState.ALIVE, Health.HEALTHY, new Investigator());
        
        for (int i = 0; i < getNumCharacters(); i++)
        {
            //players[i] = new Player(NAMES[i], PlayerState.ALIVE, Health.HEALTHY, false);
            if (i == cultCharacter || i == investCharacter) {}
            else players[i] = new Player("game-Blue", PlayerState.ALIVE, Health.HEALTHY, new RandomBlue());
            // displayCharacterData(i);
        }
    }
    
    public void gameLoop() throws InterruptedException
    {
        // Game loop
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        String action = "";
        int recipient;
        ArrayList<Action> actions = new ArrayList<Action>();
        
        while (!end())
        {
            // Night Start
            for (int i = 0; i < players.length; i++)
            {
                // displayCharactersAdmin(); //adminfunction
                displayCharacters(); // playerfunction
                if ((players[i].getPlayerstate() == PlayerState.DEAD))
                {
                    System.out.println("\nPlayer " + i + " is dead and cannot perform any actions");
                } else
                {
                    do
                    {
                        String string = "";
                        if (players[i].getRole().getName().substring(0, 1).matches("[aeiouAEIOU]")) {string = " an";} else {string = " a";} //bit of English
                        System.out.println("Player: " + i + ", you are" + string + ": " + players[i].getRole().getName());
                        
                        System.out.print("Player: " + i + ". Your passive abilities are: ");
                        System.out.print(players[i].getRole().getPassives());
                        
                        System.out.print("\nPlayer: " + i + ". Your active abilities are: ");
                        System.out.print(players[i].getRole().getActives());
                        System.out.println();
                        
                        //check's the player has the ability && the player is targeting a non-dead and not themselves
                        do
                        {
                            System.out.println("Enter the ability you'd like to use followed by the target player.");
                            action = scanner.next();
                            recipient = scanner.nextInt();
                            flag = true;
                        } while (!(players[i].getRole().validate(players[i], players[recipient], action)));
                        
                        //performs action
                        switch (action)
                            {
                            case "Kill":
                            {
                                Action kill = new Kill(players[i], players[recipient]);
                                if (kill.actionPlayer() != null) {actions.add(kill);}
                                break;
                            }
                            case "Investigate" : case "Inv" :
                            {
                                action = "Investigate";
                                Action investigate = new Investigate(players[i], players[recipient]);
                                if (investigate.actionPlayer() != null) {actions.add(investigate);}
                                break;
                            }
                            case "Heal":
                            {
                                Action heal = new Heal(players[i], players[recipient]);
                                if (heal.actionPlayer() != null) {actions.add(heal);}
                                break;
                            }
                            default: {
                                break;
                            }
                            }
                        if (!((players[i].getRole().haveActives(action))))
                        {
                            System.out.println("That is not a valid ability. Please try again.");
                        }
                    } while (!(players[i].getRole().haveActives(action)));
                }
            }
            // Night End
            
            System.out.println();
            for (int i = 0; i < actions.size(); i++)
            {
                System.out.println(actions.get(i));
                //sort the actions into higher precedence first
                actions.get(i).execute();
            }
            System.out.println();
        }

        getWinners();
        
        /*
        switch (gameEnd())
            {
            case "Blue":
            {
                System.out.println("Blue team won! Congratulations");
                break;
            }
            case "Cult":
            {
                System.out.println("Cult won!");
                break;
            }
            case "Draw":
            {
                System.out.println("Draw...");
                break;
            }
            default:
            {
                System.out.println("gameEnd somehow switched to default");
            }
            }
        */
        Thread.sleep(1000);
        scanner.close();
    }

    
    public boolean end()
    {
        for (int i = 0; i < players.length; i++)
        {
            //if a single player's victory() returns false the continue the game (return false)
            if (players[i].getPlayerstate() == PlayerState.ALIVE && (players[i].getRole().victory(players) == false)) {return false;}
        }
        return true;
    }
    
    public void getWinners() //should probably return a list of winners for GUI.
    {
        for (int i = 0; i < players.length; i++)
        {
            //if all players's victory() returns true then end the game.
            if (players[i].getRole().isWon()) {System.out.println("Player: " + players[i].getName() + ". Role: " + players[i].getRole() + " is a winner.");}
            else {System.out.println("Player: " + players[i].getName() + ". Role: " + players[i].getRole() + " is a loser.");}
        }
    }
    
    private String gameEnd() // test if victory condition has been met. Upgrade by getting win conditions from Teams.java
    {

        //If all ALIVE players pass their victory condition.
        int cultNumber = 0, blueNumber = 0;
        for (int i = 0; i < players.length; i++)
        {
            // Test how many players there are alive
            switch (players[i].getRole().getTeam())
                {
                case CULT:
                {
                    if (players[i].getPlayerstate() == PlayerState.ALIVE)
                    {
                        // System.out.println("+1 Cult");
                        cultNumber++;
                        break;
                    } else
                    {
                        break;
                    }
                }
                case BLUE:
                {
                    if (players[i].getPlayerstate() == PlayerState.ALIVE)
                    {
                        // System.out.println("+1 Blue");
                        blueNumber++;
                        break;
                    } else
                    {
                        break;
                    }
                }
                }
        }

        // 1 cult and 1 player
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
    
    public void displayCharacterData(int i) // Administrative function
    {
        System.out.println("Character " + i + " is " + players[i].getRole().getName());
        System.out.println("Character " + i + " is " + players[i].getRole());
        System.out.println("Player Name: " + players[i].getName() + ". Player State: " + players[i].getPlayerstate());
    }

    public void displayCharactersAdmin() // Admin function
    {
        for (int i = 0; i < players.length; i++)
        {
            System.out.print("Character " + i + " is: " + players[i].getRole().getName());
            System.out.println(" on " + players[i].getRole());
            // System.out.println("Name: " + players[i].getName() + ". Player State: " +
            // players[i].getPlayerstate());
        }
        System.out.println();
    }

    public void displayCharacters() // Player function
    {
        for (int i = 0; i < players.length; i++)
        {
            System.out.print("Player " + i + ".");
            System.out.println(" Name: " + players[i].getName() + ". Player State: " + players[i].getPlayerstate());
        }
        System.out.println();
    }

}
