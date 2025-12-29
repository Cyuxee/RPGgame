package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants05 extends Objects{
	public Pants05(Players player) {
		super(player);
		ID = 40022;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "無回長褲";
		Note = "從無回境地回來的人所被賦予的褲子";
		Image = makeBG("/Images/脛甲05.png");
		strength = 0;//強化等級
		Armor=105;//護甲值
		LV_ACQUIRED = 45;//等級限制
		AGI_ACQUIRED =30;
	    INT_ACQUIRED =35;
	    STR_ACQUIRED =39;
	    LUK_ACQUIRED =34;
	    
	    escape = 5;//閃避綠
		boom =6;//報及綠
		BoomAttackRate=0.1;//抱傷
		Hit = 8; //命中
		
		HP+=253;//生命
		MP+=165;//魔力
		STR+=21;//力量
		INT+=21;//智慧
		LUK+=23;//幸運
		AGI+=19;//敏捷
		
		sellPrice =10000;
		buyPrice =50000;
		dropChance=5;
	}

}
