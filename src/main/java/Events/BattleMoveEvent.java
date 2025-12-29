package Events;


import Entities.Mobs;
import Entities.Players;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class BattleMoveEvent implements Runnable{
	private Label toMove1;
	private Label toMove2;
	private double origin1;
	private double origin2;
	private double distance1;
	private double distance2;
	private Button attack;
	private Button props;
	private Button skills;
	private Button run;
	private static Label damage1;
	private static Label damage2;
	private Thread td1;
	private Thread td2;
	private Thread t1;
	private Rectangle health;
	private AnchorPane combating;
	
	private Players player;
	private Mobs mob;

	public BattleMoveEvent(AnchorPane combating ,Rectangle health,Label damage1, Label damage2,Button attack,Button props,Button skills,Button run,Players player, Mobs mob ,Label toMove1,double distance1,Label toMove2,double distance2){
		this(new BattleMoveRequest(combating, health, damage1, damage2, attack, props, skills, run, player, mob, toMove1, distance1, toMove2, distance2));
	}

	public BattleMoveEvent(BattleMoveRequest request) {
		this.toMove1 = request.getToMove1();
		this.toMove2 = request.getToMove2();
		this.combating = request.getCombating();
		this.damage1 = request.getDamage1();
		this.damage2 = request.getDamage2();
		origin1 = this.toMove1.getLayoutX();
		origin2 = this.toMove2.getLayoutX();
		this.distance1 = request.getDistance1();
		this.distance2 = request.getDistance2();
		this.player = request.getPlayer();
		this.mob = request.getMob();
		this.attack = request.getAttack();
		this.props = request.getProps();
		this.skills = request.getSkills();
		this.run = request.getRun();
		this.health = request.getHealth();
	}
	@Override
	public void run() {
			Platform.runLater(() -> {
				attack.setDisable(true);
				props.setDisable(true);
				skills.setDisable(true);
				run.setDisable(true);
			});
			damageAndMoveDisplayEvent dmd = new damageAndMoveDisplayEvent(combating,health,attack,
					props,skills,run,damage1,damage2,player, 
					mob,toMove1,toMove2,distance1,distance2, 1,10,20);
			Thread worker = new Thread(dmd, "damage-move-display");
			worker.setDaemon(true);
			worker.start();
			// Controls will be re-enabled by downstream event logic when appropriate.
	}

	public static class BattleMoveRequest {
		private final AnchorPane combating;
		private final Rectangle health;
		private final Label damage1;
		private final Label damage2;
		private final Button attack;
		private final Button props;
		private final Button skills;
		private final Button run;
		private final Players player;
		private final Mobs mob;
		private final Label toMove1;
		private final double distance1;
		private final Label toMove2;
		private final double distance2;

		public BattleMoveRequest(AnchorPane combating, Rectangle health, Label damage1, Label damage2,
				Button attack, Button props, Button skills, Button run, Players player, Mobs mob,
				Label toMove1, double distance1, Label toMove2, double distance2) {
			this.combating = combating;
			this.health = health;
			this.damage1 = damage1;
			this.damage2 = damage2;
			this.attack = attack;
			this.props = props;
			this.skills = skills;
			this.run = run;
			this.player = player;
			this.mob = mob;
			this.toMove1 = toMove1;
			this.distance1 = distance1;
			this.toMove2 = toMove2;
			this.distance2 = distance2;
		}

		public AnchorPane getCombating() {
			return combating;
		}

		public Rectangle getHealth() {
			return health;
		}

		public Label getDamage1() {
			return damage1;
		}

		public Label getDamage2() {
			return damage2;
		}

		public Button getAttack() {
			return attack;
		}

		public Button getProps() {
			return props;
		}

		public Button getSkills() {
			return skills;
		}

		public Button getRun() {
			return run;
		}

		public Players getPlayer() {
			return player;
		}

		public Mobs getMob() {
			return mob;
		}

		public Label getToMove1() {
			return toMove1;
		}

		public double getDistance1() {
			return distance1;
		}

		public Label getToMove2() {
			return toMove2;
		}

		public double getDistance2() {
			return distance2;
		}
	}
}
