package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beFired;
import Skills.beIced;

public class MagicBoom extends Skills{
	public MagicBoom(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 6;
		Name = "魔源崩潰";
		Note = "20%給予對方凍結3回合效果,20%給予對方灼燒(倍率1.5)3回合效果,\n給予對方300%物理傷害及300%魔法傷害";
		Damage = 3;//倍率
		isMagic = true;
		isPhysic = true;
		MpCost = 2500;
		skillHit = 9999;
		Cooldown = 5;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=20) {
			System.out.println("成功");
			beFired bf = new beFired();
			bf.setNeedCount(3);
			bf.setRate(1.5);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}if((int)(Math.random()*99)<=20) {
			System.out.println("成功");
			beIced bf = new beIced();
			bf.setNeedCount(3);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}
	}
}
