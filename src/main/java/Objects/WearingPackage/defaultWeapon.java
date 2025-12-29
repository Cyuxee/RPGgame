package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class defaultWeapon extends Objects{//預設裝備
	public defaultWeapon(Players player) {
		super(player);
		ID = 1000;
		WEARING_TYPE="WEAPON";
		Name = "尚未裝備!";
		Note = "";
		Image = makeBG("/Images/裝備預設0.png");
		strength = 0;//強化等級
		LV_ACQUIRED = 0;//等級限制
		AGI_ACQUIRED =0;
		HP+=0;//生命
		MP+=0;//魔力
		Armor=0;//護甲值
		STR+=0;//力量
		INT+=0;//智慧
		LUK+=0;//幸運
		AGI+=0;//敏捷
	}

}
