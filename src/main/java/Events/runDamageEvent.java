package Events;

import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
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
		CombatFlowHelper.disableControls(attack, props, skills, run);
		
		try {
			Thread.sleep(CombatTimingConstants.COMBAT_ACTION_DELAY);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	
		CombatFlowHelper.performMobAttack(combating, player, mob, toMove2, distance2, 300, 300);
		CombatFlowHelper.resetMobFreeze(mob);
		CombatFlowHelper.updateSkillCooldowns(player);
		CombatFlowHelper.resolveStatusOrEnable(player, mob, attack, props, skills, run, times, distance);
		
 	}
 
}
