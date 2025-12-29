package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;

public class healer2 extends Objects{
	
	private int HealAmount=500;
	public healer2(Players player) {
		super(player);
		ID = 2;
		Image = makeBG("/Images/紅色藥水64.png");
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
		 				 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		Name = "恢復藥(中級)";
		Note = "中級的HP恢復藥劑，可以恢復 " + HealAmount + " 點生命"; 
		isHeal = true;
		isMp= false;

		sellPrice=250;
		buyPrice=500;
		dropChance=20;
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