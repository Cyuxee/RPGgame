package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor01 extends Objects{
	public Armor01(Players player) {
		super(player);
		ID = 40005;
		QUALITY = "粗劣";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "粗製皮衣";
		Note = "做工粗劣的皮衣";
		Image = makeBG("/Images/盔甲01.png");
		strength = 0;//強化等級
		Armor=15;//護甲值
		LV_ACQUIRED = 7;//等級限制
		AGI_ACQUIRED =8;
	    INT_ACQUIRED =5;
	    STR_ACQUIRED =9;
	    LUK_ACQUIRED =6;
	    
	    escape = 1;//閃避綠
		boom =1;//報及綠
		BoomAttackRate=0.03;//抱傷
		Hit = 2; //命中
		
		HP+=35;//生命
		MP+=25;//魔力
		STR+=3;//力量
		INT+=2;//智慧
		LUK+=4;//幸運
		AGI+=3;//敏捷
		
		sellPrice =100;
		buyPrice =500;
		dropChance=10;
	}

}
