package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Events.BattleEvent;
import Skills.Skills;
import Skills.beFired;

public class Explosive extends Skills{
	public Explosive(Players player) {
		super(player);
		ID = 10;
		Name = "元素爆發";
		Note = "給予對方200%魔法傷害";
		Damage = 2;//倍率250%
		isPhysic = false;
		isMagic = true;
		MpCost = 150;
		skillHit = 9999;
		Cooldown = 1;
	}
	@Override
	public void getEffect(Mobs mob) {
	}
}
