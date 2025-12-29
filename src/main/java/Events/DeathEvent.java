package Events;

import Entities.Mobs;
import Entities.Players;

public class DeathEvent {
	public static boolean mobDeath(Mobs mob) {
		if(mob.getHealth()<=0) {
			return true;
		}
		return false;
	}
	public static boolean playerDeath(Players player) {
		if(player.getHealth()<=0) {
			return true;
		}
		return false;
	}
}
