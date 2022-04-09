package model;

public abstract class Equipment
{
    private String name;
    
    public Equipment(final String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}