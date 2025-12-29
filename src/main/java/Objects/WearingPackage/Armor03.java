package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor03 extends Objects{
	public Armor03(Players player) {
		super(player);
		ID = 40013;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔靈鎧甲";
		Note = "傳說被魔源之靈所寄宿過的鎧甲";
		Image = makeBG("/Images/盔甲03.png");
		strength = 0;//強化等級
		Armor=85;//護甲值
		LV_ACQUIRED = 27;//等級限制
		AGI_ACQUIRED =28;
	    INT_ACQUIRED =15;
	    STR_ACQUIRED =29;
	    LUK_ACQUIRED =26;
	    
	    escape = 5;//閃避綠
		boom = 5;//報及綠
		BoomAttackRate=0.08;//抱傷
		Hit = 4; //命中
		
		HP+=205;//生命
		MP+=87;//魔力
		STR+=17;//力量
		INT+=19;//智慧
		LUK+=18;//幸運
		AGI+=19;//敏捷
		
		sellPrice =1000;
		buyPrice =5000;
		dropChance=10;
	}

}
