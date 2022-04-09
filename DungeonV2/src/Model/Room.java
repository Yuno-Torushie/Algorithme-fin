package Model;

import Util.*;

public class Room {
	private String description;
    private Door eastDoor;
    private Door westDoor;
    private Door northDoor;
    private Door southDoor;
    private RoomWithSomething elementInRoom;
    
    public Room(final String description) {
        this.description = description;
    }
    
    public void describe() {
    	Console.affiche("Vous êtes dans " + this.description);
        if (this.northDoor != null) {
            Console.affiche("Il y a une porte dans la direction NORD.");
            if (this.northDoor.isLocked()) {
                Console.affiche("mais il semble qu'elle soit fermée.");
            }
        }
        if (this.southDoor != null) {
            Console.affiche("Il y a une porte dans la direction SUD.");
            if (this.southDoor.isLocked()) {
                Console.affiche("mais il semble qu'elle soit fermée.");
            }
        }
    	if (this.westDoor != null) {
            Console.affiche("Il y a une porte dans la direction OUEST.");
            if (this.westDoor.isLocked()) {
                Console.affiche("mais il semble qu'elle soit fermée.");
            }
        }
        if (this.eastDoor != null) {
            Console.affiche("Il y a une porte dans la direction EST.");
            if (this.eastDoor.isLocked()) {
                Console.affiche("mais il semble qu'elle soit fermée.");
            }
        }
        if (this.getElementInRoom() != null) {
            Console.affiche("\nIl y a " + this.getElementInRoom().toString());
        }
    }
    
    public void setNorthRoom(final Room room) {
        final Door aDoor = new Door(this, room);
        this.setNorthDoor(aDoor);
        room.setSouthDoor(aDoor);
    }
    
    public void setSouthRoom(final Room room) {
        final Door aDoor = new Door(this, room);
        this.setSouthDoor(aDoor);
        room.setNorthDoor(aDoor);
    }
    
    public void setWestRoom(final Room room) {
        final Door aDoor = new Door(this, room);
        this.setWestDoor(aDoor);
        room.setEastDoor(aDoor);
    }
    
	public void setEastRoom(final Room room) {
		final Door aDoor = new Door(this, room);
		this.setEastDoor(aDoor);
		room.setWestDoor(aDoor);
	}
    
    public Door getNorthDoor() {
        return this.northDoor;
    }
    
    private void setNorthDoor(final Door northDoor) {
        this.northDoor = northDoor;
    }
    
    public Door getSouthDoor() {
        return this.southDoor;
    }
    
    private void setSouthDoor(final Door southDoor) {
        this.southDoor = southDoor;
    }
    
    public Door getWestDoor() {
        return this.westDoor;
    }
    
    private void setWestDoor(final Door westDoor) {
        this.westDoor = westDoor;
    }
    
    public Door getEastDoor() {
        return this.eastDoor;
    }
    
    private void setEastDoor(final Door eastDoor) {
        this.eastDoor = eastDoor;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public RoomWithSomething getElementInRoom() {
        return this.elementInRoom;
    }
    
    public void setElementInRoom(final RoomWithSomething elementInRoom) {
        this.elementInRoom = elementInRoom;
    }
}
