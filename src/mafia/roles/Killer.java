package mafia.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Player;
import mafia.PlayerState;
import mafia.Team;

public class Killer extends Role
{
    private static AbilityPassive passive1 = new AbilityPassive("");
    private static ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>(Arrays.asList(passive1));
    
    private static AbilityActive active1 = new AbilityActive("Kill", -1, 3);
    private static ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>(Arrays.asList(active1));
    

    public Killer()
    {
        super("Killer", passives, actives, Team.CULT);
    }
    
    public boolean victory(Player[] players)
    {
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getPlayerstate() == PlayerState.ALIVE && (players[i].getRole().getTeam() == Team.BLUE)) {return false;} //if there are no blues left.
        }
        this.won = true;
        return true;
    }
}
