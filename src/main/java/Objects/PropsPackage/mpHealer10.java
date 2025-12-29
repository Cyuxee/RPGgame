package Objects.PropsPackage;

import Entities.Players;
import Objects.Objects;

public class mpHealer10 extends Objects{
	
	private int HealAmount=150;
	
	public mpHealer10(Players player) {
		super(player);
		ID= 51;
		Image = makeBG("/Images/神級魔力藥水64.png");
		QUALITY = "傳說";
		//粗劣 普通 良好 稀有 史詩 傳說 不滅
		 			 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		Name = "魔力恢復藥(神級)";
		Note = "神級的MP恢復藥劑，可以回滿魔力"; 
		isHeal = true;
		HealAmount=owner.getMaxMana();
		isMp = true;
		Amount = (int)(Math.random()*99)%3+1;
		sellPrice=5000;

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