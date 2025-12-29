package Entities;

import java.util.ArrayList;

import Skills.skillStatus;

/**
 * Base class for combat entities (Players and Mobs).
 * Encapsulates common combat-related attributes to eliminate data clumps.
 */
public abstract class CombatEntity implements Runnable {
    protected int health;
    protected int maxHealth;
    protected int damage;
    protected int armor;
    protected int level;
    protected int escape; // 閃避率
    protected ArrayList<skillStatus> buffs;
    
    /**
     * Constructor initializing common combat attributes with default values.
     */
    protected CombatEntity() {
        this.buffs = new ArrayList<>();
        this.health = 0;
        this.maxHealth = 0;
        this.damage = 0;
        this.armor = 0;
        this.level = 1;
        this.escape = 0;
    }
    
    // Health management
    public int getHealth() {
        return this.health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    
    // Damage management
    public int getDamage() {
        return this.damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    // Armor management
    public int getArmor() {
        return this.armor;
    }
    
    public void setArmor(int armor) {
        this.armor = armor;
    }
    
    // Level management
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    // Escape (dodge) management
    public int getEscape() {
        return this.escape;
    }
    
    public void setEscape(int escape) {
        this.escape = escape;
    }
    
    // Buffs management
    public ArrayList<skillStatus> getBuffs() {
        return this.buffs;
    }
    
    public void setBuffs(ArrayList<skillStatus> buffs) {
        this.buffs = buffs;
    }
    
    @Override
    public abstract void run();
}
