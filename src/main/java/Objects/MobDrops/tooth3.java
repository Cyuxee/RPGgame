package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class tooth3 extends Objects{

	public tooth3(Players player) {
		super(player);
		ID=502;//素材從500開始
		Image = makeBG("/Images/魔源核心64.png");
		QUALITY="傳說";
		Name="魔源核心(大)";
		Note="從怪物身上獲得魔源核心，感覺賣給商人會有不錯的收入";
		sellPrice = 5000;
		Amount = (int)(Math.random()*99)%5+1;
		dropChance = 5;//1-100
	}
	
	
}
