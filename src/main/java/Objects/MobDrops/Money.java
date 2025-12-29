package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class Money extends Objects{//魔源石
	public Money(Players player) {
		super(player);
		ID=9998;//素材從500開始
		Image = makeBG("/Images/金幣64.png");
		QUALITY="不滅";
		Name="金幣";
		Note="交易用的錢幣";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
