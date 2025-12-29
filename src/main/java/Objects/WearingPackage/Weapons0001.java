package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0001 extends Objects{

	public Weapons0001(Players player) {
		super(player);
		ID= 10019;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "征服者長杖";
		Note = "曾經征服大陸之人所擁有的長杖，\n表面還散發出魔源氣息(轉蛋獲得)";
		Image = makeBG("/Images/魔杖05.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 45;//等級限制
		AGI_ACQUIRED =25;
	    INT_ACQUIRED =65;
	    STR_ACQUIRED =25;
	    LUK_ACQUIRED =25;
		escape = 10;//閃避綠
		boom =50;//報及綠
		BoomAttackRate=0.2;//抱傷
		Hit = 50; //命中
		
		
		HP+=250;//生命
		MP+=250;//魔力
		magicAttack = 50;
		STR+=20;//力量
		INT+=100;//智慧
		LUK+=20;//幸運
		AGI+=20;//敏捷
		sellPrice =100;
		buyPrice =500000;
		dropChance=0;
	}
}
