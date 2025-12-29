package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet07 extends Objects{
	public helmet07(Players player) {
		super(player);
		ID = 40028;
		QUALITY = "史詩";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "龍魂頭盔";
		Note = "被龍所認可的人啊，\n龍魂之力將會永遠庇護著你...";
		Image = makeBG("/Images/頭盔07.png");
		strength = 0;//強化等級
		Armor=200;//護甲值
		LV_ACQUIRED = 63;//等級限制
		AGI_ACQUIRED =60;
	    INT_ACQUIRED =60;
	    STR_ACQUIRED =60;
	    LUK_ACQUIRED =60;
	    
	    escape = 10;//閃避綠
		boom = 10;//報及綠
		BoomAttackRate=0.15;//抱傷
		Hit = 15; //命中
		
		HP+=500;//生命
		MP+=250;//魔力
		STR+=50;//力量
		INT+=50;//智慧
		LUK+=50;//幸運
		AGI+=50;//敏捷
		sellPrice =100000;
		buyPrice =1000000;
		dropChance=3;
	}

}
