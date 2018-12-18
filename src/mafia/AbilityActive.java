package mafia;

public class AbilityActive
{

    private String name;
    private int uses;
    private int priority;

    public AbilityActive(String name, int uses, int priority) 
    {
        this.name = name;
        this.uses = uses;
        this.priority = priority;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getUses() {return uses;}
    public void setUses(int uses) {this.uses = uses;}
    public int getPriority() {return priority;}
    public void setPriority(int priority) {this.priority = priority;}

    @Override
    public String toString()
    {
        return "AbilityActive [name=" + name + ", uses=" + uses + ", priority=" + priority + "]";
    }
}
