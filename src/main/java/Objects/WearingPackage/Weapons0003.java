package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons0003 extends Objects{

	public Weapons0003(Players player) {
		super(player);
		ID= 10021;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "征服者長劍";
		Note = "曾經征服大陸之人所擁有的長劍，\n表面還散發出魔源氣息(轉蛋獲得)";
		Image = makeBG("/Images/武器05.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 45;//等級限制
		AGI_ACQUIRED =25;
	    INT_ACQUIRED =25;
	    STR_ACQUIRED =65;
	    LUK_ACQUIRED =25;
		escape = 10;//閃避綠
		boom =50;//報及綠
		BoomAttackRate=0.2;//抱傷
		Hit = 50; //命中
		
		
		HP+=250;//生命
		MP+=250;//魔力
		attack = 50;
		STR+=100;//力量
		INT+=20;//智慧
		LUK+=20;//幸運
		AGI+=20;//敏捷
		sellPrice =100;
		buyPrice =500000;
		dropChance=0;
	}
}
