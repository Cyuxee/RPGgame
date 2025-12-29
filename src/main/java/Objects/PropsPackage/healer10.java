package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;
import javafx.scene.image.ImageView;

public class healer10 extends Objects{
	
	private int HealAmount=150;
	public healer10(Players player) {
		super(player);
		Image = makeBG("/Images/神級藥水64.png");
		ID = 50;
		QUALITY="傳說";
		//粗劣 普通 良好 稀有 史詩 傳說 不滅
	    //灰色 白色 綠色 藍色 紫色 橘色 黑色		
		Name = "恢復藥(神級)";
		Note = "神級的HP恢復藥劑，可以回滿生命"; 
		isHeal = true;
		isMp = false;
		Amount = (int)(Math.random()*99)%3+1;
		HealAmount=super.owner.getMaxHealth();
		sellPrice=5000;
		dropChance=1;
	}
	@Override
	public int getHealAmount() {
		return this.owner.getMaxHealth(); 
	}
	@Override
	public void Heal() {
		System.out.println(this.owner.getPlayer()+" 19");
		this.owner.setHealth(this.owner.getMaxHealth());
	}
	
}