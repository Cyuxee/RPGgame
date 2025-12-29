package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes05 extends Objects{
	public Shoes05(Players player) {
		super(player);
		ID = 40023;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "無回短靴";
		Note = "從無回境地回來的人所被賦予的靴子";
		Image = makeBG("/Images/長靴05.png");
		strength = 0;//強化等級
		Armor=69;//護甲值
		LV_ACQUIRED = 44;//等級限制
		AGI_ACQUIRED =28;
	    INT_ACQUIRED =20;
	    STR_ACQUIRED =24;
	    LUK_ACQUIRED =24;
	    
	    escape = 4;//閃避綠
		boom =5;//報及綠
		BoomAttackRate=0.08;//抱傷
		Hit = 4; //命中
		
		HP+=217;//生命
		MP+=178;//魔力
		STR+=23;//力量
		INT+=19;//智慧
		LUK+=22;//幸運
		AGI+=17;//敏捷
		
		sellPrice =10000;
		buyPrice =50000;
		dropChance=5;
	}

}
