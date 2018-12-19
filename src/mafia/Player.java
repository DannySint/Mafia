package mafia;

import java.util.EnumMap;

import mafia.roles.Role;

public class Player
    {
        // instance attributes (Role, Abilities)
        private String name;
        private PlayerState playerState;
        private Health health;
        private Role role;

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
                Game.incrementTeam(role.getTeam());
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
        
        /*
        public void setRoleCult() {role.setRoleCult();}
        public void setRoleBlue() {role.setRoleBlue
        public void setRoleInvestigator() {role.setRoleInvestigator();}
        */
    }