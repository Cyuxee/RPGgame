package Events;

import java.util.ArrayList;
import java.util.Comparator;

import Datas.DataCommander;
import Datas.Datas;
import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import GUI.GUI.propsUpSort;
import GUI.imageChange2;
import javafx.animation.PauseTransition;
import Objects.Objects;
import Skills.skillStatus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BattleEvent implements Runnable{
	public static int pages = 0;
	public static int temp = 1;
	private static int combatTotalCount = 0;
	private static int combatCount=  0;//回合數
	private static int combatTimes =0;//戰鬥場數->可作為成就用
	
	private static Mobs mob;
	private static Label mobCount = new Label();//血量計數
	private static Label combatCountL =new Label("第 " + combatCount + " 回合");
	private static Label mobStatus = new Label();//怪物屬性等級 名稱
	private static ProgressBar pbar = new ProgressBar();//怪物血量顯示
	private static ArrayList<Label> dropRecord = new ArrayList<>();

	private static Players player;
	private Button attack;
	private Button propb;
	private Button skills;
	private Button run;
	private Stage stage;
	private Thread t1;
	private volatile boolean running = true;
	private Scene scene;
	private Datas data;
	private Label friends;
	private Label enemys;
	private Label damage1;
	private Label damage2;
	private static AnchorPane combating;
	private Thread att;
	private Thread skill;
	private Thread propt;
	private int round=0;
	private ScrollPane spane = new ScrollPane();
	private ScrollPane skia = new ScrollPane();
	private int index=0;
	private Rectangle health;
	private AnchorPane prop = new AnchorPane();
	private AnchorPane skip = new AnchorPane();
	private FlowPane ski = new FlowPane();
	private ArrayList<Button> skis;
	private ArrayList<Button> props;
	private FlowPane propv = new FlowPane();		
	public BattleEvent(int areaLevel , int areaName,Rectangle health,AnchorPane combating,Label damage1 ,Label damage2 ,Label friends, Label enemys, Datas data,Stage stage,Scene combats,Players player,ArrayList<Button> a) {
		if(areaLevel==0&&areaName==0) {
			mob = new Mobs();
			mob = mob.mobTest("測試怪物");	
		}else {
			mob = new Mobs(areaLevel,areaName);
		}
		this.player = player;
		this.attack = a.get(0);
		this.propb=a.get(1);
		this.skills=a.get(2);
		this.run=a.get(3);
		this.stage = stage;
		this.scene = combats;
		this.data = data;
		this.friends = friends;
		this.enemys = enemys;
		this.damage1 = damage1;
		this.damage2 = damage2;
		this.health =health;
		this.combating = combating;

	}
	@Override
	public void run() {
		attack.setDisable(false);
		propb.setDisable(false);
		skills.setDisable(false);
		run.setDisable(false);
		addPbar();
		combatCount=0;
		for(int i = 1 ; i < GUI.getPlayer().getSkills().size() ; i ++) {
			player.getSkills().get(i).setCanBeApply(true);
			player.getSkills().get(i).setNowCooldown(-1);
		}
		skillStatus.originMobStatusRecord();
		skillStatus.originPlayerStatusRecord();//紀錄原本資訊
		
		BattleEvent.updateCombatCount();
		player.updataPlayerStatus();
		MobBarUpdateEvent mbuv = new MobBarUpdateEvent(player,mob,mobCount,mobStatus,pbar);
		mbuv.mobBarUpdate();
		
		t1= Thread.currentThread();
		health.setWidth(((double)player.getHealth()/(double)player.getMaxHealth()*180));
		GUI.HPMPUpdate(player);
		GUI.HPMPLoaderUpdata(player);
		

		
		DataCommander dataCommand = new DataCommander();
		
		player.updataPlayerStatus();//更新狀態
		BattleMoveEvent move = new BattleMoveEvent(combating,health,damage1,damage2,attack,propb,skills,run,player,mob,friends,250,enemys,-250);
		runDamageEvent runMove = new runDamageEvent(combating,attack,propb,skills,run,damage1,damage2,player, mob,friends,enemys,250,-250, 1,10,20);
		
		attack.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent event) {	
				att = new Thread(move);
				att.start();
			}
		});
		
		
		propb.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				combatingInventory();
				
				Button proback = new Button("返回");
				
				proback.setLayoutX(625);
				proback.setLayoutY(135);
				proback.setPrefSize(60, 40);
				prop.getChildren().add(proback);

				proback.setOnAction(e->{
					combating.getChildren().remove(prop);					
					
				});

				
			
			}
	});

		
		skills.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				skis = new ArrayList<Button>();
			
				Button skiback = new Button("返回");
				
				skia= new ScrollPane();
				
				skip = new AnchorPane();
				skia.setLayoutX(15);
				skia.setLayoutY(15);
				
				
				ski = new FlowPane();
				
				skia.setStyle("-fx-background-color: silver;");
				ski.setStyle("-fx-background-color: silver;");
				skip.setPrefSize(600, 150);
				skia.setContent(ski);
				skip.setLayoutX(485);
				skip.setLayoutY(475);
				
				skip.setPrefSize(700, 190);
				skip.setStyle("-fx-background-color: silver;"
								 +"-fx-border-color: black;"
								 +"-fx-border-width: 1mm;");
				
				ski.setPrefSize(600, 150);
