package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook2 extends Objects{//魔源石
	public SkillsBook2(Players player) {
		super(player);
		ID=9996;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="元素爆發";
		Note="給予對方魔法雙倍打擊";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
