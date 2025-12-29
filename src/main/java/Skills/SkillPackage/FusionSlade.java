package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beFired;
import Skills.beIced;

public class FusionSlade extends Skills{
	public FusionSlade(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 15;
		Name = "融合斬擊";
		Note = "給予對方175%物理傷害以及175%魔法傷害";
		Damage = 1.75;//倍率
		isMagic = true;
		isPhysic = true;
		MpCost = 500;
		skillHit = 9999;
		Cooldown = 5;
	}
	@Override
	public void getEffect(Mobs mob) {
	}
}
