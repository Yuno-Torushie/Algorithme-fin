package Model;

import java.util.*;

public class Dungeon {
	
    private static final boolean LOCKED = true;
    private List<Room> rooms;
    private Room startingRoom;
    private Princess Yuno;
    
    public Dungeon() {
        this.rooms = new ArrayList<Room>();
        this.initRooms();
    }
    
    private void initRooms() {
        this.Yuno = new Princess("la magnifique Yuno, qui sait tous!");
        
        //PartieO
        final Room entry = new Room("L'entré du donjon.");
        final Room cross11 = new Room("un croisement avec des portes dans toutes les directions.");
        entry.setNorthRoom(cross11);
        
        //Partie1
        final Room roomT11 = new Room("une grande salle vide");
        final Room coridorH11 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomChest11 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        final Room roomChest12 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        final Chest chest11 = new Chest("un petit coffre.");
        chest11.setLoot((Equipment)new Key("une petite clé."));
        roomChest11.setElementInRoom((RoomWithSomething)chest11);
        roomT11.setSouthRoom(roomChest11);
        roomT11.setWestRoom(coridorH11);
        coridorH11.setWestRoom(roomChest12);
        coridorH11.getWestDoor().setLocked(true);
        final Monster skeleton = new Monster("un skeleton", Monster.WEAK_MONSTER_HP, Monster.WEAK_MONSTER_ATTACK);
        skeleton.setLoot((Equipment)new Key("une petite clé."));
        coridorH11.setElementInRoom((RoomWithSomething)skeleton);
        final Chest chest12 = new Chest("un petit coffre.");
        chest12.setLoot((Equipment)new Weapon("couteau", 30));
        roomChest12.setElementInRoom((RoomWithSomething)chest12);
        
        //Partie2
        final Room roomL21 = new Room("une grande salle vide.");
        final Room roomL22 = new Room("une grande salle vide.");
        final Room roomChest21 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        roomL21.setSouthRoom(roomL22);
        roomL22.setEastRoom(roomChest21);
        roomL22.getEastDoor().setLocked(true);
        final Monster spiderGiant = new Monster("une araignée géante", Monster.STRONG_MONSTER_HP, Monster.STRONG_MONSTER_ATTACK);
        spiderGiant.setLoot((Equipment)new Key("une petite clé."));
        roomL22.setElementInRoom((RoomWithSomething)spiderGiant);
        final Chest chest22 = new Chest("un petit coffre.");
        chest22.setLoot((Equipment)new Weapon("machette", 40));
        roomChest21.setElementInRoom((RoomWithSomething)chest22);
        
        //Partie3
        final Room cross31 = new Room("un croisement avec des portes dans toutes les directions.");
        final Room coridorH31 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomL31 = new Room("une petite salle.");
        final Room roomChest31 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        final Room coridorV31 = new Room("un couloir tout ce qu'il y a de plus banal.");
        cross31.setEastRoom(coridorH31);
        cross31.setNorthRoom(coridorV31);
        coridorH31.setEastRoom(roomL31);
        roomL31.setSouthRoom(roomChest31);
        final Monster zombie = new Monster("un zombie", Monster.WEAK_MONSTER_HP, Monster.WEAK_MONSTER_ATTACK);
        roomL31.setElementInRoom((RoomWithSomething)zombie);
        final Chest chest31 = new Chest("un petit coffre.");
        chest31.setLoot((Equipment)new Key("une petite clé."));
        roomChest31.setElementInRoom((RoomWithSomething)chest31);
        
        
        //Partie4
        final Room coridorH41 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room coridorH42 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room roomChest41 = new Room("une grande salle vide mais il ne semble pas qu'elle soit si vide que ça.");
        coridorH41.setWestRoom(coridorH42);
        coridorH41.getWestDoor().setLocked(true);
        coridorH42.setWestRoom(roomChest41);
        final Monster ogre = new Monster("un ogre", Monster.STRONG_MONSTER_HP, Monster.STRONG_MONSTER_ATTACK);
        coridorH42.setElementInRoom((RoomWithSomething)ogre);
        final Chest chest41 = new Chest("un petit coffre.");
        chest41.setLoot((Equipment)new Weapon("épée", 50));
        roomChest41.setElementInRoom((RoomWithSomething)chest41);
        
        //Partie5
        final Room coridorH51 = new Room("un couloir tout ce qu'il y a de plus banal.");
        final Room coridorChest51 = new Room("un couloir mais il semble y avoir quelque chose dans la pièce.");
        coridorH51.setNorthRoom(coridorChest51);

        final Chest chest51 = new Chest("un petit coffre.");
        chest51.setLoot((Equipment)new Key("une grande clé."));
        coridorChest51.setElementInRoom((RoomWithSomething)chest51);
        
        //Partie6
        final Room roomBoss = new Room("une salle massivement grande.");
        final Room roomPrincess = new Room("une petite salle cosy.");
        roomBoss.setNorthRoom(roomPrincess);
        roomPrincess.setElementInRoom((RoomWithSomething)this.Yuno);
        final Monster boss = new Monster("le Diabolique Dragon Torushie", Monster.BOSS_MONSTER_HP, Monster.BOSS_MONSTER_ATTACK);
        roomBoss.setElementInRoom((RoomWithSomething)boss);
        
        
        //Relation entre les Parties
        cross11.setWestRoom(roomT11);
        cross11.setEastRoom(roomL21);
        cross11.getEastDoor().setLocked(true);
        cross11.setNorthRoom(cross31);
        cross31.setWestRoom(coridorH41);
        coridorV31.setNorthRoom(coridorH51);
        coridorChest51.setNorthRoom(roomBoss);
        coridorChest51.getNorthDoor().setLocked(true);
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
