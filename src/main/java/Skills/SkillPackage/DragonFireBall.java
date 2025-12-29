package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Events.BattleEvent;
import Skills.Skills;
import Skills.beFired;

public class DragonFireBall extends Skills{
	public DragonFireBall(Players player) {
		super(player);
		ID = 2;
		Name = "火龍炎彈";
		Note = "命中有100%讓對方有灼燒，並且施予250%魔法傷害";
		Damage = 2.5;//倍率250%
		MpCost = 150;
		skillHit = 9999;
		Cooldown = 3;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=100) {
			System.out.println("成功");
			beFired bf = new beFired();
			bf.setNeedCount(10);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}
	}
}
