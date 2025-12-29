package Events;

import Entities.Mobs;
import GUI.GUI;
import Skills.skillStatus;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class mobStatusThread implements Runnable{
	private Label damage1;
	private int times;
	private double distance;
	private int sleepMilis;
	private Mobs mob;
	private skillStatus ss;
	public mobStatusThread(Mobs mob ,Label damage1,int times,double distance,skillStatus ss) {
		this.damage1= damage1;
		this.times = times;
		this.distance = distance;
		this.mob = mob ;
		this.ss = ss;
	}	
	
	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Platform.runLater(()->GUI.getCombating().getChildren().add(damage1));
		damage1.setVisible(true);
		if(ss.getName().equals("灼燒")) {
			damage1.setTextFill(Color.ORANGERED);
			damage1.setText("(灼燒)-" + (int)(ss.getRate()*GUI.getPlayer().getMagicDamage()));
		}else if(ss.getName().equals("治療")){
			damage1.setTextFill(Color.LIGHTGREEN);
			damage1.setText("(治療)+" + (int)(ss.getRate()*mob.getDamage()));
		}else if(ss.getName().equals("冰凍")){
			damage1.setText("(凍結)");
			damage1.setTextFill(Color.LIGHTBLUE);
		}else if(ss.getName().equals("增加命中")){
			damage1.setText("命中率提升!");
			damage1.setTextFill(Color.AQUA);
		}else if(ss.getName().equals("降低命中")){
			damage1.setText("命中率下降!");
			damage1.setTextFill(Color.RED);
		}else if(ss.getName().equals("增加閃躲值")){
			damage1.setText("閃躲值提升!");
			damage1.setTextFill(Color.AQUA);
		}else if(ss.getName().equals("減少閃躲值")){
			damage1.setText("閃躲值下降!");
			damage1.setTextFill(Color.RED);
		}else if(ss.getName().equals("增加物理傷害")){
			damage1.setText("傷害提升!");
			damage1.setTextFill(Color.AQUA);
		}else if(ss.getName().equals("降低物理傷害")){
			damage1.setText("傷害下降!");
			damage1.setTextFill(Color.RED);
		}else if(ss.getName().equals("增加護甲值")){
			damage1.setText("護甲提升!");
			damage1.setTextFill(Color.AQUA);
		}else if(ss.getName().equals("減少護甲值")){
			damage1.setText("護甲下降!");
			damage1.setTextFill(Color.RED);
		}
		
		double origin=55;//傷害標籤的起始值
		
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage1.setLayoutY(origin - dy));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
		Platform.runLater(()->GUI.getCombating().getChildren().remove(damage1));
	}
}
