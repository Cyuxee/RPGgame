package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet08 extends Objects{
	public helmet08(Players player) {
		super(player);
		ID = 40032;
		QUALITY = "傳說";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔源戰盔";
		Note = "魔源大陸上最精純之力，堪比神之意念";
		Image = makeBG("/Images/頭盔08.png");
		strength = 0;//強化等級
		Armor=500;//護甲值
		LV_ACQUIRED = 73;//等級限制
		AGI_ACQUIRED =65;
	    INT_ACQUIRED =65;
	    STR_ACQUIRED =65;
	    LUK_ACQUIRED =65;
	    
	    escape = 20;//閃避綠
		boom = 20;//報及綠
		BoomAttackRate=0.3;//抱傷
		Hit = 30; //命中
		
		HP+=800;//生命
		MP+=500;//魔力
		STR+=60;//力量
		INT+=60;//智慧
		LUK+=60;//幸運
		AGI+=60;//敏捷
		sellPrice =500000;
		buyPrice =5000000;
		dropChance=2;
	}

}
