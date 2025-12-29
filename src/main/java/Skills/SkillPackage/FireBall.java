package Skills.SkillPackage;

import Entities.Players;
import Skills.Skills;

public class FireBall extends Skills{
	public FireBall(Players player) {
		super(player);
		System.out.println("技能人物:" + player.getPlayer());

		ID = 1;
		Name = "火球術";
		Note = "火球攻擊!!";
		Damage = 1.2;//倍率
		MpCost = 10;
		skillHit = 80;
		Cooldown = 3;
	}
}
