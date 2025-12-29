package Main;
import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.GUI;
import javafx.scene.control.Button;

public class RPGgame{
	public static Button b1 ;
	public static Button b2 ;
	public static Button b3 ;
	public static Button start;

	public static void main(String[] args) {
		// 關閉 JavaFX CSS 警告
		Logger.getLogger("javafx.scene.CssStyleHelper").setLevel(Level.SEVERE);
		Logger.getLogger("javafx.css").setLevel(Level.SEVERE);
		
		GUI myGUI = new GUI();
		myGUI.Main(args);
	}
	
}
