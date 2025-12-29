package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class tooth4 extends Objects{

	public tooth4(Players player) {
		super(player);
		ID=503;//素材從500開始
		Image = makeBG("/Images/魔源王核64.png");
		QUALITY="不滅";
		Name="魔源王核";
		Note="由魔王孕育而出的核心，蘊含十分強大的力量";
		sellPrice = 50000;
		Amount = 1;
		dropChance = 100;//1-100
	}
	
	
}
