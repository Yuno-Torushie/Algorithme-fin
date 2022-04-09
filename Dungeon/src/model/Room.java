package model;

import util.*;

public class Room
{
    private String description;
    private Door eastDoor;
    private Door westDoor;
    private Door northDoor;
    private Door southDoor;
    private RoomElement elementInRoom;
    
    public Room(final String description) {
        this.description = description;
    }
    
    public void describe() {
        Console.affiche("You are in " + this.description);
        if (this.westDoor != null) {
            Console.affiche("There's a door on the west direction.");
            if (this.westDoor.isLocked()) {
                Console.affiche("... but it looks to be locked...");
            }
        }
        if (this.eastDoor != null) {
            Console.affiche("There's a door on the east direction.");
            if (this.eastDoor.isLocked()) {
                Console.affiche("... but it looks to be locked...");
            }
        }
        if (this.northDoor != null) {
            Console.affiche("There's a door on the north direction.");
            if (this.northDoor.isLocked()) {
                Console.affiche("... but it looks to be locked...");
            }
        }
        if (this.southDoor != null) {
            Console.affiche("There's a door on the south direction.");
            if (this.southDoor.isLocked()) {
                Console.affiche("... but it looks to be locked...");
            }
        }
        if (this.getElementInRoom() != null) {
            Console.affiche("There's " + this.getElementInRoom().toString());
        }
    }
    
    public void setNorthRoom(final Room room) {
        final Door aDoor = new Door(this, room);
        this.setNorthDoor(aDoor);
        room.setSouthDoor(aDoor);
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
    
    public void setSouthRoom(final Room room) {
        final Door aDoor = new Door(this, room);
        this.setSouthDoor(aDoor);
        room.setNorthDoor(aDoor);
    }
    
    public Door getEastDoor() {
        return this.eastDoor;
    }
    
    private void setEastDoor(final Door eastDoor) {
        this.eastDoor = eastDoor;
    }
    
    public Door getWestDoor() {
        return this.westDoor;
    }
    
    private void setWestDoor(final Door westDoor) {
        this.westDoor = westDoor;
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
    
    public String getDescription() {
        return this.description;
    }
    
    public RoomElement getElementInRoom() {
        return this.elementInRoom;
    }
    
    public void setElementInRoom(final RoomElement elementInRoom) {
        this.elementInRoom = elementInRoom;
    }
}