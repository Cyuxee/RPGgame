package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beArmorDebuffed;
import Skills.beFired;
import Skills.beIced;

public class HealthBreak extends Skills{
	public HealthBreak(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 14;
		Name = "捨命一擊";
		Note = "減去自身30%生命，造成500%物理傷害";
		Damage = 5;//倍率
		isMagic = false;
		isPhysic = true;
		MpCost = 0;
		skillHit = 9999;
		Cooldown = 5;
	}
	@Override
	public void getEffect(Mobs mob) {
			System.out.println("成功");
			player.setHealth((int)(player.getHealth()*0.7));
	}
}
