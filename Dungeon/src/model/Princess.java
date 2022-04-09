package model;

public class Princess extends RoomElement
{
    private boolean free;
    
    public Princess(final String desc) {
        super(desc);
        this.free = false;
    }
    
    public boolean isFree() {
        return this.free;
    }
    
    public void setFree(final boolean free) {
        this.free = free;
    }
}