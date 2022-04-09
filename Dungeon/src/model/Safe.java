package model;

public class Safe extends RoomElement
{
    private boolean locked;
    
    public Safe(final String desc) {
        this(desc, false);
    }
    
    public Safe(final String desc, final boolean locked) {
        super(desc);
        this.locked = locked;
    }
    
    @Override
    public String getDescription() {
        return String.valueOf(super.getDescription()) + (this.isLocked() ? ". The safe is closed" : ". The safe do not look locked.");
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void setLocked(final boolean locked) {
        this.locked = locked;
    }
}