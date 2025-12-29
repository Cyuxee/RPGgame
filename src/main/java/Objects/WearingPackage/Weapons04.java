package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons04 extends Objects{

	public Weapons04(Players player) {
		super(player);
		ID= 10004;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
						 //灰色 白色 綠色 藍色 紫色 橘色 黑色	
		Name = "幽谷長劍";
		Note = "微微的靈氣從表面浮出，\\n是被谷地源氣所孕育出來的劍";
		Image = makeBG("/Images/武器04.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 40;//等級限制
		AGI_ACQUIRED =20;
	    INT_ACQUIRED =20;
	    STR_ACQUIRED =60;
	    LUK_ACQUIRED =20;
	    escape = 0;//閃避綠
		boom =20;//報及綠
		BoomAttackRate=0.3;//抱傷
		Hit = 20; //命中
		
		
		HP+=60;//生命
		MP+=60;//魔力
		attack=90;//武器值
		STR+=20;//力量
		INT+=20;//智慧
		LUK+=20;//幸運
		AGI+=20;//敏捷
		sellPrice =10000;
		buyPrice =50000;
		dropChance=10;
	}
}
