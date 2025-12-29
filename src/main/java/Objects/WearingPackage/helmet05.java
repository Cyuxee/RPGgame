package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet05 extends Objects{
	public helmet05(Players player) {
		super(player);
		ID = 40020;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "無回頭盔";
		Note = "從無回境地回來的人所被賦予的頭盔";
		Image = makeBG("/Images/頭盔05.png");
		strength = 0;//強化等級
		Armor=78;//護甲值
		LV_ACQUIRED = 43;//等級限制
		AGI_ACQUIRED =39;
	    INT_ACQUIRED =30;
	    STR_ACQUIRED =33;
	    LUK_ACQUIRED =31;
	    
	    escape = 5;//閃避綠
		boom =5;//報及綠
		BoomAttackRate=0.08;//抱傷
		Hit = 8; //命中
		
		HP+=217;//生命
		MP+=162;//魔力
		STR+=20;//力量
		INT+=21;//智慧
		LUK+=18;//幸運
		AGI+=19;//敏捷
		sellPrice =10000;
		buyPrice =50000;
		dropChance=5;
	}

}
