package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants02 extends Objects{
	public Pants02(Players player) {
		super(player);
		ID = 40010;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "冒險者長褲";
		Note = "冒險者常穿的褲子";
		Image = makeBG("/Images/脛甲02.png");
		strength = 0;//強化等級
		Armor=19;//護甲值
		LV_ACQUIRED = 15;//等級限制
		AGI_ACQUIRED =16;
	    INT_ACQUIRED =14;
	    STR_ACQUIRED =14;
	    LUK_ACQUIRED =17;
	    
	    escape = 2;//閃避綠
		boom =2;//報及綠
		BoomAttackRate=0.04;//抱傷
		Hit = 2; //命中
		
		HP+=73;//生命
		MP+=65;//魔力
		STR+=6;//力量
		INT+=5;//智慧
		LUK+=5;//幸運
		AGI+=7;//敏捷
		
		sellPrice =500;
		buyPrice =2500;
		dropChance=10;
	}

}
