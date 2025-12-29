package Objects;

import Entities.Players;

/**
 * Equipment items - items that provide stat bonuses and can be worn.
 * Only contains properties relevant to equipment (armor, damage bonuses, stat bonuses).
 */
public abstract class Equipment extends Item {
    
    protected int Armor = 0;
    protected int attack = 0;
    protected int escape = 0; // 閃避率
    protected int Hit = 0; // 命中
    protected int boom = 0; // 暴擊率
    protected double BoomAttackRate = 0; // 額外加成
    protected int magicAttack = 0;
    
    protected int HP = 0; // 生命加成
    protected int MP = 0; // 魔力加成
    protected int STR = 0; // 力量
    protected int INT = 0; // 智慧
    protected int LUK = 0; // 幸運
    protected int AGI = 0; // 敏捷
    
    public Equipment(Players owner) {
        super(owner);
    }
    
    public Equipment() {
        super();
    }
    
    // Armor and defense
    public void setArmor(int armor) {
        this.Armor = armor;
    }
    
    public int getArmor() {
        return this.Armor;
    }
    
    // Attack and damage
    public void setAttack(int attack) {
        this.attack = attack;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    // Escape (dodge)
    public void setEscape(int escape) {
        this.escape = escape;
    }
    
    public int getEscape() {
        return this.escape;
    }
    
    // Hit (accuracy)
    public void setHit(int hit) {
        this.Hit = hit;
    }
    
    public int getHit() {
        return this.Hit;
    }
    
    // Boom (critical chance)
    public void setBoom(int boom) {
        this.boom = boom;
    }
    
    public int getBoom() {
        return this.boom;
    }
    
    // Boom attack rate
    public double getBoomAttackRate() {
        return this.BoomAttackRate;
    }
    
    public void setBoomAttackRate(double boomAttackRate) {
        this.BoomAttackRate = boomAttackRate;
    }
    
    // Magic attack
    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }
    
    public int getMagicAttack() {
        return this.magicAttack;
    }
    
    // Health bonus
    public int getHealthPlus() {
        return this.HP;
    }
    
    public void setHealthPlus(int HP) {
        this.HP = HP;
    }
    
    // Mana bonus
    public int getManaPlus() {
        return this.MP;
    }
    
    public void setManaPlus(int ManaPlus) {
        this.MP = ManaPlus;
    }
    
    // Stat bonuses
    public int getSTR() {
        return this.STR;
    }
    
    public void setSTR(int STR) {
        this.STR = STR;
    }
    
    public int getINT() {
        return this.INT;
    }
    
    public void setINT(int INT) {
        this.INT = INT;
    }
    
    public int getLUK() {
        return this.LUK;
    }
    
    public void setLUK(int LUK) {
        this.LUK = LUK;
    }
    
    public int getAGI() {
        return this.AGI;
    }
    
    public void setAGI(int AGI) {
        this.AGI = AGI;
    }
}
