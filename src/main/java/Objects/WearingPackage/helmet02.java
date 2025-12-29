package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet02 extends Objects{
	public helmet02(Players player) {
		super(player);
		ID = 40008;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "冒險者頭盔";
		Note = "冒險者常戴的頭盔";
		Image = makeBG("/Images/頭盔02.png");
		strength = 0;//強化等級
		Armor=18;//護甲值
		LV_ACQUIRED = 13;//等級限制
		AGI_ACQUIRED =8;
	    INT_ACQUIRED =10;
	    STR_ACQUIRED =13;
	    LUK_ACQUIRED =10;
	    
	    escape = 2;//閃避綠
		boom =2;//報及綠
		BoomAttackRate=0.03;//抱傷
		Hit = 5; //命中
		
		HP+=67;//生命
		MP+=32;//魔力
		STR+=5;//力量
		INT+=6;//智慧
		LUK+=7;//幸運
		AGI+=8;//敏捷
		sellPrice =500;
		buyPrice =2500;
		dropChance=10;
	}

}
