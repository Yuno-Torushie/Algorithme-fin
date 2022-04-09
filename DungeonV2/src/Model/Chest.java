package Model;

public class Chest extends RoomWithSomething{
    
	private boolean locked;
    
    public Chest(final String desc) {
        this(desc, false);
    }
    
    public Chest(final String desc, final boolean locked) {
        super(desc);
        this.locked = locked;
    }
    
    @Override
    public String getDescription() {
        return String.valueOf(super.getDescription()) + (this.isLocked() ? "Le coffre semble fermé." : "Le coffre semble ouvert.");
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setLocked(final boolean locked) {
        this.locked = locked;
    }
}
