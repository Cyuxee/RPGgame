package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Events.BattleEvent;
import Skills.Skills;
import Skills.beFired;

public class FireBreak extends Skills{
	public FireBreak(Players player) {
		super(player);
		ID = 8;
		Name = "炎王破";
		Note = "70%給予對方燃燒(倍率1.5)3回合效果,\n並給予對方275%物理傷害";
		Damage = 2.75;//倍率250%
		isPhysic = true;
		isMagic = false;
		MpCost = 750;
		skillHit = 9999;
		Cooldown = 3;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=70) {
			System.out.println("成功");
			beFired bf = new beFired();
			bf.setRate(1.5);
			bf.setNeedCount(3);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}
	}
}