//				ski.setPrefSize(560, 240);
				ski.setOrientation(Orientation.VERTICAL); 
				
		
				skiback.setLayoutX(625);
				skiback.setLayoutY(135);
				skiback.setPrefSize(60, 40);
				skiback.setOnAction(e->{
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							combating.getChildren().remove(skip);//把skip關掉
						}
					});
				});
				
				skip.getChildren().add(skiback);
				
				for(int i = 1 ; i < player.getSkills().size() ; i ++) {
					skis.add(new Button(i+"." +player.getSkills().get(i).getName()+" MP: "+player.getSkills().get(i).getMpCost()));
				}
				for(int i = 0 ; i< skis.size(); i ++) {
					ski.getChildren().add(skillSet(skis, i));
				}

				skip.getChildren().add(ski);
				skip.getChildren().add(skia);
				combating.getChildren().add(skip);
		
			}
		});
		
		run.setOnAction(new EventHandler<ActionEvent>(){//逃跑

			@Override
			public void handle(ActionEvent event) {
				int rand = ((int)(Math.random()*10+1))%2;
				if(rand==0) {
					System.out.println("逃跑成功!");
					combatCount=0;
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							skillStatus.playerStatusRecovery();
							player.getBuffs().clear();
							mob.getBuffs().clear();
							skillStatus.statusCountUpdate(player);//這是要更新狀態回合術用的
							skillStatus.statusCountUpdate(mob);
							GUI.manuBarUpdata(GUI.getCombatPane());
							GUI.recover(stage,scene);
							running = false;
						}
					});	
				}else {
					Thread runTh = new Thread(runMove);
					runTh.start();
					System.out.println("逃跑失敗!");
				}
			}
		});
		while(running && !DeathEvent.mobDeath(mob)) {
			skillStatus.setLabel(mob);
			skillStatus.setLabel(player);
			mbuv.mobBarUpdate();
			GUI.HPMPUpdate(player);
			GUI.HPMPLoaderUpdata(player);
//			System.out.println("我在這裡ˋ");
			if(DeathEvent.playerDeath(player)) {
				GetExpEvent.lostExp(player);
				player.setHealth((int)(player.getMaxHealth()*0.1));
				GUI.recover(stage, scene);					
				LevelChangeEvent.judgeLevelUp(player,data,mob);
				dataCommand.dataSave(player,data);
				GUI.manuBarUpdata(GUI.getCombatPane());
				GUI.afterCombatDeadNote(player,mob);
				skillStatus.playerStatusRecovery();
				player.getBuffs().clear();
				mob.getBuffs().clear();
				skillStatus.statusCountUpdate(player);
				skillStatus.statusCountUpdate(mob);
					running = false;
			}
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			if(DeathEvent.mobDeath(mob)&&!DeathEvent.playerDeath(player)) {
				
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						if(mob.getName().equals("魔王")&&player.isEnd()==false) {
							imageChange2 ic = new imageChange2(player,new Stage());
									PauseTransition pause = new PauseTransition(Duration.millis(300));
									pause.setOnFinished(ev -> {
										try {
											ic.start();
										} catch (Exception e) {
											e.printStackTrace();
										}
									});
									pause.play();
							player.setIsEnd(true);
						}
					}
				});	
			mbuv.mobBarUpdate();

			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GetExpEvent.combatGetExp(player, mob);
			GUI.recover(stage, scene);		

			combatTotalCount+=combatCount;
			combatTimes++;
			System.out.println("戰鬥場數: "+combatTimes);
			GUI.setDropVbox(getMobDrops(player, mob));
			
			
			LevelChangeEvent.judgeLevelUp(player,data,mob);
			amountUpdate(player);
			dataCommand.dataSave(player,data);
			
			GUI.afterCombatNote(player,mob);	//因為錢財和摩源時都是在這時候加進去的 所以menubar的更新要在他後面
			GUI.manuBarUpdata(GUI.getCombatPane());
			skillStatus.playerStatusRecovery();
			player.getBuffs().clear();
			mob.getBuffs().clear();
			running = false;
		}
	}
 
	public ArrayList<Label> getMobDrops(Players player,Mobs mob) {
		dropRecord.clear();
		for(int i = 0 ; i < mob.getDrops().size() ; i ++) {
			if((int)(Math.random()*99)<mob.getDrops().get(i).getDropChance()) {
				player.getProps().add(mob.getDrops().get(i));
				System.out.println("玩家獲得 " + mob.getDrops().get(i).getName() + " 物品");
				Label temp = new Label("***獲得物品 " + mob.getDrops().get(i).getName() + " x" + mob.getDrops().get(i).getAmount()+"***");
				temp.setTextFill(Color.SEAGREEN);
				temp.setFont(new Font(14));
				//temp.setPadding(new Insets(3));
				dropRecord.add(temp);
			}
		}
		return dropRecord;
	}
	public static Mobs getMob() {
		return mob;
	}
	public void attack() {
		DamageEvent.damageTo(player, mob,false);
	}
	public void eattack() {
		DamageEvent.damageTo(mob, player);
	}
	public Button propsSet(ArrayList<Button> a,int index) {
		//BattleSkillMoveEvent skillMove = new BattleSkillMoveEvent(player.getSkills().get(index+1),health,damage1,damage2,attack,props,skills,run,player,mob,friends,150,enemys,-150);
		//runDamageEvent move = new runDamageEvent(attack, attack, attack, attack, damage1, damage1, player, mob, damage1, damage1, index, index, index, index, index);
		propsEvent move = new propsEvent(combating,player.getProps().get(index),attack,propb,skills,run,damage1,damage2,player, mob,friends,enemys,250,-250, 1,10,20);
		Button bu = a.get(index); 
		a.get(index).setPrefHeight(10);
		a.get(index).setPrefWidth(160);
		Label name = new Label(player.getProps().get(index).getName() +" x"+player.getProps().get(index).getAmount());
		Label lore = new Label(player.getProps().get(index).getNote());
		name.setFont(new Font(16));
		name.setTextFill(Color.LIGHTGREEN);
		lore.setFont(new Font(14));
		lore.setTextFill(Color.LIGHTBLUE);
		VBox v = new VBox(name,lore);
		Tooltip tt = new Tooltip();
		tt.setShowDelay(new Duration(200));
		tt.setGraphic(v);
		bu.setTooltip(tt);
		if(player.getProps().get(index).getName().equals("恢復藥(低級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						
					player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
					if(player.getProps().get(index).getAmount()<1) {
						player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
					}
					combating.getChildren().remove(prop);//把prop關掉
						
					propt = new Thread(move);
					propt.start();
					}
				});
			}
		});
			return bu;
		}else if(player.getProps().get(index).getName().equals("恢復藥(中級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
								
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("恢復藥(上級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
								
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("魔力恢復藥(低級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
							
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("魔力恢復藥(中級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
								
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("魔力恢復藥(上級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
								
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("恢復藥(神級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
								
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("魔力恢復藥(神級)")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
							
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}else if(player.getProps().get(index).getName().equals("奇怪的藥水")&&player.getProps().get(index).getAmount()>=1){
			bu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							
						player.getProps().get(index).setAmount((player.getProps().get(index).getAmount()-1));
						if(player.getProps().get(index).getAmount()<1) {
							player.getProps().remove(index);//要記得刪除list裡面的元素 不然會抓不到然後跳exception
						}
						combating.getChildren().remove(prop);//把prop關掉
							
						propt = new Thread(move);
						propt.start();
						}
					});
				}
			});
			return bu;
		}
		return null;
	}	
	public Button skillSet(ArrayList<Button> a ,int index) {
		BattleSkillMoveEvent skillMove = new BattleSkillMoveEvent(index+1,combating,player.getSkills().get(index+1),health,damage1,damage2,attack,propb,skills,run,player,mob,friends,250,enemys,-250);
		Button bu = a.get(index); 

		Label name = new Label(player.getSkills().get(index+1).getName());
		Label lore = new Label(player.getSkills().get(index+1).getNote());
		name.setFont(new Font(17));
		name.setTextFill(Color.LIGHTGREEN);
		lore.setFont(new Font(14));
		lore.setTextFill(Color.LIGHTBLUE);
		VBox v = new VBox(name,lore);
		Tooltip tt = new Tooltip();
		tt.setShowDelay(new Duration(200));
		tt.setGraphic(v);
		bu.setTooltip(tt);
		if(player.getSkills().get(index+1).isCanBeApply()==false) {
			if(!player.getSkills().get(index+1).isCanBeApply()) {
				bu.setText((index+1) + "." + player.getSkills().get(index+1).getName() +" MP: "+  player.getSkills().get(index+1).getMpCost() + "->技能尚在冷卻中,尚餘 " + (player.getSkills().get(index+1).getCool()-player.getSkills().get(index+1).getNowCooldown()) + " 回合");
				bu.setDisable(true);
			}
			return bu;
		}
		if(player.getMana()<player.getSkills().get(index+1).getMpCost()) {
			bu.setText((index+1) + "." + player.getSkills().get(index+1).getName() +" MP: "+  player.getSkills().get(index+1).getMpCost() + "->魔力不足");
			bu.setDisable(true);						
			return bu;
		}
		bu.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
					player.setMana(player.getMana()-player.getSkills().get(index+1).getMpCost());
					player.getSkills().get(index+1).setCanBeApply(false);
					player.getSkills().get(index+1).setNowCooldown(-1);
					
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							combating.getChildren().remove(skip);//把skip關掉
						}
					});
					skill = new Thread(skillMove);
					skill.start();
				}
			});
		return bu;
	}
	public void combatingInventory() {
		Platform.runLater(new Runnable() {
		
		@Override
		public void run() { 				
			props= new ArrayList<Button>(); 
			propv = new FlowPane();
			amountUpdate(player);
//			Label invisible = new Label();
//			invisible.setPrefSize(0, 0);
//			invisible.setVisible(false);
//			propv.getChildren().add(invisible);
			propv.setOrientation(Orientation.VERTICAL);
			//propv.setLayoutX(30);
			//propv.setLayoutY(30);
			propv.setPrefHeight(150);
			//propv.setOrientation();
			propv.setPrefWidth(600);
			propv.setStyle("-fx-background-color: silver;");
			prop.setPrefSize(700, 190);
			prop.setLayoutX(485);
			prop.setLayoutY(475);
			prop.setStyle("-fx-background-color: silver;"
							 +"-fx-border-color: black;"
							 +"-fx-border-width: 1mm;");
			
			for(int i = 0 ; i < player.getProps().size() ; i ++) {//加上button
				props.add(new Button((i+1)+"." +player.getProps().get(i).getName()+" : "+player.getProps().get(i).getAmount()+ " 個"));
			
			}
			
			
			for(int i = 0 ; i < getIndex(player)  ;i ++) {//加到flowpane裡面,記得index 是除了裝備或其他素材以外的最高上限
				propv.getChildren().add(propsSet(props, i));	
			}
			spane = new ScrollPane();
			spane.setLayoutX(15);
			spane.setLayoutY(15);
			spane.setPrefSize(600, 150);
			spane.setStyle("-fx-background-color: silver;");
//			spane.setPrefViewportHeight(propv.getHeight());
//			spane.setPrefViewportWidth(propv.getWidth());
//			propv.getChildren().remove(invisible);
			spane.setContent(propv);
			prop.getChildren().add(spane);
			
			combating.getChildren().add(prop);

		}
	});
	}
 
	public static Label getMobCount() {
		return mobCount;
	}
	public static Label getMobStatus() {
		return mobStatus;
	}
	public static ProgressBar getPbar() {
		return pbar;
	}
	class propsUpSort implements Comparator<Objects> 
	{ 
		//以props的ID升序排列
		public int compare(Objects a, Objects b) 
		{ 
			return a.getID() - b.getID(); 
		} 
	} 
	public void amountUpdate(Players player) {
		player.getProps().sort(new propsUpSort());
		for(int i = 0 ; i < player.getProps().size() ; i ++) {
			for(int j = i+1 ; j < player.getProps().size() ; j ++) {
				if(player.getProps().get(i).getID()<10000&&player.getProps().get(i).getID()==player.getProps().get(j).getID()) {
					player.getProps().get(i).setAmount(player.getProps().get(i).getAmount()+player.getProps().get(j).getAmount());//把相同ID東西的數量加起來
					player.getProps().remove(j);	
				}
			}
		}
		int times = player.getProps().size();
		int flag1=0;
		for(int j = 0 ; j < times&&flag1==0 ; j ++) {
			flag1=1;
			for(int i = 0 ; i < player.getProps().size() ; i ++) {
				if(player.getProps().get(i).getAmount()<=0) {
					player.getProps().remove(i);
					flag1=0;
				}
			}
		}
		int times2 = player.getProps().size();
		int flag2 = 0;
		for(int j = 0 ; j < times2&&flag2==0 ; j ++) {
			flag2 =1;
			for(int i = 0 ; i < player.getProps().size() ; i ++) {
				if(player.getProps().get(i).getID()==9999) {
					player.setDiamond(player.getDiamond()+player.getProps().get(i).getAmount());
					player.getProps().remove(i);
					flag2=0;
				}
			}
		}
		
	}
	
	public void addPbar() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if(!combating.getChildren().contains(mobStatus)) {
					combating.getChildren().addAll(pbar,mobCount,mobStatus);
				}
			}
		});
	}
	
	public int getIndex(Players player) {
		int index=0;
		while(index < player.getProps().size()&&player.getProps().get(index).getID()<100) {
			index++;
		}
		return index;
	}
	public int getCombatCount() {
		return BattleEvent.combatCount;
	}
	public void setCombatCount(int combatCount) {
		BattleEvent.combatCount = combatCount;
	}
	public static void updateCombatCount() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				skillStatus.playerStatusRecovery();
				skillStatus.mobStatusRecovery();
				if(combatCount>1) {
					skillStatus.statusDischarge(player,mob);
					skillStatus.statusDischarge(mob,player);
				}
				if(!combating.getChildren().contains(combatCountL)) {
					combating.getChildren().add(combatCountL);
				}
				combatCount++;
				combatCountL.setPrefSize(300, 100);
				combatCountL.setLayoutX(480);
//				combatCountL.setLayoutY(-20);
				
				//combatCountL.setTextAlignment(TextAlignment.CENTER);
				combatCountL.setAlignment(Pos.CENTER);

				combatCountL.setStyle("-fx-background-color:gray;"
									 +"-fx-border-color: black;"
									 +"-fx-border-width: 0.6mm;"
									 +"-fx-border-radius: 30em;"
									 +"-fx-background-radius: 30em;"
									 +"-fx-font-size: 25px;"
									 +"-fx-font-weight: bold;");
				combatCountL.setText("第 " + combatCount + " 回合");
				if(combatCount>1) {
					skillStatus.statusCountUpdate(player);
					skillStatus.statusCountUpdate(mob);
				}
			}
		});
	}

}
