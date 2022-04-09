package Model;

public class Monster extends RoomWithSomething {
	
    public static final int WEAK_MONSTER_HP = 100;
    public static final int STRONG_MONSTER_HP = 150;
    public static final int BOSS_MONSTER_HP = 200;
    public static final int WEAK_MONSTER_ATTACK = 10;
    public static final int STRONG_MONSTER_ATTACK = 15;
    public static final int BOSS_MONSTER_ATTACK = 25;
    private int attack;
    private int hp;

    public Monster(final String desc, final int hp, final int attack) {
        super(desc);
        this.hp = hp;
        this.attack = attack;
    }
    
    public int getHp() {
        return this.hp;
    }
    
    public boolean isAlive() {
        return this.hp > 0;
    }
    
    public int getAttack() {
    	return this.attack;
    }
    
    public void hit(final int receivedAttack) {
        this.hp -= receivedAttack;
    }
    
    public String getDescription() {
        return String.valueOf(super.getDescription()) + (this.isAlive() ? "" : ", et est mort!");
    }
}
