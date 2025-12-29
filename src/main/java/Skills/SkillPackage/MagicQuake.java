package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beFired;
import Skills.beIced;

public class MagicQuake extends Skills{
	public MagicQuake(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 12;
		Name = "魔源震盪";
		Note = " 5%給予對方凍結1回合效果,5%給予對方灼燒(倍率1.5)1回合效果,\n給予對方180%魔法傷害";
		Damage = 1.8;//倍率
		isMagic = true;
		isPhysic = false;
		MpCost = 500;
		skillHit = 9999;
		Cooldown = 3;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=5) {
			System.out.println("成功");
			beFired bf = new beFired();
			bf.setNeedCount(1);
			bf.setRate(1.5);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}if((int)(Math.random()*99)<=5) {
			System.out.println("成功");
			beIced bf = new beIced();
			bf.setNeedCount(1);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}
	}
}
