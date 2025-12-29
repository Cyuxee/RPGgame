package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor08 extends Objects{
	public Armor08(Players player) {
		super(player);
		ID = 40033;
		QUALITY = "傳說";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔源戰甲";
		Note = "魔源大陸上最精純之力，堪比神之意念";
		Image = makeBG("/Images/盔甲08.png");
		strength = 0;//強化等級
		Armor=800;//護甲值
		LV_ACQUIRED = 77;//等級限制335
		AGI_ACQUIRED =80;
	    INT_ACQUIRED =80;
	    STR_ACQUIRED =80;
	    LUK_ACQUIRED =80;
	    
	    escape = 25;//閃避綠
		boom = 25;//報及綠
		BoomAttackRate=0.5;//抱傷
		Hit = 25; //命中
		
		HP+=2500;//生命
		MP+=800;//魔力
		STR+=80;//力量
		INT+=80;//智慧
		LUK+=80;//幸運
		AGI+=80;//敏捷
		
		sellPrice =500000;
		buyPrice =5000000;
		dropChance=2;
	}

}
