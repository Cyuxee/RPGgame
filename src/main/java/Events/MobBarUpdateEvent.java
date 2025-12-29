package Events;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MobBarUpdateEvent{
	
	private Players player;
	private Mobs mob;
	private Label mobCount;
	private Label mobStatus;
	private ProgressBar pbar;
	
	public MobBarUpdateEvent(Players player,Mobs mob,Label mobCount,Label mobStatus,ProgressBar pbar) {
		this.player = player;
		this.mob = mob; 
		this.mobCount = mobCount;
		this.mobStatus = mobStatus;
		this.pbar = pbar;
	}
	public void mobBarUpdate() {
		GUI.setMobCombating(player, mob, mobCount, mobStatus, pbar);
	}
}
