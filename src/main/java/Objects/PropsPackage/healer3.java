package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;

public class healer3 extends Objects{
	
	private int HealAmount=1500;
	public healer3(Players player) {
		super(player);
		ID = 4;
		Image = makeBG("/Images/紅色藥水64.png");
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
		 				 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		Name = "恢復藥(上級)";
		Note = "上級的HP恢復藥劑，可以恢復 " + HealAmount + " 點生命"; 
		isHeal = true;
		isMp= false;

		sellPrice=1000;
		buyPrice=2000;
		dropChance=10;
	}
	@Override
	public int getHealAmount() {
		return this.HealAmount; 
	}
	@Override
	public void Heal() {
		this.owner.setHealth(this.owner.getHealth()+HealAmount);
	}

}