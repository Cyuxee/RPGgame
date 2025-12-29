package Events;

import java.util.EnumMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class damageDisplayEvent implements Runnable{
	private Label damage1 = new Label();
	private Label damage2 = new Label();
	private AnchorPane ap;
	private DisplayType type;
	private int damage;
	private static final Map<DisplayType, DamageDisplayStrategy> STRATEGIES = new EnumMap<>(DisplayType.class);

	static {
		STRATEGIES.put(DisplayType.PLAYER_DAMAGE, damageDisplayEvent::displayPlayer);
		STRATEGIES.put(DisplayType.PLAYER_HEAL, damageDisplayEvent::displayPlayerHeal);
		STRATEGIES.put(DisplayType.PLAYER_MP_HEAL, damageDisplayEvent::displayPlayerMpHeal);
		STRATEGIES.put(DisplayType.MOB_DAMAGE, damageDisplayEvent::displayMob);
		STRATEGIES.put(DisplayType.MOB_MISS, damageDisplayEvent::displayMobMiss);
		STRATEGIES.put(DisplayType.PLAYER_MISS, damageDisplayEvent::displayPlayerMiss);
		STRATEGIES.put(DisplayType.PLAYER_BOOM, damageDisplayEvent::displayPlayerBoom);
	}
	
	public damageDisplayEvent(AnchorPane ap,String index,int damage) {
		this(ap, DisplayType.fromLegacy(index), damage);
	}

	public damageDisplayEvent(AnchorPane ap, DisplayType type, int damage) {
		this.ap = ap;
		this.type = type;
		this.damage = damage;
	}
	@Override
	public void run() {
		DamageDisplayStrategy strategy = STRATEGIES.get(type);
		if (strategy == null) {
			throw new IllegalStateException("Unexpected damage display type: " + type);
		}
		strategy.display(this);
	}
	public void displayMobMiss() {//玩家的傷害顯示
		double originY= 30+((int)(Math.random()*20));

		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				
				damage2 = new Label();
				ap.getChildren().add(damage2);
				damage2.setText("MISS!!");
				damage2.setPrefHeight(200);
				damage2.setPrefWidth(500);
				damage2.setLayoutX(200+((int)(Math.random()*20)));
				damage2.setLayoutY(originY);
				damage2.setFont(new Font(25+((int)(Math.random()*5-2))));
				damage2.setTextFill(Color.RED);
				
			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage2.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Platform.runLater(()->{
			ap.getChildren().remove(damage2);
		});
		
	}
	public void displayPlayerBoom(){//玩家的傷害顯示
		double originY= 50+((int)(Math.random()*20));
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				damage1 = new Label();
				ap.getChildren().add(damage1);
				damage1.setText("(暴擊!!) -" + damage);
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(980+((int)(Math.random()*20)));
				damage1.setLayoutY(originY);//980 50 200 30
				damage1.setFont(new Font(30+((int)(Math.random()*5-2))));
				damage1.setTextFill(Color.RED);

			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			damage1.setLayoutY(originY-i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage1);
		});
}
	 		
	public void displayPlayerMiss() {//玩家的傷害顯示
		double originY= 50+((int)(Math.random()*20));
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				damage1 = new Label();
				ap.getChildren().add(damage1);
		
				damage1.setText("MISS!!");
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(980+((int)(Math.random()*20)));
				damage1.setLayoutY(originY);//980 50 200 30
				damage1.setFont(new Font(25+((int)(Math.random()*5-2))));
				damage1.setTextFill(Color.RED);
		 		
			
			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage1.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage1);
		});
		
	}
	public void displayPlayer()  {//玩家的傷害顯示
		double originY= 50+((int)(Math.random()*20));
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				damage1 = new Label();	
				ap.getChildren().add(damage1);
				damage1.setText("-" + damage);
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(980+((int)(Math.random()*20)));
				damage1.setLayoutY(originY);//980 50 200 30
				damage1.setFont(new Font(25+((int)(Math.random()*5-2))));
				damage1.setTextFill(Color.RED);
		 		

			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage1.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage1);
		});

	}
	public void displayMob() {//怪物的傷害顯示
		double originY= 30+((int)(Math.random()*20));

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				
			damage2 = new Label();	
			ap.getChildren().add(damage2);
	
			damage2.setText("- " + damage);
			damage2.setPrefHeight(200);
			damage2.setPrefWidth(500);
			damage2.setLayoutX(200+((int)(Math.random()*20)));
			damage2.setLayoutY(originY);
			damage2.setFont(new Font(25+((int)(Math.random()*5-2))));
			damage2.setTextFill(Color.RED);
	 
	
			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage2.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage2);
		});
	}
	public void displayPlayerHeal() {//玩家的治癒傷害顯示
		double originY= 60+((int)(Math.random()*20));

		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				damage1 = new Label();
				ap.getChildren().add(damage1);

				damage1.setText("+" + damage);
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(200+((int)(Math.random()*20)));
				damage1.setLayoutY(originY);
				damage1.setFont(new Font(25+((int)(Math.random()*5-2))));
				damage1.setStyle("-fx-font-weight: bold;");
				damage1.setTextFill(Color.LIGHTGREEN);
				damage1.setText("+" + damage);
			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage1.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage1);
		});
	}
	public void displayPlayerMpHeal() {//玩家的治癒傷害顯示
		double originY= 60+((int)(Math.random()*20));

		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				damage1 = new Label();
				ap.getChildren().add(damage1);
				damage1.setText("+" + damage);
				damage1.setPrefHeight(200);
				damage1.setPrefWidth(500);
				damage1.setLayoutX(170+((int)(Math.random()*20)));
				damage1.setLayoutY(originY);
				damage1.setFont(new Font(25+((int)(Math.random()*5-2))));
				damage1.setStyle("-fx-font-weight: bold;");
				damage1.setTextFill(Color.BLUE);
				damage1.setText("+" + damage);
		

			}
		});
		for(int i = 0 ; i < 25 ; i ++) {
			final int dy = i;
			Platform.runLater(() -> damage1.setLayoutY(originY - dy));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		Platform.runLater(()->{
			ap.getChildren().remove(damage1);
		});
	}

	@FunctionalInterface
	private interface DamageDisplayStrategy {
		void display(damageDisplayEvent ctx);
	}
	
	public enum DisplayType {
		PLAYER_DAMAGE,
		PLAYER_HEAL,
		PLAYER_MP_HEAL,
		MOB_DAMAGE,
		MOB_MISS,
		PLAYER_MISS,
		PLAYER_BOOM;

		public static DisplayType fromLegacy(String index) {
			return switch (index) {
			case "playerDamage" -> PLAYER_DAMAGE;
			case "playerHeal" -> PLAYER_HEAL;
			case "playerMpHeal" -> PLAYER_MP_HEAL;
			case "mobDamage" -> MOB_DAMAGE;
			case "mobMiss" -> MOB_MISS;
			case "playerMiss" -> PLAYER_MISS;
			case "playerBoom" -> PLAYER_BOOM;
			default -> throw new IllegalArgumentException("Unknown damage display index: " + index);
			};
		}
	}


}
