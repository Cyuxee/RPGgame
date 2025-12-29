package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes04 extends Objects{
	public Shoes04(Players player) {
		super(player);
		ID = 40019;
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "幽谷短靴";
		Note = "微微的靈氣從表面浮出，\n是被谷地源氣所孕育出來的靴子";
		Image = makeBG("/Images/長靴04.png");
		strength = 0;//強化等級
		Armor=49;//護甲值
		LV_ACQUIRED = 34;//等級限制
		AGI_ACQUIRED =18;
	    INT_ACQUIRED =15;
	    STR_ACQUIRED =21;
	    LUK_ACQUIRED =19;
	    
	    escape = 3;//閃避綠
		boom =4;//報及綠
		BoomAttackRate=0.06;//抱傷
		Hit = 4; //命中
		
		HP+=167;//生命
		MP+=128;//魔力
		STR+=18;//力量
		INT+=14;//智慧
		LUK+=17;//幸運
		AGI+=12;//敏捷
		
		sellPrice =5000;
		buyPrice =25000;
		dropChance=10;
	}

}
