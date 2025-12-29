package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import Skills.skillStatus;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class statusThread {
	 
	private Mobs mob;
	private Button attack;
	private Button props;
	private Button skills;
	private Button run;
	private Players player = GUI.getPlayer();
	public statusThread(Button attack,Button props,Button skills,Button run,int times,double distance,Mobs mob) {
 
		this.mob = mob;
		this.attack = attack;
		this.props = props;
		this.skills = skills;
		this.run = run;
	}	
	public void run() {
		Platform.runLater(() -> {
			attack.setDisable(true);
			props.setDisable(true);
			skills.setDisable(true);
			run.setDisable(true);
		});
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		for(int i = 0 ; i < player.getBuffs().size() ; i ++) {
			playerStatusThread pst = new playerStatusThread(player, playerStatusDisplay(player.getBuffs().get(i)), 10, 0.1, player.getBuffs().get(i));
			Thread pt = new Thread(pst);
			pt.start();
			
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		for(int i = 0 ; i < mob.getBuffs().size() ; i ++) {
				mobStatusThread mst = new mobStatusThread(mob, mobStatusDisplay(mob.getBuffs().get(i)), 10, 0.1, mob.getBuffs().get(i));
				Thread mt = new Thread(mst);
				mt.start();
				
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		BattleEvent.updateCombatCount();

		Platform.runLater(() -> {
			attack.setDisable(false);
			props.setDisable(false);
			skills.setDisable(false);
			run.setDisable(false);
		});
	}
	public Label mobStatusDisplay(skillStatus ss) {
		Label damage1 = new Label();
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(700);
				damage1.setLayoutY(45);
				damage1.setFont(new Font(25));    
			}
		});
		return damage1;
	}
	public Label playerStatusDisplay(skillStatus ss) {
		Label damage1 = new Label();
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(200);
				damage1.setLayoutY(45);
				damage1.setFont(new Font(25));    
			}
		});
		return damage1;
	}
}