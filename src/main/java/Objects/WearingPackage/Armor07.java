package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Armor07 extends Objects{
	public Armor07(Players player) {
		super(player);
		ID = 40029;
		QUALITY = "史詩";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="ARMOR";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "龍魂鎧甲";
		Note = "被龍所認可的人啊，\n龍魂之力將會永遠庇護著你...";
		Image = makeBG("/Images/盔甲07.png");
		strength = 0;//強化等級
		Armor=305;//護甲值
		LV_ACQUIRED = 67;//等級限制335
		AGI_ACQUIRED =60;
	    INT_ACQUIRED =60;
	    STR_ACQUIRED =80;
	    LUK_ACQUIRED =60;
	    
	    escape = 15;//閃避綠
		boom = 15;//報及綠
		BoomAttackRate=0.3;//抱傷
		Hit = 15; //命中
		
		HP+=1065;//生命
		MP+=450;//魔力
		STR+=65;//力量
		INT+=65;//智慧
		LUK+=65;//幸運
		AGI+=65;//敏捷
		
		sellPrice =100000;
		buyPrice =1000000;
		dropChance=3;
	}

}
