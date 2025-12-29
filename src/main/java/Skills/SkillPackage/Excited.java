package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beFired;
import Skills.beMagicDamageBuffed;

public class Excited extends Skills{
	public Excited(Players player) {
		super(player);
		ID = 3;
		Name = "振奮";
		Note = "讓自身魔法傷害提高";
		Damage = 1;
		MpCost = 150;
		skillHit = 9999;
		Cooldown = 3;
		isMyself = true;
	}
	@Override
	public void getEffect(Players player) {
		if((int)(Math.random()*99)<=100) {
			System.out.println("成功");
			beMagicDamageBuffed bf = new beMagicDamageBuffed();
			bf.setNeedCount(10);
			bf.statusRefresh(player);
			if(bf.isStatusExist(player)==-1) {
				player.getBuffs().add(bf);
			}
		}
	}
}
