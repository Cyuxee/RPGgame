package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beFired;
import Skills.beIced;

public class BigIce extends Skills{
	public BigIce(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 4;
		Name = "大凍結術";
		Note = "30%給予對方凍結3回合效果,並且施予對方225%魔法攻擊傷害";
		Damage = 2.25;//倍率
		
		MpCost = 100;
		skillHit = 9999;
		Cooldown = 3;
	}
	@Override
	public void getEffect(Mobs mob) {
		if((int)(Math.random()*99)<=30) {
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
