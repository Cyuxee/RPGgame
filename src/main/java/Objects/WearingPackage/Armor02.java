package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor02 extends Objects{
	public Armor02(Players player) {
		super(player);
		ID = 40009;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "冒險者鎧甲";
		Note = "冒險者常穿的鎧甲";
		Image = makeBG("/Images/盔甲02.png");
		strength = 0;//強化等級
		Armor=35;//護甲值
		LV_ACQUIRED = 17;//等級限制
		AGI_ACQUIRED =28;
	    INT_ACQUIRED =15;
	    STR_ACQUIRED =19;
	    LUK_ACQUIRED =26;
	    
	    escape = 2;//閃避綠
		boom =2;//報及綠
		BoomAttackRate=0.05;//抱傷
		Hit = 3; //命中
		
		HP+=105;//生命
		MP+=57;//魔力
		STR+=7;//力量
		INT+=9;//智慧
		LUK+=8;//幸運
		AGI+=9;//敏捷
		
		sellPrice =500;
		buyPrice =2500;
		dropChance=10;
	}

}
