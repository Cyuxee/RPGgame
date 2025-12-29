package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beEscapeDebuffed;
import Skills.beFired;
import Skills.beIced;
import Skills.*;

public class MagicSlade extends Skills{
	public MagicSlade(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 21;
		Name = "魔源斬";
		Note = "給予對方225%物理傷害以及225%魔法傷害";
		Damage = 2.25;//倍率
		isMagic = true;
		isPhysic = true;
		MpCost = 1000;
		skillHit = 9999;
		Cooldown = 7;
	}
	@Override
	public void getEffect(Players player) {
		 
	}
}
