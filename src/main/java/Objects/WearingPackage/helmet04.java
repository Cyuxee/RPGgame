package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet04 extends Objects{
	public helmet04(Players player) {
		super(player);
		ID = 40016;
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "幽谷頭盔";
		Note = "微微的靈氣從表面浮出，\n是被谷地源氣所孕育出來的頭盔";
		Image = makeBG("/Images/頭盔04.png");
		strength = 0;//強化等級
		Armor=58;//護甲值
		LV_ACQUIRED = 33;//等級限制
		AGI_ACQUIRED =34;
	    INT_ACQUIRED =25;
	    STR_ACQUIRED =29;
	    LUK_ACQUIRED =28;
	    
	    escape = 4;//閃避綠
		boom =4;//報及綠
		BoomAttackRate=0.07;//抱傷
		Hit = 7; //命中
		
		HP+=167;//生命
		MP+=122;//魔力
		STR+=15;//力量
		INT+=15;//智慧
		LUK+=12;//幸運
		AGI+=13;//敏捷
		sellPrice =5000;
		buyPrice =25000;
		dropChance=10;
	}

}
