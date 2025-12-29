package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import Skills.Skills;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class runDamageEvent implements Runnable{
	private int sleepMilis;
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
	private AnchorPane combating;
	public runDamageEvent(AnchorPane combating,Button attack,Button props,Button skills,Button run,Label damage1 , Label damage2 ,Players player,Mobs mob,Label toMove1,Label toMove2,double distance1,double distance2,double distance,int times,int sleepMilis) {
		this.sleepMilis = sleepMilis;
		this.combating = combating;
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
		
	}

	@Override
	public void run() {
		Platform.runLater(() -> {
			attack.setDisable(true);
			props.setDisable(true);
			skills.setDisable(true);
			run.setDisable(true);
		});
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		if(mob.getHealth()>0&&!mob.getIsIced()) {//怪物的移動和傷害damage1
			
			double origin12 = toMove2.getLayoutX();
			
			Platform.runLater(() -> GUI.move2(toMove2, distance2));
				

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
					GUI.getPlayer().getSkills().get(i).setNowCooldown(GUI.getPlayer().getSkills().get(i).getNowCooldown()+1);
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
