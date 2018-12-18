package mafia.roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Role;
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

}
