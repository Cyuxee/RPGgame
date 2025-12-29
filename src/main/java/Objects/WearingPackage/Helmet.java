package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Helmet extends Objects{
	public Helmet(Players player) {
		super(player);
		ID = 40000;
		QUALITY = "普通";
		WEARING_TYPE="HELMET";
		Name = "頭盔";
		Note = "普通的頭盔";
		Image = makeBG("/Images/頭盔64.png");
		strength = 0;//強化等級
		Armor=15;//護甲值
		LV_ACQUIRED = 5;//等級限制
		AGI_ACQUIRED =0;
	    INT_ACQUIRED =0;
	    STR_ACQUIRED =0;
	    LUK_ACQUIRED =0;
	    
	    escape = 3;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.02;//抱傷
		Hit = 4; //命中
		
		HP+=35;//生命
		MP+=8;//魔力
		STR+=2;//力量
		INT+=1;//智慧
		LUK+=2;//幸運
		AGI+=3;//敏捷

		dropChance=25;
	}

}
