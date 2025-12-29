package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0004 extends Objects{

	public Weapons0004(Players player) {
		super(player);
		ID= 10022;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "初心者長劍";
		Note = "初心者最愛用的長劍(轉蛋獲得)";
		Image = makeBG("/Images/武器03.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 35;//等級限制
		AGI_ACQUIRED =15;
	    INT_ACQUIRED =15;
	    STR_ACQUIRED =50;
	    LUK_ACQUIRED =15;
		escape = 5;//閃避綠
		boom =30;//報及綠
		BoomAttackRate=0.5;//抱傷
		Hit = 30; //命中
		
		
		HP+=200;//生命
		MP+=200;//魔力

		attack = 25;
		STR+=50;//力量
		INT+=15;//智慧
		LUK+=15;//幸運
		AGI+=15;//敏捷
		sellPrice =100;
		buyPrice =500000;
		dropChance=0;
	}
}
