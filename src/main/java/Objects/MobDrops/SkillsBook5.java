package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook5 extends Objects{//魔源石
	public SkillsBook5(Players player) {
		super(player);
		ID=9993;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="降維限界";
		Note="100%給予對方所有負面效果(除了凍結和灼燒)，倍率皆為2";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
