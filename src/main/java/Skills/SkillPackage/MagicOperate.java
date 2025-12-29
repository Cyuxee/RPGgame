package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beEscapeDebuffed;
import Skills.beFired;
import Skills.beIced;
import Skills.*;

public class MagicOperate extends Skills{
	public MagicOperate(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 17;
		Name = "魔源操作";
		Note = "提升自身魔法傷害(倍率2.5)增益7回合";
		Damage = 0;//倍率
		isMyself = true;
		isMagic = false;
		isPhysic = false;
		MpCost = 500;
		skillHit = 9999;
		Cooldown = 7;
	}
	@Override
	public void getEffect(Players player) {
		beMagicDamageBuffed bf = new beMagicDamageBuffed();
		bf.setNeedCount(7);
		bf.setRate(2.5);
		bf.statusRefresh(player);
		if(bf.isStatusExist(player)==-1) {
			player.getBuffs().add(bf);
		}
	}
}
