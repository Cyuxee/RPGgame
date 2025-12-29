package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor06 extends Objects{
	public Armor06(Players player) {
		super(player);
		ID = 40025;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "限界戰甲";
		Note = "在人魔限界中的征戰與耗損中，\n濃厚的魔源之力所孕育的鎧甲";
		Image = makeBG("/Images/盔甲06.png");
		strength = 0;//強化等級
		Armor=265;//護甲值
		LV_ACQUIRED = 57;//等級限制
		AGI_ACQUIRED =58;
	    INT_ACQUIRED =55;
	    STR_ACQUIRED =43;
	    LUK_ACQUIRED =39;
	    
	    escape = 10;//閃避綠
		boom = 10;//報及綠
		BoomAttackRate=0.15;//抱傷
		Hit = 10; //命中
		
		HP+=505;//生命
		MP+=207;//魔力
		STR+=47;//力量
		INT+=39;//智慧
		LUK+=38;//幸運
		AGI+=44;//敏捷
		
		sellPrice =20000;
		buyPrice =100000;
		dropChance=5;
	}

}
