package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import Skills.*;

public class GodBody extends Skills{
	public GodBody(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 5;
		Name = "神體御勢";
		Note = "100%給予自身所有正面增益(倍率5倍)5回合";
		Damage = 2;//倍率
		isMyself = true;

		MpCost = 2000;
		skillHit = 9999;
		Cooldown = 7;
	}
	@Override
	public void getEffect(Players player) {
		System.out.println("成功");
		beMagicDamageBuffed bf = new beMagicDamageBuffed();
		bf.setNeedCount(5);
		bf.setRate(5);
		beArmorBuffed bf2 = new beArmorBuffed();
		bf2.setNeedCount(5);

		bf2.setRate(5);
		beBoomBuffed bf3 = new beBoomBuffed();
		bf3.setRate(5);
		bf3.setNeedCount(5);
		beBoomDamageBuffed bf4 = new beBoomDamageBuffed();
		bf4.setRate(5);
		bf4.setNeedCount(5);
		
		beDamageBuffed bf5 = new beDamageBuffed();
		bf5.setRate(5);
		bf5.setNeedCount(5);
		
		beEscapeBuffed bf6 = new beEscapeBuffed();
		bf6.setRate(5);
		bf6.setNeedCount(5);
		beHitBuffed bf7 = new beHitBuffed();
		bf7.setRate(5);
		bf7.setNeedCount(5);
		
		bf.statusRefresh(player);
		bf2.statusRefresh(player);
		bf3.statusRefresh(player);
		bf4.statusRefresh(player);
		bf5.statusRefresh(player);
		bf6.statusRefresh(player);
		bf7.statusRefresh(player);
		if(bf.isStatusExist(player)==-1) {
			player.getBuffs().add(bf);
		}if(bf2.isStatusExist(player)==-1) {
			player.getBuffs().add(bf2);
		}if(bf3.isStatusExist(player)==-1) {
			player.getBuffs().add(bf3);
		}if(bf4.isStatusExist(player)==-1) {
			player.getBuffs().add(bf4);
		}if(bf5.isStatusExist(player)==-1) {
			player.getBuffs().add(bf5);
		}if(bf6.isStatusExist(player)==-1) {
			player.getBuffs().add(bf6);
		}if(bf7.isStatusExist(player)==-1) {
			player.getBuffs().add(bf7);
		}
	}
	
}
