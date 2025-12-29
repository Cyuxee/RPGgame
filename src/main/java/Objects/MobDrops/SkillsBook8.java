package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook8 extends Objects{//魔源石
	public SkillsBook8(Players player) {
		super(player);
		ID=9900;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="元素操作";
		Note="提升自身魔法傷害(倍率1.5)增益7回合";
		isDiamond = true;
		sellPrice = 500;
		buyPrice = 1000;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
