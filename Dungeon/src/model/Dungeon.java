package model;

import java.util.*;

public class Dungeon
{
    private static final boolean LOCKED = true;
    private List<Room> rooms;
    private Room startingRoom;
    private Princess Yuno;
    
    public Dungeon() {
        this.rooms = new ArrayList<Room>();
        this.initRooms();
    }
    
    private void initRooms() {
        this.Yuno = new Princess("the beautiful Zelda");
        final Room entry = new Room("a very dark room for the first room of the dungeon...");
        final Room cross1 = new Room("a strangely quiet room with doors towards all directions");
        final Room basicRoom1 = new Room("an empty room where we can hear some strange ticks");
        final Room basicRoom2 = new Room("a room with blood and chunks of brains on walls");
        final Room knifeRoom = new Room("a kind of kitchen with tables and chairs... \nand human corpses as first source of alimentation... \nmaybe something sharped could be found here.");
        final Foe madCooker = new Foe("a mad cooker who like to skin other people with his kitchen tools", Foe.STRONG_FOE_HP);
        madCooker.setLoot((Equipment)new Weapon("Sharped knife", 10));
        knifeRoom.setElementInRoom((RoomElement)madCooker);
        final Room foeRoom = new Room("a small room");
        final Room keyRoom = new Room("a very long hall with something visible at its extremity.");
        final Safe safe1 = new Safe("a small safe hidden under a massive stack of dust");
        safe1.setLoot((Equipment)new SafeKey("an old key"));
        keyRoom.setElementInRoom((RoomElement)safe1);
        final Room foeRoom2 = new Room("a surprizing room with nothin interesting in");
        final Foe spider = new Foe("a huge spider", Foe.WEAK_FOE_HP);
        foeRoom.setElementInRoom((RoomElement)spider);
        final Foe tentacle = new Foe("a japanese tentacle with strange extremities", Foe.STRONG_FOE_HP);
        foeRoom2.setElementInRoom((RoomElement)tentacle);
        final Room cross2 = new Room("a strangely quiet room with doors towards all directions");
        final Room lootRoom = new Room("a room where you have a good feeling");
        final Foe littleWorm = new Foe("a very cute pink worm", Foe.WEAK_FOE_HP);
        littleWorm.setLoot((Equipment)new SafeKey("a skeleton key"));
        lootRoom.setElementInRoom((RoomElement)littleWorm);
        final Room basicRoom3 = new Room("a room where you take a quick rest");
        final Room nothingRoom = new Room("a room? or just an empty space with 4 walls around?");
        final Safe safe2 = new Safe("a very big golden safe", true);
        safe2.setLoot((Equipment)new SafeKey("a small iron key"));
        nothingRoom.setElementInRoom((RoomElement)safe2);
        final Room safetyRoom = new Room("a room with a present to give away");
        final Safe safe3 = new Safe("a large safe");
        safe3.setLoot((Equipment)new Weapon("a strong and sharpened claymore", 25));
        safetyRoom.setElementInRoom((RoomElement)safe3);
        nothingRoom.setElementInRoom((RoomElement)safe2);
        final Room hallRoom = new Room("a long hall");
        final Room basicRoom4 = new Room("a room. what else?");
        final Room basicRoom5 = new Room("a cat. euh... no, another f*** room");
        final Room safetyRoom2 = new Room("a pleasant room");
        final Safe safe4 = new Safe("a small safe which does not look closed...");
        safetyRoom2.setElementInRoom((RoomElement)safe4);
        final Room bossRoom = new Room("a very large room with a 100-feet high ceiling. \nThe ground is full of bones. \nJust walking is difficult because of these humain being remains.");
        final Foe boss = new Foe("a massive Boss with 'POO' written in blood letters on its chest", Foe.BOSS_HP);
        bossRoom.setElementInRoom((RoomElement)boss);
        final Room princessRoom = new Room("a well decorated room with a large bed at its middle. \nSome loud tears can be heard from the bed...");
        princessRoom.setElementInRoom((RoomElement)this.Yuno);
        entry.setNorthRoom(cross1);
        cross1.setWestRoom(basicRoom1);
        cross1.setEastRoom(basicRoom2);
        basicRoom2.setSouthRoom(knifeRoom);
        basicRoom1.setWestRoom(foeRoom);
        foeRoom.setSouthRoom(keyRoom);
        cross1.setNorthRoom(foeRoom2);
        foeRoom2.setNorthRoom(cross2);
        cross2.setNorthRoom(lootRoom);
        cross2.getNorthDoor().setLocked(true);
        cross2.setWestRoom(basicRoom3);
        basicRoom3.setSouthRoom(nothingRoom);
        basicRoom3.setNorthRoom(hallRoom);
        hallRoom.setNorthRoom(safetyRoom);
        cross2.setEastRoom(basicRoom4);
        basicRoom4.setEastRoom(basicRoom5);
        basicRoom4.getEastDoor().setLocked(true);
        basicRoom5.setEastRoom(safetyRoom2);
        safetyRoom2.setSouthRoom(bossRoom);
        bossRoom.setSouthRoom(princessRoom);
        this.setStartingRoom(entry);
    }
    
    public Room getStartingRoom() {
        return this.startingRoom;
    }
    
    public void setStartingRoom(final Room startingRoom) {
        this.startingRoom = startingRoom;
    }
    
    public Princess getYuno() {
        return this.Yuno;
    }
}