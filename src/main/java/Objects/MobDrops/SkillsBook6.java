package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook6 extends Objects{//魔源石
	public SkillsBook6(Players player) {
		super(player);
		ID=9992;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="神體御勢";
		Note="100%給予自身所有正面buff 5回合";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
