package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.*;

public class SwordGod extends Skills{
	public SwordGod(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 18;
		Name = "勇者無敵";
		Note = "獲得提升護甲值、治癒、閃避、命中效果(倍率2.5)各7回合";
		Damage = 0;//倍率
		isMyself = true;
		isMagic = false;
		isPhysic = false;
		MpCost = 5000;
		skillHit = 9999;
		Cooldown = 7;
	}
	@Override
	public void getEffect(Players player) {
		
		beArmorBuffed bf = new beArmorBuffed();
		beHealed bf2 = new beHealed();
		beEscapeBuffed bf3 = new beEscapeBuffed();
		beHitBuffed bf4 = new beHitBuffed();
		
		bf.setNeedCount(7);
		bf.setRate(2.5);
		bf2.setNeedCount(7);
		bf2.setRate(2.5);
		bf3.setNeedCount(7);
		bf3.setRate(2.5);
		bf4.setNeedCount(7);
		bf4.setRate(2.5);
		
		bf.statusRefresh(player);
		bf2.statusRefresh(player);
		bf3.statusRefresh(player);
		bf4.statusRefresh(player);
	
		if(bf.isStatusExist(player)==-1) {
			player.getBuffs().add(bf);
		}
		if(bf2.isStatusExist(player)==-1) {
			player.getBuffs().add(bf2);
		}if(bf3.isStatusExist(player)==-1) {
			player.getBuffs().add(bf3);
		}if(bf4.isStatusExist(player)==-1) {
			player.getBuffs().add(bf4);
		}
	}
}
