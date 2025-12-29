package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;


public class DamageEvent {
	
	public static int damageTo(Mobs mob,Players player) {
		System.out.println("玩家 "+ player.getPlayer() +  " 受到了 " + mob.getName() + " 的攻擊");
		double totalDamage = mob.getDamage()*1+((int)(Math.random()*mob.getDamage()*0.2));
		int damageOffset = (int)(totalDamage*((double)mob.getDamage()/((double)player.getArmor()+(double)mob.getDamage())));
		//當攻擊大於防禦越多，值就越趨近於1 所以totaldamage就越趨近於原本的傷害,反之亦然，這就是這條傷害計算式的由來
		System.out.println("人物防禦造成傷害減免值: " + (int)(totalDamage-damageOffset));
		player.setHealth((int)player.getHealth()-(int)(damageOffset));
		GUI.HPMPUpdate(player);
		GUI.HPMPLoaderUpdata(player);
		if((int)player.getHealth()<=0) {
			System.out.println("玩家已死亡!");
		}else {
			System.out.println("受到 " + (int)(damageOffset) + " 點傷害!");
			System.out.printf(player.getPlayer()+" 的生命為: %d/%d\n",(int)player.getHealth(),(int)player.getMaxHealth());
		}
		return (int)(damageOffset);
	}
	public static int damageTo(Players player,Mobs mob,boolean boom) {
		double totalDamage = player.getDamage()*1+((int)(Math.random()*player.getDamage()*0.3))-mob.getArmor()*(mob.getLevel()/(player.getLevel()+mob.getLevel()));
		int damageOffset = (int)(totalDamage*((double)player.getDamage()/((double)mob.getArmor()+(double)player.getDamage())));
		
		if(boom==true) {
			totalDamage*=player.getBoomAttackRate();
			damageOffset = (int)(totalDamage*((double)player.getDamage()/((double)mob.getArmor()+(double)player.getDamage())));
		
			mob.setHealth((int)mob.getHealth()-(int)(damageOffset));
			System.out.println("玩家 "+ player.getPlayer() +  " 對 " + mob.getName() + " 使出 "+ player.getSkills().get(0).getName() + " 造成 " + (int)(damageOffset) + " 點傷害(暴擊)");
			//////
			if((int)mob.getHealth()<=0) {
				System.out.println("怪物已死亡!");
			}else {
				System.out.printf(mob.getName() + " 的血量為: %d/%d\n",(int)mob.getHealth(),(int)mob.getMaxHealth());
			}
			//////

			System.out.println("怪物防禦造成傷害減免值: " + (totalDamage - damageOffset));
			return (int)(damageOffset);
		}else {
			mob.setHealth((int)mob.getHealth()-(int)(damageOffset));
			System.out.println("玩家 "+ player.getPlayer() +  " 對 " + mob.getName() + " 使出 "+ player.getSkills().get(0).getName() + " 造成 " + (int)(damageOffset) + " 點傷害");
			//////
			if((int)mob.getHealth()<=0) {
				System.out.println("怪物已死亡!");
				
			}else {
				System.out.printf(mob.getName() + " 的血量為: %d/%d\n",(int)mob.getHealth(),(int)mob.getMaxHealth());
			}
			//////

			System.out.println("怪物防禦造成傷害減免值: " + (totalDamage - damageOffset));
			return (int)(damageOffset);
		}
		
	}
}
