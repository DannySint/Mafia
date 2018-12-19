package mafia;

public class AbilityPassive
{

    private String name;

    public AbilityPassive(String name) 
    {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString()
    {
        return name;
    }
}
