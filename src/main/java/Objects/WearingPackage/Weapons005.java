package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons005 extends Objects{

	public Weapons005(Players player) {
		super(player);
		ID= 10014;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "稀有";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "無回長杖";
		Note = "從無回境地回來的人所被賦予的杖";
		Image = makeBG("/Images/魔杖05.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 50;//等級限制
		AGI_ACQUIRED =25;
	    INT_ACQUIRED =75;
	    STR_ACQUIRED =25;
	    LUK_ACQUIRED =25;
		escape = 0;//閃避綠
		boom =25;//報及綠
		BoomAttackRate=0.4;//抱傷
		Hit = 25; //命中
		
		
		HP+=75;//生命
		MP+=250;//魔力
		magicAttack = 250;
		STR+=25;//力量
		INT+=30;//智慧
		LUK+=25;//幸運
		AGI+=25;//敏捷
		sellPrice =50000;
		buyPrice =250000;
		dropChance=10;
	}
}
