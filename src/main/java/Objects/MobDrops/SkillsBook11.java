package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook11 extends Objects{//魔源石
	public SkillsBook11(Players player) {
		super(player);
		ID=9903;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="衰弱一擊";
		Note="給予對方所有負面效果(倍率1.5)，並且給予對方75%物理傷害";
		sellPrice = 3000;
		buyPrice = 5000;
		isDiamond = true;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
