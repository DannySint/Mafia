package mafia.roles.blue;

import java.util.ArrayList;
import java.util.Arrays;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Player;
import mafia.Team;
import mafia.roles.Role;

public abstract class Blue extends Role
{
    private static AbilityPassive passive1 = new AbilityPassive("");
    private static ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>(Arrays.asList(passive1));
    
    private static AbilityActive active1 = new AbilityActive("0", -1, 1);
    private static ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>(Arrays.asList(active1));
    

    public Blue(String name, ArrayList<AbilityPassive> passives, ArrayList<AbilityActive> actives)
    {
        super(name, passives, actives, Team.BLUE);
    }
    
    public boolean victory(Player[] players) //if there is at least one CULT alive. 
    {
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getRole().getTeam() == Team.CULT) {return false;}
        }
        this.won = true;
        return true;
    }

}
