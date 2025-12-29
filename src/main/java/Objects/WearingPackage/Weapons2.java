package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;

public class Weapons2 extends Objects{

	public Weapons2(Players player) {
			super(player);
			ID= 30000;//裝備從40000開始 武器從10000開始
			WEARING_TYPE="WEAPON";
			QUALITY = "不滅";
			Name = "***名門-秋水***";
			Note = "熊瑞閔特別持有，一把日輪刀，\n如秋水般寂靜卻又蘊藏風波\n";
			Image = makeBG("/Images/熊熊秋水64.png");
			strength = 15;//強化等級
			LV_ACQUIRED = 0;//等級限制
			//其他屬性限制 待開發
			HP+=99999;//生命
			MP+=99999;//魔力
			attack=99999;//武器值
			Hit=100;
			escape=100;
			boom=100;
			BoomAttackRate=10000;
			STR+=9999;//力量
			INT+=9999;//智慧
			LUK+=9999;//幸運
			AGI+=9999;//敏捷
			dropChance = 1;
		}
}
