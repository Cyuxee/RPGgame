package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beEscapeDebuffed;
import Skills.beFired;
import Skills.beIced;

public class Scare extends Skills{
	public Scare(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 16;
		Name = "威嚇";
		Note = "100%機率給予對方閃避值下降效果(倍率2)7回合";
		Damage = 0;//倍率
		isMagic = false;
		isPhysic = false;
		MpCost = 300;
		skillHit = 9999;
		Cooldown = 7;
	}
	@Override
	public void getEffect(Mobs mob) {
		beEscapeDebuffed bf = new beEscapeDebuffed();
		bf.setNeedCount(7);
		bf.setRate(2);
		bf.statusRefresh(mob);
		if(bf.isStatusExist(mob)==-1) {
			mob.getBuffs().add(bf);
		}
	}
}
