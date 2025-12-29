package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor05 extends Objects{
	public Armor05(Players player) {
		super(player);
		ID = 40021;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "無回鎧甲";
		Note = "從無回境地回來的人所被賦予的鎧甲";
		Image = makeBG("/Images/盔甲05.png");
		strength = 0;//強化等級
		Armor=185;//護甲值
		LV_ACQUIRED = 47;//等級限制
		AGI_ACQUIRED =48;
	    INT_ACQUIRED =45;
	    STR_ACQUIRED =41;
	    LUK_ACQUIRED =36;
	    
	    escape = 8;//閃避綠
		boom = 8;//報及綠
		BoomAttackRate=0.12;//抱傷
		Hit = 8; //命中
		
		HP+=405;//生命
		MP+=167;//魔力
		STR+=37;//力量
		INT+=35;//智慧
		LUK+=31;//幸運
		AGI+=34;//敏捷
		
		sellPrice =10000;
		buyPrice =50000;
		dropChance=5;
	}

}
