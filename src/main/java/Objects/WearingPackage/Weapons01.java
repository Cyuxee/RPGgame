package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons01 extends Objects{

	public Weapons01(Players player) {
		super(player);
		ID= 10001;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "粗劣";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "粗製鐵劍";
		Note = "做工粗劣的鐵劍";
		Image = makeBG("/Images/武器01.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 10;//等級限制
		
		AGI_ACQUIRED =5;
	    INT_ACQUIRED =5;
	    STR_ACQUIRED =15;
	    LUK_ACQUIRED =5;

	    escape = 0;//閃避綠
		boom =5;//報及綠
		BoomAttackRate=0.05;//抱傷
		Hit = 5; //命中
		
		
		HP+=15;//生命
		MP+=15;//魔力
		attack=25;//武器值
		STR+=5;//力量
		INT+=5;//智慧
		LUK+=5;//幸運
		AGI+=5;//敏捷
		sellPrice =500;
		buyPrice =2500;
		dropChance=25;
	}
}
