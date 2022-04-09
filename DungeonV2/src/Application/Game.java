package Application;

import Util.*;
import Model.*;

public class Game
{
    private Dungeon theDungeon;
    private Player thePlayer;
    private Screen screen;
    private Model model;
    
    public Game(Model theRootModel, Screen theRootView) {
        model = theRootModel;
        screen = theRootView;
      }
    
    private void init() {
        this.theDungeon = new Dungeon();
        this.thePlayer = new Player();
    }
    
    private void start() {
    	screen.solution();
    	screen.welcomeMessage();
    	Room currentRoom = this.theDungeon.getStartingRoom();
        this.thePlayer.setCurrentLocation(currentRoom);
        while (!this.endOfTheGame()) {
            this.describeCurrentRoom();
            this.doAnAction(this.proposeAvailableActions());
        }
        if (this.thePlayer.isAlive()) {
        	screen.goodEnding();
        }
        else {
        	screen.badEnding();
        }
    }
    
    public void launch() {
        this.init();
        this.start();
    }
    
    private void doAnAction(final char action) {
        switch (Character.toUpperCase(action)) {
	        case 'N': {
	            this.thePlayer.goNorth();
	            break;
	        }
	        case 'S': {
	            this.thePlayer.goSouth();
            	break;
        	}    
        	case 'O': {
                this.thePlayer.goWest();
                break;
            }
            case 'E': {
                this.thePlayer.goEast();
                break;
            }
            case 'F': {
                this.thePlayer.escape();
                break;
            }
            case 'C': {
                this.thePlayer.fight((Monster)this.thePlayer.getCurrentLocation().getElementInRoom(), true);
                break;
            }
            case 'P': {
                this.thePlayer.openChest((Chest)this.thePlayer.getCurrentLocation().getElementInRoom());
                break;
            }
            case 'L': {
                this.thePlayer.free((Princess)this.thePlayer.getCurrentLocation().getElementInRoom());
                break;
            }
        }
    }    
    
    private char proposeAvailableActions() {
        Interaction.resetKeys();
        Console.info("");
        final RoomWithSomething elem = this.thePlayer.getCurrentLocation().getElementInRoom();
        if (elem != null && elem instanceof Monster && ((Monster)elem).isAlive()) {
            screen.fight();
        	Interaction.acceptKey('F');
            Interaction.acceptKey('C');
        }
        else {
            if (elem != null && elem instanceof Chest) {
            	screen.openChest();
                Interaction.acceptKey('P');
            }
            else if (elem != null && elem instanceof Princess) {
            	screen.free();
                Interaction.acceptKey('L');
            }
            if (this.thePlayer.getCurrentLocation().getNorthDoor() != null) {
            	screen.goNorth();
                Interaction.acceptKey('N');
            }
            if (this.thePlayer.getCurrentLocation().getSouthDoor() != null) {
            	screen.goSouth();
                Interaction.acceptKey('S');
            }
            if (this.thePlayer.getCurrentLocation().getWestDoor() != null) {
            	screen.goWest();
                Interaction.acceptKey('O');
            }
            if (this.thePlayer.getCurrentLocation().getEastDoor() != null) {
            	screen.goEast();
                Interaction.acceptKey('E');
            }
        }
        screen.choix();
        return Interaction.readAction();
        
    }
    
    private void describeCurrentRoom() {
        this.thePlayer.getCurrentLocation().describe();
    }
    
    private boolean endOfTheGame() {
        return this.theDungeon.getYuno().isFree() || !this.thePlayer.isAlive();
    }

}