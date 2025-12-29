package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;

public class mpHealer2 extends Objects{
	
	private int HealAmount=500;
	public mpHealer2(Players player) {
		super(player);
		ID= 5;
		Image = makeBG("/Images/藍色藥水64.png");
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
		 			 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		Name = "魔力恢復藥(中級)";
		Note = "中級的MP恢復藥劑，可以恢復 " + HealAmount + " 點魔力"; 
		isHeal = true;
		isMp = true;

		sellPrice=250;
		buyPrice=500;
		Amount = (int)(Math.random()*99)%3+1;
		dropChance=20;
	}
	@Override
	public int getHealAmount() {
		return this.HealAmount; 
	}
	@Override
	public void Heal() {
		this.owner.setMana(this.owner.getMana()+HealAmount);//記得加上this 不然會抓不到
		
	}
	
	
}