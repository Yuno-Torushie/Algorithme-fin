package model;

import util.*;
import java.util.*;

public class Player
{
    private static final int STARTING_HP = 70;
    private static final int CHANCE_PRCT_TO_FLEE = 20;
    private static final int CRITICAL_HIT_PRCT_CHANCE = 20;
    private Room currentLocation;
    private Room previousLocation;
    private int hp;
    private List<Equipment> equipment;
    
    public Player() {
        this.hp = 70;
        this.equipment = new ArrayList<Equipment>();
    }
    
    public Room getCurrentLocation() {
        return this.currentLocation;
    }
    
    public void setCurrentLocation(final Room currentLocation) {
        this.previousLocation = this.currentLocation;
        this.currentLocation = currentLocation;
    }
    
    public int getHp() {
        return this.hp;
    }
    //TODO commentaire
    private boolean verifDoor(final Door door) {
        if (!door.isLocked()) {
            return true;
        }
        Console.affiche("The door is closed. You shall not pass!");
        if (this.haveAKey()) {
            Console.affiche("Hopefully you have a key!");
            Console.affiche("Now it's open");
            Console.affiche("But the key is broken and cannot be used again...");
            this.removeKeyFromEquipment();
            door.setLocked(false);
            return true;
        }
        return false;
    }
   
    public void goWest() {
        final Door door = this.currentLocation.getWestDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getWestDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("You pass the west door");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void goEast() {
        final Door door = this.currentLocation.getEastDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getEastDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("You pass the east door");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void goNorth() {
        final Door door = this.currentLocation.getNorthDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getNorthDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("You pass the north door");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void goSouth() {
        final Door door = this.currentLocation.getSouthDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getSouthDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("You pass the south door");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }
    //TODO commentaire
    public void fight(final Foe enemy, boolean playerAttackFirst) {
        Console.affiche("The fight is engaged");
        Console.affiche("You have " + this.getHp() + " HP and your enemy has " + enemy.getHp() + " HP.");
        final Weapon weapon = this.bestWeaponAttack();
        Console.affiche("You will use your best weapon [" + weapon + " / " + weapon.getAttackPoints() + " attack pts]");
        do {
            if (playerAttackFirst) {
                Console.affiche("Your attack turn...");
                int attack = weapon.getAttackPoints();
                if (Interaction.randomPrct() < 20) {
                    Console.affiche("Critical hit!");
                    attack *= 2;
                }
                Console.affiche("You give a " + attack + " points attack");
                enemy.hit(attack);
                if (enemy.getHp() > 0) {
                    Console.affiche("Your enemy has only " + enemy.getHp() + " HP remaining");
                }
                else {
                    Console.affiche("The enemy is dead !");
                    if (enemy.getLoot() != null) {
                        Console.affiche("The enemy looted a " + enemy.getLoot());
                        this.addEquipement(enemy.getLoot());
                    }
                }
            }
            else {
                playerAttackFirst = true;
            }
            if (enemy.isAlive()) {
                Console.affiche("Enemy turn...");
                int attack = 5;
                if (Interaction.randomPrct() < 20) {
                    Console.affiche("Critical hit!");
                    attack *= 2;
                }
                Console.affiche("The enemy gives you a " + attack + " points attack");
                this.hit(attack);
                if (this.getHp() > 0) {
                    Console.affiche("You now has " + this.getHp() + " HP remaining");
                }
                else {
                    Console.affiche("You're dead !");
                }
            }
        } while (this.isAlive() && enemy.isAlive());
        Console.afficheln("");
    }
    
    private void hit(final int attack) {
        this.hp -= attack;
    }
    
    private Weapon bestWeaponAttack() {
        int best = 5;
        Weapon res = new Weapon("your own fists", 5);
        for (final Equipment e : this.equipment) {
            if (e instanceof Weapon && best < ((Weapon)e).getAttackPoints()) {
                best = ((Weapon)e).getAttackPoints();
                res = (Weapon)e;
            }
        }
        return res;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }
    //TODO commentaire
    public void fleeTry() {
        Console.affiche("Attempt to flee silently before being seen by the foe...");
        Interaction.pause(2);
        if (Interaction.randomPrct() <= 20) {
            Console.affiche("success !\nYou go back");
            this.currentLocation = this.previousLocation;
        }
        else {
            Console.afficheln("missed !\nThe foe see you and attack first.");
            this.fight((Foe)this.getCurrentLocation().getElementInRoom(), false);
        }
    }
    
    public void addEquipement(final Equipment e) {
        if (!this.equipment.contains(e)) {
            this.equipment.add(e);
        }
    }
    //TODO commentaire
    public void openSafe(final Safe safe) {
        if (safe.isLocked()) {
            if (!this.haveAKey()) {
                Console.afficheln("The safe is locked... you need a key");
                return;
            }
            Console.afficheln("You use one of your keys to unlock the safe");
            Console.affiche("but the key remains stuck in the safe...");
            this.removeKeyFromEquipment();
            safe.setLocked(false);
        }
        Console.afficheln("You open " + safe);
        if (safe.getLoot() == null) {
            Console.afficheln("Damned! It's empty !");
        }
        else {
            Console.afficheln("You find " + safe.getLoot());
            this.addEquipement(safe.getLoot());
            safe.setLoot((Equipment)null);
        }
    }
    
    private void removeKeyFromEquipment() {
        Equipment keyToRemove = null;
        for (final Equipment e : this.equipment) {
            if (e instanceof SafeKey) {
                keyToRemove = e;
                break;
            }
        }
        if (keyToRemove != null) {
            this.equipment.remove(keyToRemove);
        }
    }
    
    private boolean haveAKey() {
        for (final Equipment e : this.equipment) {
            if (e instanceof SafeKey) {
                return true;
            }
        }
        return false;
    }
    //TODO commentaire
    public void free(final Princess princess) {
        princess.setFree(true);
        Console.afficheln("You free the princess");
        Console.afficheln("You're happy to have succeded in freeing her but you understand all the pain she probably suffered in this bedroom...");
    }
}