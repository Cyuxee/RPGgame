package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;

public class weardDrink extends Objects{
	
	private int HealAmount=150;
	
	public weardDrink(Players player) {
		super(player);
		ID= 52;
		Image = makeBG("/Images/神級魔力藥水64.png");
		QUALITY = "不滅";
		//粗劣 普通 良好 稀有 史詩 傳說 不滅
		 			 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		Name = "奇怪的藥水";
		Note = "從販賣機拿到的奇怪藥水。"; 
		isHeal = true;
		HealAmount=owner.getMaxHealth();
		isMp = true;
		Amount = (int)(Math.random()*99)%3+1;
		dropChance=1;
	}
	@Override
	public int getHealAmount() {
		System.out.println(owner.getPlayer() +  " 回復" + HealAmount);
		return this.owner.getMaxMana(); 
	}
	@Override
	public void Heal() {
		this.owner.setMana(this.owner.getMaxMana());//記得加上this 不然會抓不到
		
	}
	
	
}