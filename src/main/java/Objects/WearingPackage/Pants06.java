package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants06 extends Objects{
	public Pants06(Players player) {
		super(player);
		ID = 40026;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "限界長褲";
		Note = "在人魔限界中的征戰與耗損中，\n濃厚的魔源之力所孕育的褲子";
		Image = makeBG("/Images/脛甲06.png");
		strength = 0;//強化等級
		Armor=135;//護甲值
		LV_ACQUIRED = 55;//等級限制
		AGI_ACQUIRED =35;
	    INT_ACQUIRED =38;
	    STR_ACQUIRED =45;
	    LUK_ACQUIRED =44;
	    
	    escape = 6;//閃避綠
		boom =7;//報及綠
		BoomAttackRate=0.12;//抱傷
		Hit = 10; //命中
		
		HP+=283;//生命
		MP+=195;//魔力
		STR+=24;//力量
		INT+=26;//智慧
		LUK+=31;//幸運
		AGI+=26;//敏捷
		
		sellPrice =20000;
		buyPrice =100000;
		dropChance=5;
	}

}
