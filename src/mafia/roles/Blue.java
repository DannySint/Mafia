package mafia.roles;

import java.util.ArrayList;
import java.util.Arrays;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Role;
import mafia.Team;

public class Blue extends Role
{
    private static AbilityPassive passive1 = new AbilityPassive("");
    private static ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>(Arrays.asList(passive1));
    
    private static AbilityActive active1 = new AbilityActive("0", -1, 1);
    private static ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>(Arrays.asList(active1));
    

    public Blue()
    {
        super("Blue", passives, actives, Team.BLUE);
    }    

}
