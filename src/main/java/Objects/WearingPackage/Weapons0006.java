package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0006 extends Objects{

	public Weapons0006(Players player) {
		super(player);
		ID= 10024;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "史詩";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "八邪魔杖";
		Note = "前魔王的所持有之物(轉蛋獲得)";
		Image = makeBG("/Images/魔杖10.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 70;//等級限制
		AGI_ACQUIRED =35;
	    INT_ACQUIRED =200;
	    STR_ACQUIRED =35;
	    LUK_ACQUIRED =35;
		escape = 30;//閃避綠
		boom =80;//報及綠
		BoomAttackRate=1.5;//抱傷
		Hit = 80; //命中
		
		
		HP+=800;//生命
		MP+=800;//魔力
		magicAttack = 250;
		STR+=45;//力量
		INT+=200;//智慧
		LUK+=45;//幸運
		AGI+=45;//敏捷
		sellPrice =100;
		buyPrice =7500000;
		dropChance=0;
	}
}
