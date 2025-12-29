package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons003 extends Objects{

	public Weapons003(Players player) {
		super(player);
		ID= 10012;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "魔靈長杖";
		Note = "傳說被魔源之靈所寄宿過的杖";
		Image = makeBG("/Images/魔杖03.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 30;//等級限制
		AGI_ACQUIRED =15;
	    INT_ACQUIRED =45;
	    STR_ACQUIRED =15;
	    LUK_ACQUIRED =15;
		escape = 0;//閃避綠
		boom =15;//報及綠
		BoomAttackRate=0.2;//抱傷
		Hit = 15; //命中
		
		
		HP+=45;//生命
		MP+=150;//魔力

		magicAttack = 150;
		STR+=15;//力量
		INT+=20;//智慧
		LUK+=15;//幸運
		AGI+=15;//敏捷
		sellPrice =6000;
		buyPrice =30000;
		dropChance=15;
	}
}
