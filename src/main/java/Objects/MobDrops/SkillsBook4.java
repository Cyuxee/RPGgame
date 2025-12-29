package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook4 extends Objects{//魔源石
	public SkillsBook4(Players player) {
		super(player);
		ID=9994;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="炎王破";
		Note="50%給予對方燃燒3回合效果,燃燒倍率1.25，給予對方物理打擊*275%";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
