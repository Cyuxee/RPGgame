package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes02 extends Objects{
	public Shoes02(Players player) {
		super(player);
		ID = 40011;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "冒險者短靴";
		Note = "冒險者常穿的靴子";
		Image = makeBG("/Images/長靴02.png");
		strength = 0;//強化等級
		Armor=27;//護甲值
		LV_ACQUIRED = 14;//等級限制
		AGI_ACQUIRED =8;
	    INT_ACQUIRED =13;
	    STR_ACQUIRED =17;
	    LUK_ACQUIRED =12;
	    
	    escape = 1;//閃避綠
		boom =2;//報及綠
		BoomAttackRate=0.05;//抱傷
		Hit = 2; //命中
		
		HP+=67;//生命
		MP+=48;//魔力
		STR+=6;//力量
		INT+=7;//智慧
		LUK+=6;//幸運
		AGI+=5;//敏捷
		
		sellPrice =500;
		buyPrice =2500;
		dropChance=10;
	}

}
