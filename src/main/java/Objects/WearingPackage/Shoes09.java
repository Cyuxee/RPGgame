package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes09 extends Objects{
	public Shoes09(Players player) {
		super(player);
		ID = 40039;
		QUALITY = "不滅";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "深淵戰靴";
		Note = "以時空之神意念子構成，極其強大";
		Image = makeBG("/Images/長靴09.png");
		strength = 0;//強化等級
		Armor=800;//護甲值
		LV_ACQUIRED = 84;//等級限制
		AGI_ACQUIRED =100;
	    INT_ACQUIRED =100;
	    STR_ACQUIRED =100;
	    LUK_ACQUIRED =100;
	    
	    escape = 50;//閃避綠
		boom =50;//報及綠
		BoomAttackRate=1;//抱傷
		Hit = 50; //命中
		
		HP+=1200;//生命
		MP+=900;//魔力
		STR+=130;//力量
		INT+=130;//智慧
		LUK+=130;//幸運
		AGI+=130;//敏捷
		
		sellPrice =1000000;
		buyPrice =100000000;
		dropChance=1;
	}

}
