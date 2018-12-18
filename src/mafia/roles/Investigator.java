package mafia.roles;

import java.util.ArrayList;
import java.util.Arrays;

import mafia.AbilityActive;
import mafia.AbilityPassive;
import mafia.Role;
import mafia.Team;

public class Investigator extends Role
{
    private static AbilityPassive passive1 = new AbilityPassive("nightDeathImmunity");
    private static ArrayList<AbilityPassive> passives = new ArrayList<AbilityPassive>(Arrays.asList(passive1));
    
    private static AbilityActive active1 = new AbilityActive("Investigate", 3, 2);
    private static ArrayList<AbilityActive> actives = new ArrayList<AbilityActive>(Arrays.asList(active1));
    

    public Investigator()
    {
        super("Investigator", passives, actives, Team.BLUE);
    }    

}
