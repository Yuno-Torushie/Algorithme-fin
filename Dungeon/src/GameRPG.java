import util.*;
import model.*;

public class GameRPG
{
    private Dungeon theDungeon;
    private Player thePlayer;
    
    public void launch() {
        this.init();
        this.start();
    }
    
    private void start() {
        Console.affiche("Welcome to the dungeon !");
        Console.affiche("Free the princess captured by POO-the-terrible.");
        final Room currentRoom = this.theDungeon.getStartingRoom();
        this.thePlayer.setCurrentLocation(currentRoom);
        while (!this.endOfTheGame()) {
            this.describeCurrentRoom();
            this.doAnAction(this.proposeAvailableActions());
        }
        if (this.thePlayer.isAlive()) {
            Console.afficheln("Congratulations ! You saved the princess");
            Console.afficheln("You are my HERO !!");
        }
        else {
            Console.afficheln("Busted ! You missed your mission.");
            Console.afficheln("The princess will be trapped forever by the POO vilain");
        }
    }
    
    private void doAnAction(final char action) {
        switch (Character.toUpperCase(action)) {
            case 'W': {
                this.thePlayer.goWest();
                break;
            }
            case 'E': {
                this.thePlayer.goEast();
                break;
            }
            case 'N': {
                this.thePlayer.goNorth();
                break;
            }
            case 'S': {
                this.thePlayer.goSouth();
                break;
            }
            case 'L': {
                this.thePlayer.fleeTry();
                break;
            }
            case 'F': {
                this.thePlayer.fight((Foe)this.thePlayer.getCurrentLocation().getElementInRoom(), true);
                break;
            }
            case 'P': {
                this.thePlayer.openSafe((Safe)this.thePlayer.getCurrentLocation().getElementInRoom());
                break;
            }
            case 'T': {
                this.thePlayer.free((Princess)this.thePlayer.getCurrentLocation().getElementInRoom());
                break;
            }
        }
    }
    
    private void describeCurrentRoom() {
        this.thePlayer.getCurrentLocation().describe();
    }
    
    private boolean endOfTheGame() {
        return this.theDungeon.getYuno().isFree() || !this.thePlayer.isAlive();
    }
    
    private char proposeAvailableActions() {
        Interaction.resetKeys();
        Console.info("");
        final RoomElement elem = this.thePlayer.getCurrentLocation().getElementInRoom();
        if (elem != null && elem instanceof Foe && ((Foe)elem).isAlive()) {
            Console.info("\nThere is a foe");
            Console.info("(L) try to avoid the fight and go back to previous room ? (20% chance)");
            Console.info("(F) direct attack with a first hit ?");
            Interaction.acceptKey('L');
            Interaction.acceptKey('F');
        }
        else {
            if (elem != null && elem instanceof Safe) {
                Console.info("(P) open the safe");
                Interaction.acceptKey('P');
            }
            else if (elem != null && elem instanceof Princess) {
                Console.info("(T) Free the princess");
                Interaction.acceptKey('T');
            }
            if (this.thePlayer.getCurrentLocation().getWestDoor() != null) {
                Console.info("(W) to go West");
                Interaction.acceptKey('W');
            }
            if (this.thePlayer.getCurrentLocation().getEastDoor() != null) {
                Console.info("(E) to go East");
                Interaction.acceptKey('E');
            }
            if (this.thePlayer.getCurrentLocation().getNorthDoor() != null) {
                Console.info("(N) to go North");
                Interaction.acceptKey('N');
            }
            if (this.thePlayer.getCurrentLocation().getSouthDoor() != null) {
                Console.info("(S) to go South");
                Interaction.acceptKey('S');
            }
        }
        Console.info("\nYour choice ?");
        return Interaction.readAction();
    }
    
    private void init() {
        this.theDungeon = new Dungeon();
        this.thePlayer = new Player();
    }
}