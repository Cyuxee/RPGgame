package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook10 extends Objects{//魔源石
	public SkillsBook10(Players player) {
		super(player);
		ID=9902;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="魔源斬";
		Note="給予對方225%物理傷害以及225%魔法傷害";
		sellPrice = 3000;
		buyPrice = 5000;
		isDiamond = true;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
