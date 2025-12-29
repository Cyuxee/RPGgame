package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import Objects.Objects;
import Skills.Skills;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

	public class propsEvent implements Runnable{
		private int sleepMilis;
		private int times;
		private double distance;
		private double distance1;
		private double distance2;
		private Label toMove1;
		private Players player;
		private static Mobs mob;
		private Label toMove2;
//		private static Label damage1;
//		private static Label damage2;
		private Button attack;
		private Button props;
		private Button skills;
		private Button run;
		private Rectangle health;
		private Rectangle Mana;
		private Label healthCount;
		private Skills skill;
		private static double origin;
		private Label ManaCount;
		private Objects object;
		private AnchorPane combating;
		private static Label mobCount;//血量計數
		private static Label mobStatus;//怪物屬性等級 名稱
		private static ProgressBar pbar;//怪物血量顯示
		
		
		public propsEvent(AnchorPane combating,Objects object,Button attack,Button props,Button skills,Button run,Label damage1 , Label damage2 ,Players player,Mobs mob,Label toMove1,Label toMove2,double distance1,double distance2,double distance,int times,int sleepMilis) {
			this.sleepMilis = sleepMilis;
			this.combating = combating;
			this.object = object;
			this.distance = distance;
			this.distance1 = distance1;
			this.distance2 = distance2;
			this.times = times;
			this.player =player;
			this.mob = mob;
			this.toMove1 = toMove1;
			this.toMove2 = toMove2;
//			this.damage1 = damage1;
//			this.damage2 = damage2;
			this.attack = attack;
			this.props = props;
			this.skills = skills;
			this.skill = skill;
			this.run = run;
			this.health = health;
			this.mobCount = BattleEvent.getMobCount();
			this.mobStatus = BattleEvent.getMobStatus();
			this.pbar = BattleEvent.getPbar();	
		}

		@Override
		public void run() {
				Platform.runLater(() -> {
					attack.setDisable(true);
					props.setDisable(true);
					skills.setDisable(true);
					run.setDisable(true);
					GUI.HPMPUpdate(player);
					GUI.HPMPLoaderUpdata(player);
				});
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(object.isHeal()) {
				System.out.println(object.isMP());
				if(!object.isMP()) {
					damageDisplayEvent dde = new damageDisplayEvent(combating, "playerHeal", object.getHealAmount());						
					Thread t = new Thread(dde);						
					t.start();
				}else {
					damageDisplayEvent dde = new damageDisplayEvent(combating, "playerMpHeal", object.getHealAmount());						
					Thread t = new Thread(dde);						
					t.start();
				}
				object.Heal();
				
				if(player.getHealth()>player.getMaxHealth()) {
					player.setHealth(player.getMaxHealth());
				}
				if(player.getMana()>player.getMaxMana()) {
					player.setMana(player.getMaxMana());
				}

			
 
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
 		
			if(mob.getHealth()>0&&!mob.getIsIced()) {//怪物的移動和傷害damage1
				
				double origin12 = toMove2.getLayoutX();
				
				
				Platform.runLater(() -> GUI.move2(toMove2, distance2));//移動的
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Platform.runLater(() -> toMove2.setLayoutX(origin12));

					
						
				if((int)(Math.random()*99)<=player.getEscape()) {					
					damageDisplayEvent dde = new damageDisplayEvent(combating, "mobMiss", 0);						
					Thread t = new Thread(dde);						
					t.start();						
				}else {										
					damageDisplayEvent dde = new damageDisplayEvent(combating, "mobDamage", DamageEvent.damageTo(mob,player));												
					Thread t = new Thread(dde);	
					t.start();					
				}
					
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
 
			}
			mob.setIsIced(false);//凍結初始化
			for(int i = 0 ; i < GUI.getPlayer().getSkills().size() ; i ++) {
				if(GUI.getPlayer().getSkills().get(i).isCanBeApply()==false) {
					if(GUI.getPlayer().getSkills().get(i).getNowCooldown()>=GUI.getPlayer().getSkills().get(i).getCool()-1) {
						GUI.getPlayer().getSkills().get(i).setCanBeApply(true);
						GUI.getPlayer().getSkills().get(i).setNowCooldown(-1);
					}else {
						GUI.getPlayer().getSkills().get(i).
						setNowCooldown(GUI.getPlayer().getSkills().get(i).getNowCooldown()+1);
					}
				}
			}
			if(!player.getBuffs().isEmpty()||!mob.getBuffs().isEmpty()) {
				statusThread stt = new statusThread(attack, props, skills, run, times, distance, mob);
				stt.run();
				 
			}else {
				BattleEvent.updateCombatCount();
				Platform.runLater(() -> {
					attack.setDisable(false);
					props.setDisable(false);
					skills.setDisable(false);
					run.setDisable(false);
				});
			}
 		}
 
		}
	}
