package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook9 extends Objects{//魔源石
	public SkillsBook9(Players player) {
		super(player);
		ID=9901;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="聖體護身";
		Note="獲得提升護甲值、治癒效果(倍率2)增益7回合";
		isDiamond = true;
		sellPrice = 1000;
		buyPrice = 5000;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
