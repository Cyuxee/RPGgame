package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0011 extends Objects{

	public Weapons0011(Players player) {
		super(player);
		ID= 10029;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "傳說";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "屠龍者之魂(劍)";
		Note = "曾經殺伐過無數龍族之人所幻化之物(轉蛋獲得)";
		Image = makeBG("/Images/武器08.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 80;//等級限制
		AGI_ACQUIRED =40;
	    INT_ACQUIRED =40;
	    STR_ACQUIRED =250;
	    LUK_ACQUIRED =40;
		escape = 40;//閃避綠
		boom =100;//報及綠
		BoomAttackRate=2;//抱傷
		Hit = 100; //命中
		
		
		HP+=1200;//生命
		MP+=1200;//魔力
		attack = 200;
		STR+=250;//力量
		INT+=60;//智慧
		LUK+=60;//幸運
		AGI+=60;//敏捷
		sellPrice =100;
		buyPrice =7500000;
		dropChance=0;
	}
}
