package Events;

import java.util.ArrayList;

import Entities.Players;
import GUI.GUI;
import javafx.application.Platform;import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class statusUpdateEvent extends Players{
	static AnchorPane pane = GUI.getStatusPane();
	static Players player = GUI.getPlayer();
	static int INTtemp = 0;
	static int STRtemp = 0;
	static int LUKtemp = 0;
	static int AGItemp = 0;
	static Label INT = new Label("智慧: " + (player.getTotalINT()+INTtemp));//智慧
	static Label STR = new Label("力量: " + (player.getTotalSTR()+STRtemp));//力量
	static Label LUK = new Label("幸運: " + (player.getTotalLUK()+LUKtemp));//幸運
	static Label AGI = new Label("敏捷: " + (player.getTotalAGI()+AGItemp));//敏捷
	static Button INTbuttonPlus = new Button("+"); 
	static Button INTbuttonMinus = new Button("-");
	static Button STRbuttonPlus = new Button("+"); 
	static Button STRbuttonMinus = new Button("-");
	static Button LUKbuttonPlus = new Button("+"); 
	static Button LUKbuttonMinus = new Button("-");
	static Button AGIbuttonPlus = new Button("+"); 
	static Button AGIbuttonMinus = new Button("-");
	static Button INTbuttonPlus10 = new Button("+10"); 
	static Button INTbuttonMinus10 = new Button("-10");
	static Button STRbuttonPlus10 = new Button("+10"); 
	static Button STRbuttonMinus10 = new Button("-10");
	static Button LUKbuttonPlus10 = new Button("+10"); 
	static Button LUKbuttonMinus10 = new Button("-10");
	static Button AGIbuttonPlus10 = new Button("+10"); 
	static Button AGIbuttonMinus10 = new Button("-10");
	static Button confirm = new Button("確定配點");
	static Button cancel = new Button("取消配點");
	
	static AnchorPane statusPointPane;
	
	static Label statusPoint = new Label("剩餘屬性點: " + player.getStatusPoint());//敏捷

	static ArrayList<Label> status = new ArrayList<>();
	static ArrayList<Button> statusB = new ArrayList<>();
	public statusUpdateEvent() {
		INTbuttonPlus10 = new Button("+10"); 
		INTbuttonMinus10 = new Button("-10");
		
		STRbuttonPlus10 = new Button("+10"); 
		STRbuttonMinus10 = new Button("-10");
		
		LUKbuttonPlus10 = new Button("+10"); 
		LUKbuttonMinus10 = new Button("-10");

		AGIbuttonPlus10 = new Button("+10"); 
		AGIbuttonMinus10 = new Button("-10");
		
		
		INTbuttonPlus = new Button("+"); 
		INTbuttonMinus = new Button("-");
		
		STRbuttonPlus = new Button("+"); 
		STRbuttonMinus = new Button("-");
		
		LUKbuttonPlus = new Button("+"); 
		LUKbuttonMinus = new Button("-");

		AGIbuttonPlus = new Button("+"); 
		AGIbuttonMinus = new Button("-");
		
		statusPointPane = new AnchorPane();

		status.add(INT);
		statusB.add(INTbuttonPlus10);
		statusB.add(INTbuttonPlus);
		statusB.add(INTbuttonMinus);
		statusB.add(INTbuttonMinus10);
		
		status.add(STR);
		statusB.add(STRbuttonPlus10);
		statusB.add(STRbuttonPlus);
		statusB.add(STRbuttonMinus);
		statusB.add(STRbuttonMinus10);
		
		status.add(LUK);
		statusB.add(LUKbuttonPlus10);
		statusB.add(LUKbuttonPlus);
		statusB.add(LUKbuttonMinus);
		statusB.add(LUKbuttonMinus10);
		
		status.add(AGI);
		statusB.add(AGIbuttonPlus10);
		statusB.add(AGIbuttonPlus);
		statusB.add(AGIbuttonMinus);
		statusB.add(AGIbuttonMinus10);
		status.add(statusPoint);
		for(int i = 0 ; i < 16 ; i ++) {
			statusB.get(i).setPrefSize(40, 10);
			statusB.get(i).setLayoutX(370+(i%4)*40);
			statusB.get(i).setLayoutY((i/4)*1*60+147);
			
		}
//		System.out.println("statusBsize : "+statusB.size());
		for(int i = 0 ; i < 5; i ++ ) {
			status.get(i).setFont(new Font(18));
			status.get(i).setTextFill(Color.AQUAMARINE);
			status.get(i).setLayoutX(60);
			status.get(i).setLayoutY(i*60+150);
		}
		Label sym = new Label("角色屬性盤");
		sym.setLayoutX(200);
		sym.setLayoutY(30);
		sym.setStyle("-fx-background-color: darkgray");
		sym.setFont(new Font(35));
		sym.setTextFill(Color.ALICEBLUE);
		statusPointPane.getChildren().addAll(sym,INT,STR,LUK,AGI,statusPoint,INTbuttonPlus10,INTbuttonPlus,INTbuttonMinus,INTbuttonMinus10,
				STRbuttonPlus10,STRbuttonPlus,STRbuttonMinus,STRbuttonMinus10,LUKbuttonPlus10,LUKbuttonPlus,LUKbuttonMinus,LUKbuttonMinus10,
				AGIbuttonPlus10,AGIbuttonPlus,AGIbuttonMinus,AGIbuttonMinus10,confirm,cancel);
		GUI.getStatusPane().getChildren().add(statusPointPane);

	}
	public void statusUpdata() {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {

				
				
				
				
				int totalTemp = STRtemp + LUKtemp + AGItemp + INTtemp;
				STR.setText("總力量: " + (player.getTotalSTR()+STRtemp)+ " ( " + (player.getSTR()+STRtemp) + " )" + "目前配了 " + STRtemp + " 點");//力量
				LUK.setText("總幸運: " + (player.getTotalLUK()+LUKtemp)+ " ( " + (player.getLUK()+LUKtemp) + " )" + "目前配了 " + LUKtemp + " 點");//幸運
				AGI.setText("總敏捷: " + (player.getTotalAGI()+AGItemp)+ " ( " + (player.getAGI()+AGItemp) + " )" + "目前配了 " + AGItemp + " 點");//敏捷
				INT.setText("總智慧: " + (player.getTotalINT()+INTtemp)+ " ( " + (player.getINT()+INTtemp) + " )" + "目前配了 " + INTtemp + " 點");//智慧
				statusPoint.setText("剩餘屬性點: " + (player.getStatusPoint()-totalTemp));
				System.out.println(player.getStatusPoint());
				if(totalTemp > 0) {
					cancel.setDisable(false);
					confirm.setDisable(false);
				}else {
					cancel.setDisable(true);
					confirm.setDisable(true);
				}
				if(player.getStatusPoint()<=0){
					cancel.setDisable(true);
					confirm.setDisable(true);
					INTbuttonPlus.setDisable(true);
					STRbuttonPlus.setDisable(true);
					AGIbuttonPlus.setDisable(true);
					LUKbuttonPlus.setDisable(true);	
					INTbuttonPlus10.setDisable(true);
					STRbuttonPlus10.setDisable(true);
					AGIbuttonPlus10.setDisable(true);
					LUKbuttonPlus10.setDisable(true);	
				}
				if(player.getStatusPoint()-totalTemp<=0) {
					INTbuttonPlus.setDisable(true);
					STRbuttonPlus.setDisable(true);
					AGIbuttonPlus.setDisable(true);
					LUKbuttonPlus.setDisable(true);	
					INTbuttonPlus10.setDisable(true);
					STRbuttonPlus10.setDisable(true);
					AGIbuttonPlus10.setDisable(true);
					LUKbuttonPlus10.setDisable(true);	
				}
				if(totalTemp<player.getStatusPoint()) {
					if(player.getStatusPoint()-totalTemp>=10) {
						INTbuttonPlus10.setDisable(false);
						STRbuttonPlus10.setDisable(false);
						AGIbuttonPlus10.setDisable(false);
						LUKbuttonPlus10.setDisable(false);
					}else {	
						INTbuttonPlus10.setDisable(true);							
						STRbuttonPlus10.setDisable(true);
						AGIbuttonPlus10.setDisable(true);
						LUKbuttonPlus10.setDisable(true);
					}
					
					INTbuttonPlus.setDisable(false);
					STRbuttonPlus.setDisable(false);
					AGIbuttonPlus.setDisable(false);
					LUKbuttonPlus.setDisable(false);					
				}else {
					INTbuttonPlus.setDisable(true);
					STRbuttonPlus.setDisable(true);
					AGIbuttonPlus.setDisable(true);
					LUKbuttonPlus.setDisable(true);
				
				}
				if(INTtemp>0) {
					INTbuttonMinus.setDisable(false);
				}else {
					INTbuttonMinus.setDisable(true);
				}
				if(STRtemp>0) {
					STRbuttonMinus.setDisable(false);
				}else {
					STRbuttonMinus.setDisable(true);
				}
				if(LUKtemp>0) {
					LUKbuttonMinus.setDisable(false);
				}else {
					LUKbuttonMinus.setDisable(true);
				}

				if(AGItemp>0) {
					AGIbuttonMinus.setDisable(false);
				}else {
					AGIbuttonMinus.setDisable(true);
				}
				if(INTtemp>=10) {
					INTbuttonMinus10.setDisable(false);
				}else {
					INTbuttonMinus10.setDisable(true);
				}
				if(STRtemp>=10) {
					STRbuttonMinus10.setDisable(false);
				}else {
					STRbuttonMinus10.setDisable(true);
				}
				if(LUKtemp>=10) {
					LUKbuttonMinus10.setDisable(false);
				}else {
					LUKbuttonMinus10.setDisable(true);
				}

				if(AGItemp>=10) {
					AGIbuttonMinus10.setDisable(false);
				}else {
					AGIbuttonMinus10.setDisable(true);
				}
				
//				if(statusPointPane.getChildren().isEmpty()) {
//					System.out.println(statusPointPane.getChildren().isEmpty() + "clear");
//					statusPointPane.getChildren().clear();
//				}

				confirm.setPrefSize(100, 20);
				confirm.setLayoutX(310);
				confirm.setLayoutY(387);
				cancel.setPrefSize(100, 20);
				cancel.setLayoutX(410);
				cancel.setLayoutY(387);
				confirm.setOnAction(e->{
					player.setStatusPoint(player.getStatusPoint()-totalTemp);
					player.setSTR(player.getSTR()+STRtemp);
					player.setINT(player.getINT()+INTtemp);
					player.setLUK(player.getLUK()+LUKtemp);
					player.setAGI(player.getAGI()+AGItemp);
					STRtemp =0;
					INTtemp =0;
					LUKtemp =0;
					AGItemp =0;
					player.updataPlayerStatus();
					
					GUI.statusPaneUpdata();
					GUI.manuBarUpdata(GUI.getPane2());
					statusUpdata();	
				});
				cancel.setOnAction(e->{
					INTtemp = 0;
					STRtemp = 0;
					AGItemp = 0;
					LUKtemp = 0;
					
					statusUpdata();
				});
				INTbuttonPlus10.setOnAction(e->{
					INTtemp+=10;
					statusUpdata();
					
				});
				INTbuttonMinus10.setOnAction(e->{
					INTtemp-=10;
					statusUpdata();
				});
				STRbuttonPlus10.setOnAction(e->{
					STRtemp+=10;
					statusUpdata();
					
				});
				STRbuttonMinus10.setOnAction(e->{
					STRtemp-=10;
					statusUpdata();
				});
				LUKbuttonPlus10.setOnAction(e->{
					LUKtemp+=10;
					statusUpdata();
					
				});
				LUKbuttonMinus10.setOnAction(e->{
					LUKtemp-=10;
					statusUpdata();
				});
				AGIbuttonPlus10.setOnAction(e->{
					AGItemp+=10;
					statusUpdata();
					
				});
				AGIbuttonMinus10.setOnAction(e->{
					AGItemp-=10;
					statusUpdata();
				});
				INTbuttonPlus.setOnAction(e->{
					INTtemp++;
					statusUpdata();
					
				});
				INTbuttonMinus.setOnAction(e->{
					INTtemp--;
					statusUpdata();
				});
				STRbuttonPlus.setOnAction(e->{
					STRtemp++;
					statusUpdata();
					
				});
				STRbuttonMinus.setOnAction(e->{
					STRtemp--;
					statusUpdata();
				});
				LUKbuttonPlus.setOnAction(e->{
					LUKtemp++;
					statusUpdata();
					
				});
				LUKbuttonMinus.setOnAction(e->{
					LUKtemp--;
					statusUpdata();
				});
				AGIbuttonPlus.setOnAction(e->{
					AGItemp++;
					statusUpdata();
					
				});
				AGIbuttonMinus.setOnAction(e->{
					AGItemp--;
					statusUpdata();
				});
				System.out.println("status size : "+status.size());
				
				

				statusPointPane.setPrefSize(550,550);
				statusPointPane.setLayoutX(600);
				statusPointPane.setLayoutY(60);
				
//				statusPointPane.setBackground(GUI.backgroundCreate("/Images/註冊與登入畫面背景.png"));
				statusPointPane.setStyle("-fx-background-color: #00000000;");
				System.out.println(statusPointPane.getChildren().isEmpty());
				//statusPointPane.getChildren().clear();
				System.out.println(statusPointPane.getChildren().isEmpty());
				System.out.println("h " + INTbuttonPlus.getHeight()+" w "+ INTbuttonPlus.getWidth());
								
			}
		});
	}
	public boolean checkIfHas() {
		return player.getStatusPoint() > 0 ? true : false;
	}//檢查能力點還有沒有
	public void setOnPane() {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				if(pane.getChildren().contains(statusPointPane)) {
					pane.getChildren().remove(statusPointPane);
				}
				confirm.setPrefSize(100, 20);
				confirm.setLayoutX(310);
				confirm.setLayoutY(337);
				cancel.setPrefSize(100, 20);
				cancel.setLayoutX(410);
				cancel.setLayoutY(337);
				INTbuttonPlus.setOnAction(e->{
					INTtemp++;
//					statusUpdata();
					
				});
				INTbuttonMinus.setOnAction(e->{
					INTtemp--;
	//				statusUpdata();
				});
				for(int i = 0 ; i < statusB.size() ; i ++) {
					statusB.get(i).setPrefSize(25, 10);
					statusB.get(i).setLayoutX(360+(i%2)*25);
					statusB.get(i).setLayoutY((i/2)*1*60+97);
				}
				for(int i = 0 ; i < status.size(); i ++ ) {
					status.get(i).setFont(new Font(16));
					status.get(i).setLayoutX(60);
					status.get(i).setLayoutY(i*60+100);
				}
				//pane.getChildren().add(statusPointPane);
			}
		});	
	}
}
