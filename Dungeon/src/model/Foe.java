package model;

public class Foe extends RoomElement
{
    public static int STRONG_FOE_HP;
    public static int WEAK_FOE_HP;
    public static int BOSS_HP;
    private int hp;
    private int Mhp;
    
    static {
        Foe.STRONG_FOE_HP = 30;
        Foe.WEAK_FOE_HP = 10;
        Foe.BOSS_HP = 50;
    }
    
    public Foe(final String desc, final int hp) {
        super(desc);
        this.hp = hp;
        Mhp = hp;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }
    
    public void hit(final int receivedAttack) {
        this.hp -= receivedAttack;
    }
    
    public String getDescription() {
        return String.valueOf(super.getDescription()) + (this.isAlive() ? "" : ". The enemy is dead.");
    }
    
    public void Regenerate() {
    	hp = Mhp;
    }
}