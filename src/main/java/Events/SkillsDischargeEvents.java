package Events;

import Entities.Mobs;
import Entities.Players;

public class SkillsDischargeEvents {
	public static int applySkill(Players player,Mobs mob,int index,boolean boom) {
		if(player.getSkills().get(index).getMyself()==true) {
			player.getSkills().get(index).getEffect(player);
			return 0;
		}else {
			double totalDamage = 0;

			if(player.getSkills().get(index).isPhysic()==true) {
				totalDamage += player.getDamage()*player.getSkills().get(index).getDamage()+((int)(Math.random()*player.getDamage()*0.3))-mob.getArmor()*(mob.getLevel()/(player.getLevel()+mob.getLevel()));
				
			}
			if(player.getSkills().get(index).isMagic()==true) {
				totalDamage += player.getMagicDamage()*player.getSkills().get(index).getDamage()+((int)(Math.random()*player.getDamage()*0.3))-mob.getArmor()*(mob.getLevel()/(player.getLevel()+mob.getLevel()));
				
			}

			int damageOffset = (int)(totalDamage*((double)player.getMagicDamage()/((double)mob.getArmor()+(double)player.getMagicDamage())));
			if(boom == true) {
				totalDamage*=player.getBoomAttackRate();
				damageOffset = (int)(totalDamage*((double)player.getMagicDamage()/((double)mob.getArmor()+(double)player.getMagicDamage())));
				System.out.println("玩家 " + player.getPlayer() + " 對 " + mob.getName() + " 施放 " + player.getSkills().get(index).getName() + " 造成 " + damageOffset + " 點傷害(暴擊)");
	
			}else {
				totalDamage*=1;
				System.out.println("玩家 " + player.getPlayer() + " 對 " + mob.getName() + " 施放 " + player.getSkills().get(index).getName() + " 造成 " + damageOffset + " 點傷害");
			}
			
			mob.setHealth((int)(mob.getHealth()-damageOffset));
			if(mob.getHealth()<=0) {
				System.out.println("怪物已死亡!");
			}else {
				System.out.printf(mob.getName() + " 的血量為: %d/%d\n",mob.getHealth(),mob.getMaxHealth());
			}
			return damageOffset;
		}
	}
}
