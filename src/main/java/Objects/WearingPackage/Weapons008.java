package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons008 extends Objects{

	public Weapons008(Players player) {
		super(player);
		ID= 10017;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "傳說";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "魔源長杖";
		Note = "魔源大陸上最精純之力，堪比神之意念";
		Image = makeBG("/Images/魔杖08.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 80;//等級限制
		AGI_ACQUIRED =40;
	    INT_ACQUIRED =200;
	    STR_ACQUIRED =40;
	    LUK_ACQUIRED =40;
		escape = 0;//閃避綠
		boom =75;//報及綠
		BoomAttackRate=1;//抱傷
		Hit = 75; //命中
		
		
		HP+=250;//生命
		MP+=1000;//魔力
		magicAttack = 800;
		STR+=60;//力量
		INT+=65;//智慧
		LUK+=60;//幸運
		AGI+=60;//敏捷
		sellPrice =1500000;
		buyPrice =7500000;
		dropChance=2;
	}
}
