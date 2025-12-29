package Events;

import Datas.DataCommander;
import Datas.Datas;
import Entities.Mobs;
import Entities.Players;
import GUI.GUI;

public class LevelChangeEvent {
	private static double rateOfHealth=1.1;
	private static double rateOfDamage=1.1;
	private static double rateOfArmour=1.1;
	private static double rateOfExp=1.15;
	public static void judgeLevelUp(Players player,Datas data,Mobs mob) {
		if(player.getExp()>=player.getMaxExp()) {
			while(player.getExp()>=player.getMaxExp()) {
				DataCommander dataCommand = new DataCommander();
				player.setExp(player.getExp()-player.getMaxExp());
				player.setStatusPoint(player.getStatusPoint()+5);
				player.setLevel(player.getLevel()+1);
				player.updataPlayerStatus();
				player.heal();
				player.mpHeal();
				GUI.LevelUpNote(player);
				
				try {
					Thread.sleep(70);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("你升級了!! 你目前等級是: " + player.getLevel());
				System.out.println("目前狀態是:");
				System.out.println("等級: " + player.getLevel());
				System.out.printf("攻擊: %d\n",player.getDamage());
				System.out.printf("血量: %d/%d\n",player.getHealth(),player.getMaxHealth());
				System.out.printf("經驗值: %.0f/%.0f\n",player.getExp(),player.getMaxExp());
				dataCommand.dataSave(player,data);
				System.out.println();
			}
			
		}else if(player.getExp()<0){
			while(player.getExp()<0) {
				DataCommander dataCommand = new DataCommander();
				if(player.getLevel()>1) {
				player.setLevel(player.getLevel()-1);
				player.updataPlayerStatus();
				player.setExp(player.getExp()+player.getMaxExp());
				player.setStatusPoint(player.getStatusPoint()-5);
				}else {
					player.setExp(0);
					player.updataPlayerStatus();
					break;
				}
				player.updataPlayerStatus();
				player.heal();
				player.mpHeal();
				GUI.LevelDownNote(player);
				
				try {
					Thread.sleep(70);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("你降級了!! 你目前等級是: " + player.getLevel());
				System.out.println("目前狀態是:");
				System.out.println("等級: " + player.getLevel());
				System.out.printf("攻擊: %d\n",player.getDamage());
				System.out.printf("血量: %d/%d\n",player.getHealth(),player.getMaxHealth());
				System.out.printf("經驗值: %.0f/%.0f\n",player.getExp(),player.getMaxExp());
				dataCommand.dataSave(player,data);
				System.out.println();
			}
		}
		
	}
	
	/**
	 * Core leveling logic without any GUI, sleeping, or persistence.
	 * <p>
	 * Intended for headless unit tests as a refactor-safety net.
	 * Runtime/game behavior remains defined by {@link #judgeLevelUp(Players, Datas, Mobs)}.
	 *
	 * @return number of level-ups applied (0 if none)
	 */
	public static int applyLevelUpsNoUi(Players player) {
		int levelUps = 0;
		if (player.getExp() >= player.getMaxExp()) {
			while (player.getExp() >= player.getMaxExp()) {
				player.setExp(player.getExp() - player.getMaxExp());
				player.setStatusPoint(player.getStatusPoint() + 5);
				player.setLevel(player.getLevel() + 1);
				player.updataPlayerStatus();
				player.heal();
				player.mpHeal();
				levelUps++;
			}
		}
		return levelUps;
	}
	public static boolean isLevelUp(Players player) {
		if(player.getExp()>=player.getMaxExp()) {
			return true;
		}else {
			return false;
		}
	}
}
