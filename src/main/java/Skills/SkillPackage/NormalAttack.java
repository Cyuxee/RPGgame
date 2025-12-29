package Skills.SkillPackage;

import Entities.Players;
import Skills.Skills;

public class NormalAttack extends Skills{
	public NormalAttack(Players player) {
		super(player);
		ID = 0;
		Name = "普通攻擊";
		Note = "就是普通的攻擊XD";
		Damage = player.getLevel()*20.4;
		MpCost = 0;
		Cooldown = 0;
	}
}
