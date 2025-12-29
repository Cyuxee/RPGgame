package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons006 extends Objects{

	public Weapons006(Players player) {
		super(player);
		ID= 10015;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "限界長杖";
		Note = "在人魔限界中的征戰與耗損中，\n濃厚的魔源之力所孕育的杖";
		Image = makeBG("/Images/魔杖06.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 60;//等級限制
		AGI_ACQUIRED =30;
	    INT_ACQUIRED =90;
	    STR_ACQUIRED =30;
	    LUK_ACQUIRED =30;
		escape = 0;//閃避綠
		boom =30;//報及綠
		BoomAttackRate=0.5;//抱傷
		Hit = 30; //命中
		
		
		HP+=90;//生命
		MP+=300;//魔力
		magicAttack = 300;
		STR+=30;//力量
		INT+=35;//智慧
		LUK+=30;//幸運
		AGI+=30;//敏捷
		sellPrice =50000;
		buyPrice =250000;
		dropChance=5;
	}
}
