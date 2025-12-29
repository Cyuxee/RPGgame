package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons002 extends Objects{

	public Weapons002(Players player) {
		super(player);
		ID= 10011;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "冒險者魔杖";
		Note = "冒險者常用的魔杖";
		Image = makeBG("/Images/魔杖02.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 20;//等級限制
		AGI_ACQUIRED =10;
	    INT_ACQUIRED =30;
	    STR_ACQUIRED =10;
	    LUK_ACQUIRED =10;
		escape = 0;//閃避綠
		boom =10;//報及綠
		BoomAttackRate=0.1;//抱傷
		Hit = 10; //命中
		
		
		HP+=30;//生命
		MP+=100;//魔力

		magicAttack = 100;
		STR+=10;//力量
		INT+=15;//智慧
		LUK+=10;//幸運
		AGI+=10;//敏捷
		sellPrice =1000;
		buyPrice =5000;
		dropChance=15;
	}
}
