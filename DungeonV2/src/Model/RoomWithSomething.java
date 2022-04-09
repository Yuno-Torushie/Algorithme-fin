package Model;

public abstract class RoomWithSomething {
  
	private String description;
    private Equipment loot;
    
    public RoomWithSomething(final String desc) {
        this.description = desc;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public String toString() {
        return this.getDescription();
    }
    
    public Equipment getLoot() {
        return this.loot;
    }
    
    public void setLoot(final Equipment loot) {
        this.loot = loot;
    }
}
