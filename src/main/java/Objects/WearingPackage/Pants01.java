package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants01 extends Objects{
	public Pants01(Players player) {
		super(player);
		ID = 40006;
		QUALITY = "粗劣";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "粗製皮褲";
		Note = "做工粗劣的皮褲";
		Image = makeBG("/Images/脛甲01.png");
		strength = 0;//強化等級
		Armor=9;//護甲值
		LV_ACQUIRED = 5;//等級限制
		AGI_ACQUIRED =6;
	    INT_ACQUIRED =4;
	    STR_ACQUIRED =8;
	    LUK_ACQUIRED =4;
	    
	    escape = 1;//閃避綠
		boom =1;//報及綠
		BoomAttackRate=0.02;//抱傷
		Hit = 1; //命中
		
		HP+=23;//生命
		MP+=15;//魔力
		STR+=2;//力量
		INT+=4;//智慧
		LUK+=4;//幸運
		AGI+=3;//敏捷
		
		sellPrice =100;
		buyPrice =500;
		dropChance=10;
	}

}
