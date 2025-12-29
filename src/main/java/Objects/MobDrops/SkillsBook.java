package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook extends Objects{//魔源石
	public SkillsBook(Players player) {
		super(player);
		ID=9997;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="雙倍打擊";
		Note="給予對方物理雙倍打擊";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
