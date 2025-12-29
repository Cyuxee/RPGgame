package Events;

import Datas.DataCommander;
import Entities.Players;
import GUI.GUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class setNameEvent implements Runnable{
	private Players player;
	private Stage stage;
	private DataCommander data;
	private Scene scene;
	private boolean isNamed;
	private AnchorPane pane2;
	public setNameEvent(Players player,DataCommander data,boolean isNamed,Stage stage,Scene scene, AnchorPane pane2){
		this.player = player;
		this.stage = stage;
		this.data = data;
		this.isNamed = isNamed;
		this.scene = scene;
		this.pane2 = pane2;
	}
	
	@Override
	public void run() {
		GUI.setName(player, data, isNamed, stage, scene);
	}
}
