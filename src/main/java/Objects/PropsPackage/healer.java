package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;
import javafx.scene.image.ImageView;

public class healer extends Objects{
	
	private int HealAmount=150;
	public healer(Players player) {
		super(player);
		Image = makeBG("/Images/紅色藥水64.png");
		ID = 1;
		QUALITY="普通";
		//粗劣 普通 良好 稀有 史詩 傳說 不滅
	    //灰色 白色 綠色 藍色 紫色 橘色 黑色		
		Name = "恢復藥(低級)";
		Note = "低級的HP恢復藥劑，可以恢復 " + HealAmount + " 點生命"; 
		isHeal = true;
		isMp = false;
		Amount = (int)(Math.random()*99)%3+1;
		dropChance=20;
		sellPrice=50;
		buyPrice=100;
	}
	@Override
	public int getHealAmount() {
		return this.HealAmount; 
	}
	@Override
	public void Heal() {
		System.out.println(this.owner.getPlayer()+"   89");
		this.owner.setHealth(this.owner.getHealth()+HealAmount);
	}
	
}
