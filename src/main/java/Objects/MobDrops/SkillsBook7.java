package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook7 extends Objects{//魔源石
	public SkillsBook7(Players player) {
		super(player);
		ID=9991;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="魔源崩塌";
		Note="20%給予對方凍結3回合效果,20%給予對方灼燒3回合效果,\n給予對方3倍物理打擊及3倍魔法打擊";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
