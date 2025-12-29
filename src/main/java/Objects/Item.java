package Objects;

import Entities.Mobs;
import Entities.Players;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * Base class for all items in the game.
 * Contains only common properties shared by all item types.
 * Refuses bequest - subclasses only inherit what they need.
 */
public abstract class Item {
    
    protected int sellIndex = -1;
    protected String productAmount = "無限";
    protected int buyPrice = 0;
    protected int sellPrice = 0;
    protected boolean isDiamond = false;
    protected Players owner;
    protected static Mobs enemy;
    protected String Name;
    protected int ID = 0;
    protected String Note;
    protected double lotChance;
    protected int Amount = 1;
    protected int dropChance = 0;
    
    protected int LV_ACQUIRED = 0; // 等級限制
    protected int STR_ACQUIRED = 0; // 力量限制
    protected int INT_ACQUIRED = 0; // 智慧限制
    protected int LUK_ACQUIRED = 0; // 幸運限制
    protected int AGI_ACQUIRED = 0; // 敏捷限制
    
    protected int strength = 0; // 強化等級
    protected String QUALITY; // 粗劣 普通 良好 稀有 史詩 傳說 不滅
    protected String WEARING_TYPE;
    
    protected Background Image;
    protected boolean isSkill = false;
    
    public Item(Players owner) {
        this.owner = owner;
    }
    
    public Item() {
    }
    
    /**
     * Creates a JavaFX Background from an image resource.
     */
    protected Background makeBG(String imagePath) {
        Image img = new Image(Objects.class.getResourceAsStream(imagePath));
        BackgroundImage bgImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        return new Background(bgImg);
    }
    
    // Basic getters/setters
    public void setEnemy(Mobs mob) {
        enemy = mob;
    }
    
    public String getNote() {
        return this.Note;
    }
    
    public int getID() {
        return this.ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getAmount() {
        return this.Amount;
    }
    
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }
    
    public String getName() {
        return this.Name;
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public int getSellPrice() {
        return this.sellPrice;
    }
    
    public int getBuyPrice() {
        return this.buyPrice;
    }
    
    public int getDropChance() {
        return this.dropChance;
    }
    
    public void setDropChance(int dropChance) {
        this.dropChance = dropChance;
    }
    
    public Background getImage() {
        return Image;
    }
    
    public void setImage(Background img) {
        Image = img;
    }
    
    public int getStrength() {
        return this.strength;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public String getQuality() {
        return this.QUALITY;
    }
    
    public void setQuality(String quality) {
        this.QUALITY = quality;
    }
    
    public int getLVAcquired() {
        return this.LV_ACQUIRED;
    }
    
    public int getStrAcquired() {
        return this.STR_ACQUIRED;
    }
    
    public int getIntAcquired() {
        return this.INT_ACQUIRED;
    }
    
    public int getLukAcquired() {
        return this.LUK_ACQUIRED;
    }
    
    public int getAgiAcquired() {
        return this.AGI_ACQUIRED;
    }
    
    public void setWearType(String type) {
        this.WEARING_TYPE = type;
    }
    
    public String getWearType() {
        return this.WEARING_TYPE;
    }
}
