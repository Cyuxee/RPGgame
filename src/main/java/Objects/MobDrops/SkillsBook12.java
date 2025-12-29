package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook12 extends Objects{//魔源石
	public SkillsBook12(Players player) {
		super(player);
		ID=9904;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="圓舞流歌";
		Note="獲得提升閃避、治癒、暴傷效果(倍率2)，並且給予對方375%物理傷害";
		sellPrice = 8000;
		buyPrice = 10000;
		isDiamond = true;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
