package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor04 extends Objects{
	public Armor04(Players player) {
		super(player);
		ID = 40017;
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "幽谷鎧甲";
		Note = "微微的靈氣從表面浮出，\n是被谷地源氣所孕育出來的鎧甲";
		Image = makeBG("/Images/盔甲04.png");
		strength = 0;//強化等級
		Armor=135;//護甲值
		LV_ACQUIRED = 37;//等級限制
		AGI_ACQUIRED =38;
	    INT_ACQUIRED =35;
	    STR_ACQUIRED =31;
	    LUK_ACQUIRED =26;
	    
	    escape = 6;//閃避綠
		boom = 6;//報及綠
		BoomAttackRate=0.09;//抱傷
		Hit = 6; //命中
		
		HP+=305;//生命
		MP+=127;//魔力
		STR+=27;//力量
		INT+=25;//智慧
		LUK+=21;//幸運
		AGI+=24;//敏捷
		
		sellPrice =5000;
		buyPrice =25000;
		dropChance=10;
	}

}
