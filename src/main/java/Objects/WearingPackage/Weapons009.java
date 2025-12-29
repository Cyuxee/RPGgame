package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons009 extends Objects{

	public Weapons009(Players player) {
		super(player);
		ID= 10018;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "不滅";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "深淵長劍";
		Note = "以時空之神意念子構成，極其強大";
		Image = makeBG("/Images/魔杖09.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 90;//等級限制
		
		AGI_ACQUIRED =45;
	    INT_ACQUIRED =250;
	    STR_ACQUIRED =45;
	    LUK_ACQUIRED =45;

	    escape = 0;//閃避綠
		boom =100;//報及綠
		BoomAttackRate=2;//抱傷
		Hit = 100; //命中
		
		
		HP+=500;//生命
		MP+=1500;//魔力
		magicAttack = 1500;
		STR+=80;//力量
		INT+=100;//智慧
		LUK+=80;//幸運
		AGI+=80;//敏捷
		sellPrice =5000000;
		buyPrice =100000000;
		dropChance=1;
	}
}
