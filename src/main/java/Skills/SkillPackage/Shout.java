package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.beDamageBuffed;
import Skills.*;

public class Shout extends Skills{
	public Shout(Players player) {
		super(player);
		ID = 11;
		Name = "吼叫";
		Note = "100%機率得到物理傷害(倍率1.5)增益7回合";
		Damage = 1;
		MpCost = 100;
		skillHit = 9999;
		Cooldown = 7;
		isMyself = true;
	}
	@Override
	public void getEffect(Players player) {
			System.out.println("成功");
			beDamageBuffed bf = new beDamageBuffed();
			bf.setNeedCount(7);
			bf.statusRefresh(player);
			if(bf.isStatusExist(player)==-1) {
				player.getBuffs().add(bf);
			}
		}
}
