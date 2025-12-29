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

public class imageChange{
	private Players player;
	private Thread tsetName;
	private Stage stage2;
	public imageChange(Players player,Thread tsetName,Stage stage2) {
		this.player = player;
		this.stage2 = stage2;
		this.tsetName = tsetName;
	}
	public void start() throws Exception {
		Stage stage = new Stage();
		ArrayList<Label> labels = new ArrayList<>();

		ImageView iV = new ImageView();
		ImageView human = new ImageView();
		FadeTransition labelFadeTransition = new FadeTransition();
		FadeTransition fadeTransition = new FadeTransition();
		FadeTransition humanFadeTransition = new FadeTransition();
		human.setFitHeight(400);
		human.setFitWidth(300);
		human.setLayoutX(570);
		human.setLayoutY(70);
		iV.setFitHeight(540);
		iV.setFitWidth(960);
		iV.setImage(new Image("Images/販賣機.jpg"));
		human.setImage(new Image("Images/oldman.png"));
		human.setVisible(false);
		Label l1 = new Label("                      2021年4月15號凌晨三點的光復二舍...\n");
		Label l2 = new Label(
				"                      你正在想辦法完成程設課期末專題的CODE，在幾次苦思無果的情況下，\n                      口渴的你決定先犒賞自己，\n                      所以今天不喝水，想下去樓下販賣機投點喝的。");
		Label l3 = new Label("                      正當你走到販賣機前...\n");
		Label l4 = new Label("                      今天要喝什麼好呢?\n" + "                      喝個咖啡提提神好了...\n");

		Label l5 = new Label("                      你蹲下身子拿起飲料，卻發現手中拿著的不是你想像中的咖啡，\n                      而是一罐長相奇特的飲品\n");
		Label l6 = new Label(
				"                      奇怪...\n                      這不是咖啡阿...\n                      是管理員放錯了嗎?\n");
		Label l7 = new Label("                      正當你這麼想時，一陣亮光朝你襲來。\n");
		Label l8 = new Label("                      突然的凌晨三點變成了大白天...\n");
		Label l9 = new Label("                      你在一個四周都無人的森林空地中站著，\n                      你的腳下有一片焦黑的泥土，甚是尷尬。\n");
		Label l10 = new Label("                      這是異世界召喚嗎???\n");
		Label l11 = new Label("                      看向手中的那個奇特造型的飲料，\n                      此時一隻長相奇特的兔子，朝你這衝了過來。\n");
		Label l12 = new Label("                      這到底是什麼鬼...\n");
		Label l13 = new Label(
				"                      你跑給了兔子追，兔子的速度不減，\n                      直到他撞到了你以後，你跌坐在地上，頓時感覺身體虛弱了不少，\n                      但兔子卻突然停了下來，像是在等待什麼。\n");
		Label l14 = new Label(
				"                      你看著他，牠看著你，\n                      就在你還搞不清楚狀況時，你又看到了一群人從森林的某一處朝你走了過來...\n");
		Label l15 = new Label(
				"                      人群前面有個帶頭的老人，它們穿著著中古世紀歐洲風的衣服，\n                      就像你以往所看過的任何異世界轉生作品那樣。\n");
		Label l16 = new Label("                      老人走到你面前，開口道:\n");
		Label l17 = new Label(
				"                      您是異世界的居民、【旅人】吧?\n                      這座村子早有預言說，災厄降臨前，天上會降下一道神之雷，\n                      負責導引【旅人】來此拯救蒼生。\n");
		Label l18 = new Label("                      為什麼...是我?");
		Label l19 = new Label(
				"                      這是神的旨意，\n                      沒有人知道神的想法是什麼，\n                      既然你都來了，代表你被神選中了。\n");
		Label l20 = new Label("                      怎麼證明我就是被神選中呢?\n");
		Label l21 = new Label(
				"                      第一，不遠處有個地方有一片焦黑，那是神之雷降下的地方，這附近也只有您一個人。\n                      第二，您的穿著風格不是這個世界會有的。\n");
		Label l22 = new Label("                      還有最重要的一點，\n                      您有發現在您前方的兔子一動也不動嗎?\n");
		Label l23 = new Label("                      這是神的加護，【戰鬥絕對領域】的效果。\n");
		Label l24 = new Label(
				"                      傳說中，只有被神召喚的人或是武藝登峰造極、近乎成神之人才會擁有，\n                      從古至今有紀載的不過三人，您是第四個，\n                      而第一位是上古時期大殺四方為人類謀得一片生路的英雄王。\n");
		Label l25 = new Label("                      再來便皆是經由神，透過召喚賦予技能的【旅人】們，\n                      【戰鬥絕對領域】有幾個效果:\n");
		Label l26 = new Label(
				"                      第一、技能絕對發動，發動後任何的人事物便不能再干涉戰鬥。\n                      第二、絕對由您開始進行行動。\n                      第三、對您有敵意的生物或是您想攻擊的生物，皆會被這個領域給限制，\n                         效果是行動的那一方在行動後會停下，並且等待另一方進行行動。\n");
		Label l27 = new Label(
				"                      當然您也可以選擇逃跑，只是如果逃跑失敗便會給予對方一次行動的機會，\n                      所謂的行動包括四種: 攻擊、使用技能、道具以及逃跑。\n");
		Label l28 = new Label("                      我知道了...雖然很混亂，\n                      但我大概了解了，那這個是什麼?\n");
		Label l29 = new Label(
				"                      我也不清楚，\n                      但有聽說過【旅人】除了會獲得【戰鬥絕對領域】的技能外，還會獲得神所贈與的物品，\n                      如果不清楚，使用看看便知道了。\n");
		Label l30 = new Label(
				"                      (這麼隨便的嗎...)\n                      我知道了，那我把牠喝掉吧。\n                      (打開後喝掉了，解口渴真爽，身體也感到莫名舒暢)\n");
		Label l31 = new Label("                      這樣也算是一次行動喔!\n");
		Label l32 = new Label("                      欸!!!\n                      (兔子對你衝撞)\n");
		Label l33 = new Label(
				"                      好像沒有剛剛被撞那麼痛了...\n                      而且身體裡面感到一股暖流在流竄著，太舒暢了...\n");
		Label l34 = new Label("                      攻擊牠吧。\n");
		Label l35 = new Label("                      恩。\n");
		Label l36 = new Label("                      結束戰鬥後，你跟著老人回到村子中。\n");
		Label l37 = new Label(
				"                      【旅人】阿，有任何問題或需要都能向我提出，\n                      我會盡全力滿足你的需求，請為蒼生解決即將來臨的災厄吧。\n");
		Label l38 = new Label("                      (有任何問題可以點擊村長詢問)");

		labels.add(l1);
		labels.add(l2);
		labels.add(l3);
		labels.add(l4);
		labels.add(l5);
		labels.add(l6);
		labels.add(l7);
		labels.add(l8);
		labels.add(l9);
		labels.add(l10);
		labels.add(l11);
		labels.add(l12);
		labels.add(l13);
		labels.add(l14);
		labels.add(l15);
		labels.add(l16);
		labels.add(l17);
		labels.add(l18);
		labels.add(l19);
		labels.add(l20);
		labels.add(l21);
		labels.add(l22);
		labels.add(l23);
		labels.add(l24);
		labels.add(l25);
		labels.add(l26);
		labels.add(l27);
		labels.add(l28);
		labels.add(l29);
		labels.add(l30);
		labels.add(l31);
		labels.add(l32);
		labels.add(l33);
		labels.add(l34);
		labels.add(l35);
		labels.add(l36);
		labels.add(l37);
		labels.add(l38);

		Label name1 = new Label("我");
		name1.setTextFill(Color.BLACK);
		name1.setStyle("-fx-font-weight: bold;");
		Label name2 = new Label("村長");
		name2.setTextFill(Color.BLACK);
		name2.setStyle("-fx-font-weight: bold;");
		name1.setVisible(false);
		name2.setVisible(false);
		name1.setLayoutX(185);
		name1.setLayoutY(325);
		name2.setLayoutX(185);
		name2.setLayoutY(325);
		name1.setFont(new Font(20));
		name2.setFont(new Font(20));
		l1.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l2.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l3.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l4.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l5.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l6.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l7.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l8.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l9.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l10.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l11.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l12.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l13.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l14.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l15.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l16.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l17.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l18.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l19.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l20.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l21.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l22.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l23.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l24.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l25.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l26.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l27.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l28.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l29.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l30.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l31.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l32.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l33.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l34.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l35.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l36.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l37.setStyle(
				"-fx-background-image: url(\"/Images/對話框.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");
		l38.setStyle(
				"-fx-background-image: url(\"/Images/對話框2.png\");" + "-fx-font-weight: bold;" + "-fx-font-size: 16px;");

		for (Label label : labels) {
			if (label.equals(l1)) {
				continue;
			}
			label.setVisible(false);
		}

		l1.setOnMouseClicked(e -> {
			l1.setVisible(false);
			l2.setVisible(true);
		});
		l2.setOnMouseClicked(e -> {
			l2.setVisible(false);
			l3.setVisible(true);
		});
		l3.setOnMouseClicked(e -> {
			l3.setVisible(false);
			l4.setVisible(true);
			name1.setVisible(true);
		});
		l4.setOnMouseClicked(e -> {
			l4.setVisible(false);
			l5.setVisible(true);
			name1.setVisible(false);
		});
		l5.setOnMouseClicked(e -> {
			l5.setVisible(false);
			l6.setVisible(true);
			name1.setVisible(true);
		});
		l6.setOnMouseClicked(e -> {
			l6.setVisible(false);
			l7.setVisible(true);
			name1.setVisible(false);
		});
		l7.setOnMouseClicked(e -> {

			l7.setVisible(false);
			makefadeout(iV);
			makefadein(l8);
			l8.setVisible(true);

		});
		l8.setOnMouseClicked(e -> {

			l8.setVisible(false);
			iV.setImage(new Image("Images/forest.jpg"));
			makefadein(iV);
			l9.setVisible(true);
			makefadein(l9);
		});
		l9.setOnMouseClicked(e -> {

			l9.setVisible(false);
			l10.setVisible(true);
			name1.setVisible(true);
			shakinglabel(l10);
			shakinglabel(name1);
		});
		l10.setOnMouseClicked(e -> {

			l10.setVisible(false);
			l11.setVisible(true);
			name1.setVisible(false);
			iV.setImage(new Image("Images/rabit.jpg"));

		});
		l11.setOnMouseClicked(e -> {

			l11.setVisible(false);
			l12.setVisible(true);
			name1.setVisible(true);

		});
		l12.setOnMouseClicked(e -> {

			l12.setVisible(false);
			l13.setVisible(true);
			name1.setVisible(false);
		});
		l13.setOnMouseClicked(e -> {
			l13.setVisible(false);
			l14.setVisible(true);
			iV.setImage(new Image("Images/village.png"));
		});
		l14.setOnMouseClicked(e -> {
			l14.setVisible(false);
			l15.setVisible(true);
			human.setVisible(true);
			humanfadein(human);
		});
		l15.setOnMouseClicked(e -> {

			l15.setVisible(false);
			l16.setVisible(true);

		});
		l16.setOnMouseClicked(e -> {

			l16.setVisible(false);
			l17.setVisible(true);
			shakingImage(human);
			name2.setVisible(true);
		});
		l17.setOnMouseClicked(e -> {
			l17.setVisible(false);
			l18.setVisible(true);
			human.setOpacity(0.8);
			name2.setVisible(false);
			name1.setVisible(true);
			shakinglabel(l18);
			shakinglabel(name1);
		});
		l18.setOnMouseClicked(e -> {
			l18.setVisible(false);
			l19.setVisible(true);
			human.setOpacity(1);
			name2.setVisible(true);
			name1.setVisible(false);
		});
		l19.setOnMouseClicked(e -> {
			l19.setVisible(false);
			l20.setVisible(true);
			human.setOpacity(0.8);
			name2.setVisible(false);
			name1.setVisible(true);

		});
		l20.setOnMouseClicked(e -> {
			l20.setVisible(false);
			l21.setVisible(true);
			human.setOpacity(1);
			name2.setVisible(true);
			name1.setVisible(false);
		});
		l21.setOnMouseClicked(e -> {
			l21.setVisible(false);
			l22.setVisible(true);
		});
		l22.setOnMouseClicked(e -> {
			l22.setVisible(false);
			l23.setVisible(true);
			iV.setImage(new Image("Images/war.jpg"));
			humanfadein(human);
			makefadein(iV);
		});
		l23.setOnMouseClicked(e -> {
			l23.setVisible(false);
			l24.setVisible(true);
		});
		l24.setOnMouseClicked(e -> {
			l24.setVisible(false);
			l25.setVisible(true);
		});
		l25.setOnMouseClicked(e -> {
			l25.setVisible(false);
			l26.setVisible(true);
			humanFadeTransition.setNode(human);
			humanFadeTransition.setDuration(Duration.millis(2000));
			humanFadeTransition.setFromValue(1);
			humanFadeTransition.setToValue(0);
			humanFadeTransition.setAutoReverse(true);
			humanFadeTransition.setCycleCount(2);
			humanFadeTransition.play();
			fadeTransition.setNode(iV);
			fadeTransition.setDuration(Duration.millis(2000));
			fadeTransition.setFromValue(1);
			fadeTransition.setToValue(0);
			fadeTransition.play();
		});
		l26.setOnMouseClicked(e -> {
			l26.setVisible(false);
			l27.setVisible(true);
			fadeTransition.stop();
			humanFadeTransition.stop();
			iV.setImage(null);
			iV.setOpacity(1);
			human.setOpacity(1);
		});
		l27.setOnMouseClicked(e -> {
			l27.setVisible(false);
			l28.setVisible(true);
			name1.setVisible(true);
			name2.setVisible(false);
			human.setOpacity(0.8);
			iV.setImage(new Image("Images/奇怪藥水.png"));
			iV.setFitHeight(300);
			iV.setFitWidth(610);
			iV.setLayoutX(168);
			iV.setLayoutY(20);
		});
		l28.setOnMouseClicked(e -> {
			human.setOpacity(1);
			l28.setVisible(false);
			l29.setVisible(true);
			name1.setVisible(false);
			name2.setVisible(true);

		});
		l29.setOnMouseClicked(e -> {
			human.setOpacity(0.8);
			l29.setVisible(false);
			l30.setVisible(true);
			name1.setVisible(true);
			name2.setVisible(false);
			iV.setImage(new Image("Images/恢復後.png"));

		});
		l30.setOnMouseClicked(e -> {
			l30.setVisible(false);
			l31.setVisible(true);
			name1.setVisible(false);
			name2.setVisible(true);
			human.setOpacity(1);
			shakingImage(human);
		});
		l31.setOnMouseClicked(e -> {
			human.setOpacity(0.8);
			l31.setVisible(false);
			l32.setVisible(true);
			name1.setVisible(true);
			name2.setVisible(false);
			shakinglabel(l32);
			shakinglabel(name1);
			iV.setImage(new Image("Images/恢復後.png"));
		});
		l32.setOnMouseClicked(e -> {
			human.setOpacity(0.8);
			l32.setVisible(false);
			l33.setVisible(true);
		});
		l33.setOnMouseClicked(e -> {
			human.setOpacity(1);
			l33.setVisible(false);
			l34.setVisible(true);
			name1.setVisible(false);
			name2.setVisible(true);
		});
		l34.setOnMouseClicked(e -> {
			l34.setVisible(false);
			l35.setVisible(true);
			name1.setVisible(true);
			name2.setVisible(false);
		});
		l35.setOnMouseClicked(e -> {
			l36.setVisible(true);
			l35.setVisible(false);
			name1.setVisible(false);
			fadeTransition.setDuration(Duration.millis(2000));
			fadeTransition.play();
			humanFadeTransition.setDuration(Duration.millis(2000));
			humanFadeTransition.setAutoReverse(false);
			humanFadeTransition.setCycleCount(1);
			humanFadeTransition.play();
			labelFadeTransition.setNode(l36);
			labelFadeTransition.setDuration(Duration.millis(4000));
			labelFadeTransition.setFromValue(0);
			labelFadeTransition.setToValue(1);
			labelFadeTransition.play();

		});
		l36.setOnMouseClicked(e -> {
			fadeTransition.stop();
			humanFadeTransition.stop();
			labelFadeTransition.stop();
			iV.setImage(new Image("Images/village.png"));
			iV.setOpacity(0);
			iV.setFitHeight(540);
			iV.setFitWidth(960);
			iV.setLayoutX(0);
			iV.setLayoutY(0);
			makefadein(human);
			makefadein(iV);
			human.setOpacity(0);
			l36.setVisible(false);
			l37.setVisible(true);
			name2.setVisible(true);
		});
		l37.setOnMouseClicked(e -> {
			l37.setVisible(false);
			l38.setVisible(true);
			name2.setVisible(false);
		});
		l38.setOnMouseClicked(e -> {
			l38.setVisible(false);
			makefadeout(human);
			makefadeout(iV);
			player.heal();
			player.mpHeal();
			tsetName.start();
			
			stage.close();
		});

		for (Label label : labels) {
			label.setPrefSize(800, 145);
			label.setLayoutX(75);
			label.setLayoutY(325);
		}

		AnchorPane ap = new AnchorPane();
		ap.getChildren().addAll(iV, human);
		for (Label label : labels) {
			ap.getChildren().add(label);
		}

		ap.getChildren().addAll(name1, name2);
		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.setHeight(540);
		stage.setWidth(960);
		stage.setResizable(false);
		stage.setTitle("序章");
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
