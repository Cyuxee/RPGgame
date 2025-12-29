package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beArmorDebuffed;
import Skills.beFired;
import Skills.beIced;

public class ArmorDownBreak extends Skills{
	public ArmorDownBreak(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 13;
		Name = "破勢擊打";
		Note = "50%給予對方護甲值下降(倍率1.5)效果3回合，並施予250%物理傷害";
		Damage = 2.5;//倍率
		isMagic = false;
		isPhysic = true;
		MpCost = 150;
		skillHit = 9999;
		Cooldown = 3;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=49) {
			System.out.println("成功");
			beArmorDebuffed bf = new beArmorDebuffed();
			bf.setNeedCount(3);
			bf.setRate(1.5);
			bf.statusRefresh(mob);
			if(bf.isStatusExist(mob)==-1) {
				mob.getBuffs().add(bf);
			}
		}
	}
}
