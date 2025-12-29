package GUI;

import java.net.URL;

import java.util.ArrayList;

import com.sun.glass.ui.EventLoop.State;

import Entities.Players;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class imageChange2{
	private Players player;
	private Stage stage2;
	public imageChange2(Players player,Stage stage2) {
		this.player = player;
		this.stage2 = stage2;
	}
	public void start() throws Exception {
		Stage stage = new Stage();
		ArrayList<Label> labels = new ArrayList<>();

		ImageView iV = new ImageView();
//		ImageView human = new ImageView();
		FadeTransition labelFadeTransition = new FadeTransition();
		FadeTransition fadeTransition = new FadeTransition();
		FadeTransition humanFadeTransition = new FadeTransition();

		iV.setFitHeight(540);
		iV.setFitWidth(960);
		iV.setImage(new Image("Images/販賣機.jpg"));
//		human.setImage(new Image("Images/oldman.png"));
//		human.setVisible(false);
		Label l1 = new Label("                       依然是 2021年4月15號凌晨三點的光復二舍...\n");
		Label l2 = new Label("				    	 你回到了飲料機前，耳邊似乎傳來了「謝謝你勇者」的話");
		Label l3 = new Label("						 (就像是一場夢呢...)");

		Label l4 = new Label("						手上的飲料也不再是什麼怪異藥水，而是普通的咖啡...\n");
		Label l5 = new Label("								(恭喜你通關遊戲!!)");
		
		labels.add(l5);
		labels.add(l4);
		labels.add(l3);
		labels.add(l2);
		labels.add(l1);
		
		Label name1 = new Label("我");
		name1.setTextFill(Color.BLACK);
		name1.setStyle("-fx-font-weight: bold;");
	
		name1.setVisible(false);
		name1.setLayoutX(185);
		name1.setLayoutY(325);
		name1.setFont(new Font(20));
		l1.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l2.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l3.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l4.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l5.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		
		l1.setOnMouseClicked(e->{
			l1.setVisible(false);
		});
		l2.setOnMouseClicked(e->{
			l2.setVisible(false);
		});
		l3.setOnMouseClicked(e->{
			l3.setVisible(false);
		});
		l4.setOnMouseClicked(e->{
			l4.setVisible(false);
		});
		l5.setOnMouseClicked(e->{
			l5.setVisible(false);
			stage.close();
		});
		for (Label label : labels) {
			label.setPrefSize(800, 145);
			label.setLayoutX(75);
			label.setLayoutY(325);
		}

		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(iV);
		for (Label label : labels) {
			ap.getChildren().add(label);
		}

//		ap.getChildren().addAll(name1);
		Scene scene = new Scene(ap);
		stage.setTitle("完結");
		stage.setScene(scene);
		stage.setHeight(540);
		stage.setWidth(960);
		stage.setResizable(false);
		stage.initOwner(stage2);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

	}

	private void makefadeout(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(2000));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
	}

	private void makefadeout2(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(3500));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
	}

	private void tempfadein(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(0));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	private void makefadein(Label label) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(4000));
		fadeTransition.setNode(label);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	private void tempfadeinhuman(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(0));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	private void humanfadein(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(800));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	private void makefadein(ImageView imageView) {
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(2000));
		fadeTransition.setNode(imageView);
		fadeTransition.setFromValue(0);
		fadeTransition.setToValue(1);
		fadeTransition.play();
	}

	private void shakinglabel(Label label) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), label);
		translateTransition.setByX(10f);
		translateTransition.setCycleCount(4);
		translateTransition.setAutoReverse(true);
		translateTransition.playFromStart();
	}

	private void shakingImage(ImageView imageView) {
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), imageView);
		translateTransition.setByX(5f);
		translateTransition.setCycleCount(4);
		translateTransition.setAutoReverse(true);
		translateTransition.playFromStart();
	}

}
