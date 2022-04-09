package model;

public class Weapon extends Equipment
{
    private int attackPoints;
    
    public Weapon(final String name, final int attackPoints) {
        super(name);
        this.attackPoints = attackPoints;
    }
    
    public int getAttackPoints() {
        return this.attackPoints;
    }
}