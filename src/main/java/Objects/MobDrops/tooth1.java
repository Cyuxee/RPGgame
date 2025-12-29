package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class tooth1 extends Objects{

	public tooth1(Players player) {
		super(player);
		ID=500;//素材從500開始
		Image = makeBG("/Images/魔源核心64.png");
		QUALITY="普通";
		Name="魔源核心(小)";
		Note="從怪物身上獲得魔源核心，感覺賣給商人會有不錯的收入";
		sellPrice = 50;
		Amount = (int)(Math.random()*99)%5+1;
		dropChance = 30;//1-100
	}
	
	
}
