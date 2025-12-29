package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants08 extends Objects{
	public Pants08(Players player) {
		super(player);
		ID = 40034;
		QUALITY = "傳說";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔源長褲";
		Note = "魔源大陸上最精純之力，堪比神之意念";
		Image = makeBG("/Images/脛甲08.png");
		strength = 0;//強化等級
		Armor=500;//護甲值
		LV_ACQUIRED = 75;//等級限制
		AGI_ACQUIRED =70;
	    INT_ACQUIRED =70;
	    STR_ACQUIRED =70;
	    LUK_ACQUIRED =70;
	    
	    escape = 20;//閃避綠
		boom =20;//報及綠
		BoomAttackRate=0.35;//抱傷
		Hit = 35; //命中
		
		HP+=1000;//生命
		MP+=600;//魔力
		STR+=70;//力量
		INT+=70;//智慧
		LUK+=70;//幸運
		AGI+=70;//敏捷
		
		sellPrice =500000;
		buyPrice =5000000;
		dropChance=2;
	}

}
