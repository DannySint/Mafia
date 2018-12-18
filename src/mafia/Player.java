package mafia;

import java.util.EnumMap;

public class Player
    {
        // instance attributes (Role, Abilities)
        private String name;
        private PlayerState playerState;
        private Health health;
        private Role role;
        private EnumMap<Team, Integer> teams = new EnumMap<>(Team.class);

        /**
         * Characters constructor method
         * @param name = String - name of player
         * @param PlayerState = enum - Dead or Alive?
         * @param Health = enum - Healthy or Poisoned?
         * @param role = Role - Team of player.
         */
        public Player(String name, PlayerState playerState, Health health, Role role)
            {
                this.name = name;
                this.playerState = playerState;
                this.health = health;
                this.role = role;
                if (teams.containsValue(role.getTeam())) {teams.replace(role.getTeam(), teams.get(role.getTeam()) + 1);} 
                else {teams.put(role.getTeam(), 1);}
            }

        // Getter Methods
        public String getName() {return name;}
        public PlayerState getPlayerstate() {return playerState;}
        public Health getHealth() {return health;}
        public Role getRole() {return role;}
        // Setter Methods
        public void setName(String name) {this.name = name;}
        public void setPlayerState(PlayerState playerState) {this.playerState = playerState;}
        public void setHealth(Health health) {this.health = health;}
        
        public int getPlayerNumber() {return teams.size();}
        public int getBlueNumber() {return teams.get(Team.BLUE);}
        public int getCultNumber() {return teams.get(Team.CULT);}
        
        /*
        public void setRoleCult() {role.setRoleCult();}
        public void setRoleBlue() {role.setRoleBlue
        public void setRoleInvestigator() {role.setRoleInvestigator();}
        */
    }