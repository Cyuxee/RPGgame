package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class magicStone extends Objects{//魔源石
	public magicStone(Players player) {
		super(player);
		ID=9999;//素材從500開始
		Image = makeBG("/Images/魔源石64.png");
		QUALITY="不滅";
		Name="魔源石";
		Note="魔源大陸的石頭，極其珍貴";
		sellPrice = 0;
		buyPrice = 100;
		Amount = (int)(Math.random()*99)%5+1;
		dropChance = 0;//1-100
	}
}
