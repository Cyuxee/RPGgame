package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;

public class Pants extends Objects{
	public Pants(Players player) {
		super(player);
		ID=40002;
		WEARING_TYPE="PANTS";
		QUALITY = "史詩";
		Name = "褲子";
		Note = "普通的護甲";
		Image = makeBG("/Images/褲子64.jpg");
		strength = 0;//強化等級
		LV_ACQUIRED = 10;//等級限制
		INT_ACQUIRED = 0;
		
		escape = 3;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.02;//抱傷
		Hit = 4; //命中
		
		
		HP+=25;//生命
		MP+=8;//魔力
		Armor=25;//護甲值
		STR+=2;//力量
		INT+=3;//智慧
		LUK+=2;//幸運
		AGI+=4;//敏捷
		dropChance=25;
	}

}
