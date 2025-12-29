package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class tooth2 extends Objects{

	public tooth2(Players player) {
		super(player);
		ID=501;//素材從500開始
		Image = makeBG("/Images/魔源核心64.png");
		QUALITY="稀有";
		Name="魔源核心(中)";
		Note="從怪物身上獲得魔源核心，感覺賣給商人會有不錯的收入";
		sellPrice = 500;
		Amount = (int)(Math.random()*99)%5+1;
		dropChance = 10;//1-100
	}
	
	
}
