package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0010 extends Objects{

	public Weapons0010(Players player) {
		super(player);
		ID= 10028;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "不滅";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "深淵之怒-杖之化形";
		Note = "時空深淵最深沉意念，因被喚醒而憤怒著(轉蛋獲得)";
		Image = makeBG("/Images/魔杖09.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 90;//等級限制
		
		AGI_ACQUIRED =45;
	    INT_ACQUIRED =300;
	    STR_ACQUIRED =45;
	    LUK_ACQUIRED =45;

	    escape = 50;//閃避綠
		boom =150;//報及綠
		BoomAttackRate=3;//抱傷
		Hit = 150; //命中
		
		
		HP+=2000;//生命
		MP+=2000;//魔力
		magicAttack = 1000;
		STR+=80;//力量
		INT+=300;//智慧
		LUK+=80;//幸運
		AGI+=80;//敏捷
		sellPrice =100;
		buyPrice =100000000;
		dropChance=0;
	}
}
