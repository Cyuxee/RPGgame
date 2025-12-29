package Events;

import GUI.GUI;
import Skills.skillStatus;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class displayPlayer implements Runnable{
	private skillStatus ss;
	public displayPlayer(skillStatus ssL) {
		ss = ssL;
	}
				
			@Override
			public void run() {
				Thread tc = Thread.currentThread();
				Label statusL = new Label();
				skillStatus.setStatusL(statusL);
				statusL.setPrefHeight(200);
				statusL.setPrefWidth(200);
				statusL.setLayoutX(700+((int)(Math.random()*20)));
				statusL.setLayoutY(80+((int)(Math.random()*20)));
				statusL.setFont(new Font(25+((int)(Math.random()*5-2))));
				if(ss.getName().equals("灼燒")) {
					statusL.setTextFill(Color.DEEPPINK);
					statusL.setText("-" + (int)(ss.getRate()*GUI.getPlayer().getMagicDamage()));
				}else if(ss.getName().equals("治療")) {
					statusL.setTextFill(Color.LIGHTGREEN);
					statusL.setText("+" + (int)(ss.getRate()*GUI.getPlayer().getMagicDamage()));
				}else if(ss.getName().equals("凍結")) {
					statusL.setText("凍結");
					statusL.setTextFill(Color.LIGHTBLUE);
				}
				double origin1=statusL.getLayoutY();//傷害標籤的起始值
			Platform.runLater(() -> statusL.setVisible(true));
			for(int i = 0 ; i < 10 ;i ++) {
					final int index = i;
					Platform.runLater(() -> statusL.setLayoutY(origin1-index*1));
	
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					
					}
					
			}
			Platform.runLater(() -> statusL.setVisible(false));
				}

	}
