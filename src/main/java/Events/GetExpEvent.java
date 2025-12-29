package Events;

import Entities.Mobs;
import Entities.Players;

public class GetExpEvent {
	private static final double DEATH_EXP_LOSS_RATE = 0.05;

	public static void combatGetExp(Players player, Mobs mob) {
		if (DeathEvent.mobDeath(mob)) {
			double expGained = mob.getExp();
			System.out.printf("你獲得 %.1f 經驗值!\n", expGained);
			player.gainExp(expGained);
		}
	}

	public static void lostExp(Players player) {
		if (DeathEvent.playerDeath(player)) {
			double lossExp = player.getMaxExp() * DEATH_EXP_LOSS_RATE;
			System.out.printf("你失去 %.1f 經驗值!\n", lossExp);
			player.loseExp(lossExp);
		}
	}
}
