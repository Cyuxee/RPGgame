package Objects;

import Entities.Players;

/**
 * Consumable items - items that provide temporary effects and are consumed.
 * Only contains properties relevant to consumables (healing, mana restoration, etc).
 */
public abstract class Consumable extends Item {
    
    protected int HealAmount = 0;
    protected int ManaAmount = 0;
    protected boolean isHeal = false;
    protected boolean isMp = false;
    
    public Consumable(Players owner) {
        super(owner);
    }
    
    public Consumable() {
        super();
    }
    
    // Health healing
    public int getHealAmount() {
        return this.HealAmount;
    }
    
    public void setHealAmount(int amount) {
        this.HealAmount = amount;
    }
    
    public boolean isHeal() {
        return this.isHeal;
    }
    
    public void setIsHeal(boolean heal) {
        this.isHeal = heal;
    }
    
    // Mana restoration
    public int getManaAmount() {
        return this.ManaAmount;
    }
    
    public void setManaAmount(int amount) {
        this.ManaAmount = amount;
    }
    
    public boolean isMP() {
        return this.isMp;
    }
    
    public void setIsMPH(boolean isMP) {
        this.isMp = isMP;
    }
    
    /**
     * Applies the healing effect to the owner.
     */
    public abstract void Heal();
}
