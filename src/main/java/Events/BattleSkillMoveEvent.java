package Events;


import Entities.Mobs;
import Entities.Players;
import Skills.Skills;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class BattleSkillMoveEvent implements Runnable{
	private Label toMove1;
	private Label toMove2;
	private double origin1;
	private int index;
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
	private Skills skill;
	private Players player;
	private Mobs mob;
	private AnchorPane combating;
	private Rectangle Mana;
	private Label healthCount;
	private Label ManaCount;

	
	public BattleSkillMoveEvent(int index,AnchorPane combating,Skills skill,Rectangle health,Label damage1, Label damage2,Button attack,Button props,Button skills,Button run,Players player, Mobs mob ,Label toMove1,double distance1,Label toMove2,double distance2){
		this.toMove1 = toMove1;
		this.index = index;
		this.combating = combating;
		this.toMove2 = toMove2;
		this.damage1 = damage1;
		this.damage2 = damage2;
		this.skill = skill;
		origin1 = this.toMove1.getLayoutX();
		origin2 = this.toMove2.getLayoutX();
		this.distance1 = distance1;
		this.distance2 = distance2;
		this.player = player;
		this.mob = mob;
		this.attack = attack;
		this.props = props;
		this.skills = skills;
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
			skillAndMoveEvent dmd = new skillAndMoveEvent(index,skill,health,attack,props,skills,run,damage1,damage2,player, mob,toMove1,toMove2,distance1,distance2, 1,10,20);
			Thread worker = new Thread(dmd, "skill-move-event");
			worker.setDaemon(true);
			worker.start();
			// Controls will be re-enabled by downstream event logic when appropriate.
	}
}
