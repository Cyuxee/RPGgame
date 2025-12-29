package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet03 extends Objects{
	public helmet03(Players player) {
		super(player);
		ID = 40012;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔靈頭盔";
		Note = "傳說被魔源之靈所寄宿過的頭盔";
		Image = makeBG("/Images/頭盔03.png");
		strength = 0;//強化等級
		Armor=38;//護甲值
		LV_ACQUIRED = 23;//等級限制
		AGI_ACQUIRED =24;
	    INT_ACQUIRED =19;
	    STR_ACQUIRED =23;
	    LUK_ACQUIRED =23;
	    
	    escape = 3;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.06;//抱傷
		Hit = 6; //命中
		
		HP+=117;//生命
		MP+=82;//魔力
		STR+=12;//力量
		INT+=11;//智慧
		LUK+=7;//幸運
		AGI+=10;//敏捷
		sellPrice =1000;
		buyPrice =5000;
		dropChance=10;
	}

}
