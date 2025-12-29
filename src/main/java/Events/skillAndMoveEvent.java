package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import Skills.Skills;
import Skills.beFired;
import Skills.skillStatus;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class skillAndMoveEvent implements Runnable{
	private int sleepMilis;
	private boolean isHit;
	private int times;
	private double distance;
	private double distance1;
	private double distance2;
	private Label toMove1;
	private static Players player;
	private static Mobs mob;
	private Label toMove2;
 
	private Button attack;
	private Button props;
	private Button skills;
	private Button run;
	private Rectangle health;
	private Rectangle Mana;
	private Label healthCount;
	private Skills skill;
	private Label ManaCount;
	private int index;
	private static Label mobCount;//血量計數
	private static Label mobStatus;//怪物屬性等級 名稱
	private static ProgressBar pbar;//怪物血量顯示
	public skillAndMoveEvent(int index,Skills skill,Rectangle health,Button attack,Button props,Button skills,Button run,Label damage1 , Label damage2 ,Players player,Mobs mob,Label toMove1,Label toMove2,double distance1,double distance2,double distance,int times,int sleepMilis) {
		this.sleepMilis = sleepMilis;
		this.index = index;
		this.distance = distance;
		this.distance1 = distance1;
		this.distance2 = distance2;
		this.times = times;
		this.player =player;
		this.mob = mob;
		this.toMove1 = toMove1;
		this.toMove2 = toMove2;
 
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
 		attack.setDisable(true);
		props.setDisable(true);
		skills.setDisable(true);
		run.setDisable(true);
		GUI.HPMPUpdate(player);
		GUI.HPMPLoaderUpdata(player);
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(skill.getMyself()==false) {
			double origin1 = toMove1.getLayoutX();
			
			GUI.move1(toMove1, distance1);	
			
 	
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			toMove1.setLayoutX(origin1);
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					isHit = (int)(Math.random()*99)<=(player.getSkills().get(index).getSkillHit()-mob.getEscape());
					if(isHit) {
						if((int)(Math.random()*99)<=player.getBoom()) {
							damageDisplayEvent dde = new damageDisplayEvent(GUI.getCombating(), "playerBoom", SkillsDischargeEvents.applySkill(player, mob, index,true));
							Thread t = new Thread(dde);
							t.start();
  						}else {
							damageDisplayEvent dde = new damageDisplayEvent(GUI.getCombating(), "playerDamage", SkillsDischargeEvents.applySkill(player, mob, index,false));
							Thread t = new Thread(dde);
							t.start();
 						}
					}else {
						damageDisplayEvent dde = new damageDisplayEvent(GUI.getCombating(), "playerMiss", 0);
						Thread t = new Thread(dde);
						t.start();
					}
				}
			});
	
			
		 
		 
	}else {
		SkillsDischargeEvents.applySkill(player, mob, index,false);
	}
		if(mob.getHealth()>0&&!mob.getIsIced()) {//怪物的移動和傷害damage1
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			double origin12 = toMove2.getLayoutX();
			
			GUI.move2(toMove2, distance2);
  

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			toMove2.setLayoutX(origin12);


					if((int)(Math.random()*99)<=player.getEscape()) {
						damageDisplayEvent dde = new damageDisplayEvent(GUI.getCombating(), "mobMiss", 0);
						Thread t = new Thread(dde);
						t.start();
					}else {				
						damageDisplayEvent dde = new damageDisplayEvent(GUI.getCombating(), "mobDamage", DamageEvent.damageTo(mob, player));
						Thread t = new Thread(dde);
						t.start();
					}
 	
			 
			 
			}
		mob.setIsIced(false);//凍結初始化
		for(int i = 0 ; i < GUI.getPlayer().getSkills().size() ; i ++) {
			if(GUI.getPlayer().getSkills().get(i).isCanBeApply()==false) {
				if(GUI.getPlayer().getSkills().get(i).getNowCooldown()>=GUI.getPlayer().getSkills().get(i).getCool()-1) {
					GUI.getPlayer().getSkills().get(i).setCanBeApply(true);
					GUI.getPlayer().getSkills().get(i).setNowCooldown(-1);

				}else {
					GUI.getPlayer().getSkills().get(i).setNowCooldown(GUI.getPlayer().getSkills().get(i).getNowCooldown()+1);
				}
			}
		}
		if(!player.getBuffs().isEmpty()||!mob.getBuffs().isEmpty()) {
			statusThread stt = new statusThread(attack, props, skills, run, times, distance, mob);
			stt.run();
		}else {
			BattleEvent.updateCombatCount();

			attack.setDisable(false);
			props.setDisable(false);
			skills.setDisable(false);
			run.setDisable(false);
		}
		
		if(isHit) {//如果命中
			player.getSkills().get(index).getEffect(mob);
			skillStatus.setLabel(mob);
		}
		
 	}
	 
}
