package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0005 extends Objects{

	public Weapons0005(Players player) {
		super(player);
		ID= 10023;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "無回境之魔杖";
		Note = "無回之地深處的守護者所賜予之物(轉蛋獲得)";
		Image = makeBG("/Images/魔杖06.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 60;//等級限制
		AGI_ACQUIRED =30;
	    INT_ACQUIRED =150;
	    STR_ACQUIRED =30;
	    LUK_ACQUIRED =30;
		escape = 20;//閃避綠
		boom =60;//報及綠
		BoomAttackRate=1;//抱傷
		Hit = 60; //命中
		
		
		HP+=300;//生命
		MP+=300;//魔力
		magicAttack = 100;
		STR+=30;//力量
		INT+=150;//智慧
		LUK+=30;//幸運
		AGI+=30;//敏捷
		sellPrice =100;
		buyPrice =250000;
		dropChance=0;
	}
}
