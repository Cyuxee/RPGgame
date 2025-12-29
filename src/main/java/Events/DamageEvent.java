package Events;


import java.util.function.DoubleSupplier;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;


public class DamageEvent {
	
	// === Public API used in game (delegates to GUI-backed view) ===
	public static int damageTo(Mobs mob,Players player) {
		return damageTo(mob, player, new GuiHPMPView());
	}
	
	public static int damageTo(Players player,Mobs mob,boolean boom) {
		return damageTo(player, mob, boom, new GuiHPMPView());
	}
	
	// === Testable overloads that accept an abstract view ===
	public static int damageTo(Mobs mob,Players player, HPMPView view) {
		return damageTo(mob, player, view, Math::random);
	}

	// Deterministic/test-friendly overload (inject RNG)
	public static int damageTo(Mobs mob,Players player, HPMPView view, DoubleSupplier rng) {
		System.out.println("玩家 "+ player.getPlayer() +  " 受到了 " + mob.getName() + " 的攻擊");
		double rand = (rng == null) ? Math.random() : rng.getAsDouble();
		double totalDamage = mob.getDamage()*1+((int)(rand*mob.getDamage()*0.2));
		int damageOffset = (int)(totalDamage*((double)mob.getDamage()/((double)player.getArmor()+(double)mob.getDamage())));
		//當攻擊大於防禦越多，值就越趨近於1 所以totaldamage就越趨近於原本的傷害,反之亦然，這就是這條傷害計算式的由來
		System.out.println("人物防禦造成傷害減免值: " + (int)(totalDamage-damageOffset));
		player.setHealth((int)player.getHealth()-(int)(damageOffset));
		if (view != null) {
			view.updatePlayer(player);
		}
		if((int)player.getHealth()<=0) {
			System.out.println("玩家已死亡!");
		}else {
			System.out.println("受到 " + (int)(damageOffset) + " 點傷害!");
			System.out.printf(player.getPlayer()+" 的生命為: %d/%d\n",(int)player.getHealth(),(int)player.getMaxHealth());
		}
		return (int)(damageOffset);
	}
	
	public static int damageTo(Players player,Mobs mob,boolean boom, HPMPView view) {
		return damageTo(player, mob, boom, view, Math::random);
	}

	// Deterministic/test-friendly overload (inject RNG)
	public static int damageTo(Players player,Mobs mob,boolean boom, HPMPView view, DoubleSupplier rng) {
		double rand = (rng == null) ? Math.random() : rng.getAsDouble();
		double totalDamage = player.getDamage()*1+((int)(rand*player.getDamage()*0.3))-mob.getArmor()*(mob.getLevel()/(player.getLevel()+mob.getLevel()));
		int damageOffset = (int)(totalDamage*((double)player.getDamage()/((double)mob.getArmor()+(double)player.getDamage())));
		String skillName = "普通攻擊";
		if (player.getSkills() != null && !player.getSkills().isEmpty() && player.getSkills().get(0) != null) {
			try {
				skillName = player.getSkills().get(0).getName();
			} catch (IndexOutOfBoundsException e) {
				// ignore and fall back to default skill name
			}
		}
		
		if(boom==true) {
			totalDamage*=player.getBoomAttackRate();
			damageOffset = (int)(totalDamage*((double)player.getDamage()/((double)mob.getArmor()+(double)player.getDamage())));
			mob.setHealth((int)mob.getHealth()-(int)(damageOffset));
			if (view != null) {
				view.updateMob(mob);
			}
			System.out.println("玩家 "+ player.getPlayer() +  " 對 " + mob.getName() + " 使出 "+ skillName + " 造成 " + (int)(damageOffset) + " 點傷害(暴擊)");
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
			if (view != null) {
				view.updateMob(mob);
			}
			System.out.println("玩家 "+ player.getPlayer() +  " 對 " + mob.getName() + " 使出 "+ skillName + " 造成 " + (int)(damageOffset) + " 點傷害");
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
	
	// Real GUI-backed implementation used by the game
	private static class GuiHPMPView implements HPMPView {
		@Override
		public void updatePlayer(Players player) {
			GUI.HPMPUpdate(player);
			GUI.HPMPLoaderUpdata(player);
		}
		@Override
		public void updateMob(Mobs mob) {
			// currently mob HP bar update is handled elsewhere; no-op here
		}
	}
}
