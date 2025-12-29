package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes06 extends Objects{
	public Shoes06(Players player) {
		super(player);
		ID = 40027;
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "限界長靴";
		Note = "在人魔限界中的征戰與耗損中，\n濃厚的魔源之力所孕育的靴子";
		Image = makeBG("/Images/長靴06.png");
		strength = 0;//強化等級
		Armor=89;//護甲值
		LV_ACQUIRED = 54;//等級限制
		AGI_ACQUIRED =32;
	    INT_ACQUIRED =25;
	    STR_ACQUIRED =29;
	    LUK_ACQUIRED =34;
	    
	    escape = 6;//閃避綠
		boom =6;//報及綠
		BoomAttackRate=0.1;//抱傷
		Hit = 8; //命中
		
		HP+=267;//生命
		MP+=228;//魔力
		STR+=25;//力量
		INT+=24;//智慧
		LUK+=26;//幸運
		AGI+=23;//敏捷
		
		sellPrice =20000;
		buyPrice =100000;
		dropChance=5;
	}

}
