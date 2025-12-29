package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Events.BattleEvent;
import Skills.Skills;
import Skills.beFired;

public class DoubleHit extends Skills{
	public DoubleHit(Players player) {
		super(player);
		ID = 9;
		Name = "雙倍打擊";
		Note = "給予對方200%物理傷害";
		Damage = 2;//倍率250%
		isPhysic = true;
		isMagic = false;
		MpCost = 50;
		skillHit = 9999;
		Cooldown = 1;
	}
	@Override
	public void getEffect(Mobs mob) {
	}
}
