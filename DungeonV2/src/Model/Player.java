package Model;

import Util.*;

import java.util.*;

public class Player {
	private static final int STARTING_HP = 200;
    private static final int CHANCE_TO_ESCAPE = 20;
    private static final int CRITICAL_HIT_PRCT_CHANCE = 20;
    private Room currentLocation;
    private Room previousLocation;
    private int hp;
    private List<Equipment> equipment;
    
    public Player() {
        this.hp = 200;
        this.equipment = new ArrayList<Equipment>();
    }
    
    public Room getCurrentLocation() {
        return this.currentLocation;
    }
    
    public void setCurrentLocation(final Room currentLocation) {
        this.previousLocation = this.currentLocation;
        this.currentLocation = currentLocation;
    }
    
    private void hit(final int attack) {
        this.hp -= attack;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public int addHp() {
    	this.hp = this.hp + 50;
    	if(this.hp > 200) {
    		this.hp = 200;
    	}
    	return this.hp;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }

    private boolean verifDoor(final Door door) {
        if (!door.isLocked()) {
            return true;
        }
        Console.affiche("La porte est fermée. Vous ne pourrez pas passer par là sans clé.");
        if (this.haveAKey()) {
            Console.affiche("Vous utilisez la clé sur la porte.");
            Console.affiche("La porte est mainetant ouverte");
            this.removeKeyFromEquipment();
            door.setLocked(false);
            return true;
        }
        return false;
    }
    
    public void goNorth() {
        final Door door = this.currentLocation.getNorthDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getNorthDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("Vous avez décider de passer par la porte NORD.");
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
                Console.afficheln("Vous avez décider de passer par la porte SUD.");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void goWest() {
        final Door door = this.currentLocation.getWestDoor();
        if (this.verifDoor(door)) {
            try {
                this.setCurrentLocation(this.currentLocation.getWestDoor().getOppositeRoom(this.currentLocation));
                Console.afficheln("Vous avez décider de passer par la porte OUEST.");;
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
                Console.afficheln("Vous avez décider de passer par la porte EST.");
            }
            catch (DungeonBuildException e) {
                e.printStackTrace();
            }
        }
    }


    public void fight(final Monster monster, boolean playerAttackFirst) {
        Console.affiche("Vous commencer le combat contre le monstre.");
        Console.affiche("Vous avez " + this.getHp() + " HP.");
        Console.affiche("Le Monstre à " + monster.getHp() + " HP.");
        final Weapon weapon = this.bestWeaponAttack();
        Console.affiche("Vous utilisez votre arme {" + weapon + "} avec une puissance de " + weapon.getAttackPoints() + " points d'attaque.\n");
        do {
            if (playerAttackFirst) {
                int attack = weapon.getAttackPoints();
                if (Interaction.randomPrct() < 20) {
                    Console.affiche("Coup Critique !");
                    attack *= 2;
                }
                Console.affiche("Vous lui infligez " + attack + " points d'attaque");
                monster.hit(attack);
                if (monster.getHp() > 0) {
                    Console.affiche("Le Monstre : " + monster.getHp() + " HP.\n");
                }
                else {
                    Console.affiche("Le Monstre est mort !");
                    this.addHp();
                    Console.affiche("\nVous récupérez 50 HP pour avoir vaincu le monstre.");
                    Console.affiche("Après ce rude Combat vous avez " + this.getHp() + " HP.");
                    if (monster.getLoot() != null) {
                        Console.affiche("Le Monstre à looter {" + monster.getLoot() + "}.");
                        this.addEquipement(monster.getLoot());
                    }
                }
            }
            else {
                playerAttackFirst = true;
            }
            if (monster.isAlive()) {
                int attack = monster.getAttack();
                if (Interaction.randomPrct() < 20) {
                    Console.affiche("Coup Critique !");
                    attack *= 2;
                }
                Console.affiche("Le Monstre vous a infligé " + attack + " points d'attaque.");
                this.hit(attack);
                if (this.getHp() > 0) {
                    Console.affiche("Vous : " + this.getHp() + " HP.\n");
                }
                else {
                    Console.affiche("\nVous êtes mort, comme une merde !");
                }
            }
        }
        while (this.isAlive() && monster.isAlive());
        Console.afficheln("");
    }

    public void escape() {
        Console.affiche("Vous essayez de fuir face au Monstre");
        Interaction.latency(2);
        if (Interaction.randomPrct() <= CHANCE_TO_ESCAPE) {
            Console.affiche("Vous avez fuit la queue entre les jambes!\nVous retournez dans la salle précendente.");
            this.currentLocation = this.previousLocation;
        }
        else {
            Console.afficheln("Vous êtes vraiment nul pour fuir !\nLe Monstre vous attaque par surprise.");
            this.fight((Monster)this.getCurrentLocation().getElementInRoom(), false);
        }
    }
    
    public void addEquipement(final Equipment e) {
        if (!this.equipment.contains(e)) {
            this.equipment.add(e);
        }
    }
    
    private Weapon bestWeaponAttack() {
        int best = 15;
        Weapon res = new Weapon("Vos Poings !", 15);
        for (final Equipment e : this.equipment) {
            if (e instanceof Weapon && best < ((Weapon)e).getAttackPoints()) {
                best = ((Weapon)e).getAttackPoints();
                res = (Weapon)e;
            }
        }
        return res;
    }
    
    private boolean haveAKey() {
        for (final Equipment e : this.equipment) {
            if (e instanceof Key) {
                return true;
            }
        }
        return false;
    }
    
    public void openChest(final Chest chest) {
        if (chest.isLocked()) {
            if (!this.haveAKey()) {
                Console.afficheln("Le Coffre semble fermé. Vous avez besoin d'une clé.");
                return;
            }
            Console.afficheln("Vous utilisez une clé sur le coffre.");
            this.removeKeyFromEquipment();
            chest.setLocked(false);
        }
        Console.afficheln("Vous ouvrez le coffre. " + chest);
        if (chest.getLoot() == null) {
            Console.afficheln("Dommage! c'est déjà vide !");
        }
        else {
            Console.afficheln("Vous trouvez {" + chest.getLoot() + "}.");
            this.addEquipement(chest.getLoot());
            chest.setLoot((Equipment)null);
        }
    }
    
    private void removeKeyFromEquipment() {
        Equipment keyToRemove = null;
        for (final Equipment e : this.equipment) {
            if (e instanceof Key) {
                keyToRemove = e;
                break;
            }
        }
        if (keyToRemove != null) {
            this.equipment.remove(keyToRemove);
        }
    }
    
    public void free(final Princess princess) {
        princess.setFree(true);
        Console.afficheln("Vous libérez la Princesse");
        Console.afficheln("Vous êtes maintenant réuni et vous vous précipitez vers le lit...");
    }
}
