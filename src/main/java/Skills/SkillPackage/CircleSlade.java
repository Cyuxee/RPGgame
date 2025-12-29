package Skills.SkillPackage;

import Entities.Mobs;
import Entities.Players;
import Skills.*;

public class CircleSlade extends Skills{
	public CircleSlade(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 23;
		Name = "圓舞流歌";
		Note = "獲得提升閃避、治癒、暴傷效果(倍率2)5回合，並且給予對方375%物理傷害";
		Damage = 3.75;//倍率
		isMagic = false;
		isPhysic = true;
		MpCost = 2000;
		skillHit = 9999;
		Cooldown = 10;
	}
	@Override
	public void getEffect(Mobs mob) {
		beHealed bf = new beHealed();
		bf.setRate(2);
		bf.setNeedCount(5);
		beEscapeBuffed bf2 = new beEscapeBuffed();
		bf2.setRate(2);
		bf2.setNeedCount(5);
		beBoomDamageBuffed bf3 = new beBoomDamageBuffed();
		bf3.setRate(2);
		bf3.setNeedCount(5);
		bf.statusRefresh(player);
		bf2.statusRefresh(player);
		bf3.statusRefresh(player);
		if(bf.isStatusExist(player)==-1) {
			player.getBuffs().add(bf);
		}if(bf2.isStatusExist(player)==-1) {
			player.getBuffs().add(bf2);
		}if(bf3.isStatusExist(player)==-1) {
			player.getBuffs().add(bf3);
		}
	}
}
