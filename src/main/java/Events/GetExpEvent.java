package Events;

import Entities.Mobs;
import Entities.Players;

public class GetExpEvent {
	public static void combatGetExp(Players player,Mobs mob) {
	     if(DeathEvent.mobDeath(mob)) {
	    	 System.out.printf("你獲得 %.1f 經驗值!\n",mob.getExp());
	    	 player.setExp(player.getExp()+mob.getExp());
	     }
	}
	public static void lostExp(Players player) {
	     if(DeathEvent.playerDeath(player)) {
	    	 double lossExp = player.getMaxExp()*0.05;
	    	 System.out.printf("你失去 %.1f 經驗值!\n",lossExp);
	    	 player.setExp(player.getExp()-lossExp);
	     }
	}
}
