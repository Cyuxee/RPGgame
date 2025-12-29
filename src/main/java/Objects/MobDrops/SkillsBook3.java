package Objects.MobDrops;

import Entities.Players;
import Objects.Objects;

public class SkillsBook3 extends Objects{//魔源石
	public SkillsBook3(Players player) {
		super(player);
		ID=9995;//素材從500開始
		Image = makeBG("/Images/技能書.png");
		QUALITY="不滅";
		Name="大凍結術";
		Note="30%給予對方凍結3回合效果,並且施予對方225%魔法攻擊傷害";
		sellPrice = 0;
		buyPrice = 100;
		Amount = 1;
		dropChance = 0;//1-100
	}
}
