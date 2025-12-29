package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.*;

public class MaxLow extends Skills{
	public MaxLow(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 7;
		Name = "降維限界";
		Note = "100%給予對方所有負面(倍率為2)效果5回合(除了凍結和灼燒)";
		Damage = 1;//倍率
		isMagic = false;
		isPhysic = false;
		MpCost = 2500;
		skillHit = 9999;
		Cooldown = 5;
	}
	@Override
	public void getEffect(Mobs mob) {
		beArmorDebuffed bf = new beArmorDebuffed();
		bf.setRate(0.5);
		bf.setNeedCount(5);
		beDamageDebuffed bf2 = new beDamageDebuffed();
		bf2.setRate(0.5);
		bf2.setNeedCount(5);
		beEscapeDebuffed bf3 = new beEscapeDebuffed();
		bf3.setRate(0.5);
		bf3.setNeedCount(5);
		bf.statusRefresh(mob);
		bf2.statusRefresh(mob);
		bf3.statusRefresh(mob);
		if(bf.isStatusExist(mob)==-1) {
			mob.getBuffs().add(bf);
		}if(bf2.isStatusExist(mob)==-1) {
			mob.getBuffs().add(bf2);
		}if(bf3.isStatusExist(mob)==-1) {
			mob.getBuffs().add(bf3);
		}
	}
}
