package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Weapons extends Objects{

	public Weapons(Players player) {
		super(player);
		ID= 10000;//裝備從4XX開始 武器從1XX開始
		WEARING_TYPE="WEAPON";
		QUALITY = "普通";
		Name = "鐵劍";
		Note = "普通的鐵劍";
		Image = makeBG("/Images/武器64.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 15;//等級限制
		//其他屬性限制 待開發
		escape = 3;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.02;//抱傷
		Hit = 4; //命中
		
		
		HP+=15;//生命
		MP+=8;//魔力
		attack=15;//武器值
		STR+=2;//力量
		INT+=3;//智慧
		LUK+=2;//幸運
		AGI+=4;//敏捷

		dropChance=25;
	}
}
