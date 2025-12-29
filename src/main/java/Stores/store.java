package Stores;

import java.util.ArrayList;
import java.util.Comparator;

import Entities.Players;
import GUI.GUI;
import GUI.GUI.propsUpSort;
import Objects.Objects;
import Objects.MobDrops.*;
import Objects.PropsPackage.*;
import Objects.WearingPackage.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

public class store {
	ArrayList<Objects> buying = new ArrayList<>();
	ArrayList<Objects> selling = new ArrayList<>();
	Players player = GUI.getPlayer();
	AnchorPane st = new AnchorPane();
	public store(AnchorPane st) {
		this.st = st;
		this.st.getChildren().clear();
	}
	public void updateList(VBox vb,boolean isBuying) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
			
				vb.getChildren().clear();
				if(isBuying==true) {
					for(int i = 0 ; i < buying.size() ; i ++) {
						Label la = new Label(buying.get(i).getName() +" x"+ buying.get(i).getAmount());
						vb.getChildren().add(la);
					}
				}else {
					for(int i = 0 ; i < selling.size() ; i ++) {
						Label la = new Label(selling.get(i).getName() + " x" + selling.get(i).getAmount());
						vb.getChildren().add(la);
					}
				}
				
			}
		});
	}
	public void updateAllList(VBox vb) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
			
				vb.getChildren().clear();
				
			}
		});
	}
	public int findStuffExist(String name,boolean isBuying) {
		if(isBuying==true) {
			for(int i = 0 ; i < buying.size() ; i ++) {
				if(buying.get(i).getName().equals(name)) {
					return i;
				}
			}
			return -1;
		}else {
			for(int i = 0 ; i < selling.size() ; i ++) {
				if(selling.get(i).getName().equals(name)) {
					return i;
				}
			}
			return -1;
		}
	}
	public void budgetRefresh(Label budget1,Label budget2,boolean isBuying) {
		int total = 0;
		int total2 = 0;
		if(isBuying==true) {
			for(int i = 0 ; i < buying.size() ; i ++) {
				if(buying.get(i).isDiamond()==true) {
					total2 += buying.get(i).getBuyPrice()*buying.get(i).getAmount();		
				}else {
					total += buying.get(i).getBuyPrice()*buying.get(i).getAmount();
				}
			}
			budget1.setText(String.valueOf(total));
			budget2.setText(String.valueOf(total2));
			if(Integer.valueOf(budget1.getText())>player.getMoney()) {
				budget1.setTextFill(Color.RED);
			}else {
				budget1.setTextFill(Color.BLACK);
			}
			if(Integer.valueOf(budget2.getText())>player.getDiamond()) {
				budget2.setTextFill(Color.RED);
			}else {
				budget2.setTextFill(Color.BLACK);
			}
		}else {
			for(int i = 0 ; i < selling.size() ; i ++) {
				if(selling.get(i).isDiamond()==true) {
					total2 += selling.get(i).getSellPrice()*selling.get(i).getAmount();		
				}else {
					total += selling.get(i).getSellPrice()*selling.get(i).getAmount();
				}
			}
			budget1.setText(String.valueOf(total));
			budget2.setText(String.valueOf(total2));	
			
		}
		
	}
	public void toSell() {

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Label title = new Label("販賣物品:");
				title.setStyle("-fx-font-weight: bolder;"
							  +"-fx-font-size: 20px");
				title.setLayoutX(10);
				title.setLayoutY(10);
				AnchorPane ap = new AnchorPane();
				ap.setLayoutX(730);
				ap.setLayoutY(20);
				ap.setPrefSize(350, 425);
				ap.setStyle("-fx-background-color: darkgray;"
						   +"-fx-border-width: 1mm;"
						   +"-fx-border-color: gray;");
				ScrollPane sp = new ScrollPane();
				VBox vb = new VBox();
				sp.setContent(vb);
				vb.setLayoutX(10);
				vb.setLayoutY(45);
				vb.setPrefSize(330, 240);
				vb.setStyle("-fx-background-color: white;");
				Label budget = new Label("預計獲得 " + "                                           " +" 枚金幣");
				
				budget.setTextFill(Color.YELLOW);
				budget.setStyle("-fx-font-size: 16px;"
						       +"-fx-font-weight: bold;");
				budget.setLayoutX(20);
				budget.setLayoutY(300);
				Label budNum = new Label("0");
				budNum.setStyle("-fx-font-size: 16px;"
						       +"-fx-font-weight: bold;");
				budNum.setPrefSize(150, 20);
				budNum.setAlignment(Pos.CENTER);
				budNum.setLayoutX(100);
				budNum.setLayoutY(300);
				Label budget2 = new Label("預計獲得 " + "                                           " +" 個魔源石");

				budget2.setTextFill(Color.AQUA);
				budget2.setStyle("-fx-font-size: 16px;"
						       +"-fx-font-weight: bold;");
				budget2.setLayoutX(20);
				budget2.setLayoutY(320);
				Label budNum2 = new Label("0");

				budNum2.setStyle("-fx-font-size: 16px;"
						       +"-fx-font-weight: bold;");
				budNum2.setPrefSize(150, 20);
				budNum2.setAlignment(Pos.CENTER);
				budNum2.setLayoutX(100);
				budNum2.setLayoutY(320);
				Button confirm = new Button("確定賣出(賣出不能後悔)");
				confirm.setLayoutX(10);
				confirm.setLayoutY(380);
				Button reset = new Button("清空選擇");
				reset.setLayoutX(190);
				reset.setLayoutY(380);
				
				confirm.setPrefSize(150,30);
				confirm.setOnAction(e->{
					for(int i = 0 ; i < selling.size() ; i ++) {
						player.getProps().get(selling.get(i).getSellIndex()).setAmount(player.getProps().get(selling.get(i).getSellIndex()).getAmount()-selling.get(i).getAmount());
						player.setMoney(player.getMoney()+selling.get(i).getAmount()*selling.get(i).getSellPrice());
						
					}
					
					buying.clear();
					selling.clear();
					
					propsSort();
					GUI.manuBarUpdata(GUI.getPane2());
					toSell();
				});
				reset.setPrefSize(150, 30);
				reset.setOnAction(e->{
					buying.clear();
					selling.clear();
					toSell();
				});
				ap.getChildren().addAll(title,vb,budget,budNum,budget2,budNum2,confirm,reset);
				
				Pagination page = new Pagination();
				page.setLayoutX(20);
				page.setLayoutY(20);
				page.setPrefSize(700, 425);
				page.setPageFactory(new Callback<Integer, Node>(){//背包面板
					AnchorPane inside;
					int index = 0;
					int count = 0;
					
					@Override
					public Node call(Integer param) {
						buying.clear();
						selling.clear();
						updateAllList(vb);
						index = 0;
						count = 0;
						inside = new AnchorPane();
						index+=8*(param);//一頁有48個
					
						for(int i = index ; i < player.getProps().size()&&count<8 ; i ++) {
							Button sellAll = new Button("全部");
							sellAll.setFont(new Font(9));
							Button plus = new Button("+");//增加
							Button minus = new Button("-");//減少
							GridPane gp = new GridPane();
							Label price;
							Objects ob = new Objects(player);
							ob.setIsDiamond(player.getProps().get(i).isDiamond());
							ob.setSellIndex(i);
							ob.setBuyPrice(player.getProps().get(i).getBuyPrice());
							ob.setSellPrice(player.getProps().get(i).getSellPrice());
							ob.setImage(player.getProps().get(i).getImage());
							ob.setName(player.getProps().get(i).getName());
							ob.setID(player.getProps().get(i).getID());
						
							if(player.getProps().get(i).isDiamond()==true) {
								price = new Label("價值 " + String.valueOf(player.getProps().get(i).getSellPrice()) + " 個魔源石");
								price.setTextFill(Color.AQUA);
								
							}else {
								price = new Label("價值 " + String.valueOf(player.getProps().get(i).getSellPrice()) + " 枚金幣");
								price.setTextFill(Color.YELLOW);
							}

							Label totalStuff = new Label("庫存: ");
							Label totalStuff2 = new Label(String.valueOf(player.getProps().get(i).getAmount()));
							Label nowNum = new Label("0");//現在的物品有幾個
							
							Label name = new Label(player.getProps().get(i).getName());
							Label graph = new Label();
							plus.setPrefSize(25, 25);
							minus.setPrefSize(25, 25);
							nowNum.setPrefSize(64, 25);
							nowNum.setAlignment(Pos.CENTER);
							
							nowNum.setStyle("-fx-background-color: lightgray;"
										   +"-fx-font-weight: bold;");
							totalStuff2.setStyle("-fx-font-weight: bold;");
							totalStuff.setStyle("-fx-font-weight: bold;");
							name.setStyle("-fx-font-weight: bold;");
							name.setTextFill(Color.LIGHTGREEN);
							graph.setPrefSize(64, 64);
							graph.setBackground(player.getProps().get(i).getImage());
							sellAll.setOnAction(e->{
								if(ob.getID()>=10000&&Integer.valueOf(nowNum.getText())==1) {
									updateList(vb, false);
									return;
								}
								nowNum.setText(totalStuff2.getText());		
								
								int index = findStuffExist(name.getText(), false);
								if(index!=-1&&ob.getID()<10000) {
									selling.get(index).setAmount(Integer.valueOf(nowNum.getText()));
									budgetRefresh(budNum, budNum2, false);
									updateList(vb, false);
								}else {
									ob.setAmount(Integer.valueOf(nowNum.getText()));
									selling.add(ob);
									budgetRefresh(budNum, budNum2, false);
									updateList(vb, false);
								}
							});
							plus.setOnMousePressed(e->{
								if(ob.getID()>=10000&&Integer.valueOf(nowNum.getText())==1) {
									updateList(vb, false);
									return;
								}
								if(Integer.valueOf(nowNum.getText())<Integer.valueOf(totalStuff2.getText())) {
									if(e.getClickCount()>=10) {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+(e.getClickCount()/2)));
									}else {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+1));		
									}
									if(Integer.valueOf(nowNum.getText())>Integer.valueOf(totalStuff2.getText())) {
										nowNum.setText(totalStuff2.getText());
										
									}
								}
								int index = findStuffExist(name.getText(), false);
								if(index!=-1&&ob.getID()<10000) {
									selling.get(index).setAmount(Integer.valueOf(nowNum.getText()));
									budgetRefresh(budNum, budNum2, false);
									updateList(vb, false);
								}else {
									ob.setAmount(Integer.valueOf(nowNum.getText()));
									selling.add(ob);
									budgetRefresh(budNum, budNum2, false);
									updateList(vb, false);
								}
							});
							minus.setOnMousePressed(e->{
								if(Integer.valueOf(nowNum.getText())==0) {
									return;
								}
								if(ob.getID()>=10000&&Integer.valueOf(nowNum.getText())==1) {
									selling.remove(ob);
									nowNum.setText("0");
									updateList(vb, false);
									return;
								}
								
								if(Integer.valueOf(nowNum.getText())>0) {
									if(e.getClickCount()>=10) {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())-(e.getClickCount()/2)));
									}else {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())-1));		
									}
									if(Integer.valueOf(nowNum.getText())<=0) {
										nowNum.setText("0");
									}
									ob.setAmount(Integer.valueOf(nowNum.getText()));
									budgetRefresh(budNum, budNum2, false);
								}
								if(ob.getAmount()<=0) {
									selling.remove(ob);
								}
								updateList(vb, false);				
							});
	//						gp.getChildren().addAll(totalStuff,graph,name,price,minus,nowNum,plus);
							gp.add(totalStuff, 0, 0);
							gp.add(totalStuff2, 1,0);
							gp.add(sellAll, 2, 3);
							gp.add(graph, 1, 1);
							gp.add(name, 1, 2);
							gp.add(price, 1, 3);
							gp.add(minus, 0, 4);
							gp.add(nowNum, 1, 4);
							gp.add(plus, 2, 4);
							totalStuff.setAlignment(Pos.CENTER);
							totalStuff2.setAlignment(Pos.CENTER);
							gp.setLayoutX(((i%8)%4)*165+30);
							gp.setLayoutY(((i%8)/4)*180+25);
							gp.setStyle("-fx-background-color: darksalmon;"
									   +"-fx-border-color:black;"
									   +"-fx-border-width:1mm;");
							
							inside.getChildren().add(gp);
							if(player.getProps().get(i).getAmount()==0) {
								gp.setDisable(true);
							}
							count++;
							}
						return inside;
					}
				});
				page.setStyle("-fx-background-color: darkgray;"
							 +"-fx-border-color: gray;"
						     +"-fx-border-width: 1mm;");
				page.setMaxPageIndicatorCount(5);
//				page.setPageCount(5);
				st.getChildren().addAll(page,ap);
			}
		});
	}
	public void toBuy() {
		Platform.runLater(new Runnable() {
			Label noMoney = new Label("金錢或魔源石不足!!\n"
					 +"(點擊這裡關閉此通知訊息)");

		@Override
		public void run() {
			
			Objects[] stuff = {new magicStone(player),new healer(player),new mpHealer(player),new healer2(player),new mpHealer2(player)
					  ,new healer3(player),new mpHealer3(player),new SkillsBook8(player),new SkillsBook9(player),new SkillsBook10(player)
					  ,new SkillsBook11(player),new SkillsBook12(player)};//商品
			
			
			noMoney.setTextAlignment(TextAlignment.CENTER);
			noMoney.setAlignment(Pos.CENTER);
			noMoney.setPrefSize(400, 200);
			noMoney.setLayoutX(300);
			noMoney.setLayoutY(150);
			noMoney.setStyle("-fx-background-color: lightgray;"
					  	 	+"-fx-border-color: darkgray;"
					  	    +"-fx-border-width: 1mm;"
					  	 	+"-fx-font-weight: bold;"
					  	    +"-fx-font-size: 20px;");
			noMoney.setVisible(false);
			noMoney.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event e) {
					noMoney.setVisible(false);
//					toBuy();
				}
				
			});
			Label title = new Label("購買物品:");
			title.setStyle("-fx-font-weight: bolder;"
						  +"-fx-font-size: 20px");
			title.setLayoutX(10);
			title.setLayoutY(10);
			
			AnchorPane ap = new AnchorPane();
			ap.setLayoutX(730);
			ap.setLayoutY(20);
			ap.setPrefSize(350, 425);
			ap.setStyle("-fx-background-color: darkgray;"
					   +"-fx-border-width: 1mm;"
					   +"-fx-border-color: gray;");
			ScrollPane sp = new ScrollPane();
			VBox vb = new VBox();
			sp.setContent(vb);
			vb.setLayoutX(10);
			vb.setLayoutY(45);
			vb.setPrefSize(330, 240);
			vb.setStyle("-fx-background-color: white;");
			Label budget = new Label("預計花費 " + "                                           " +" 枚金幣");
			
			budget.setTextFill(Color.YELLOW);
			budget.setStyle("-fx-font-size: 16px;"
					       +"-fx-font-weight: bold;");
			budget.setLayoutX(20);
			budget.setLayoutY(300);
			Label budNum = new Label("0");
			budNum.setStyle("-fx-font-size: 16px;"
					       +"-fx-font-weight: bold;");
			budNum.setPrefSize(150, 20);
			budNum.setAlignment(Pos.CENTER);
			budNum.setLayoutX(100);
			budNum.setLayoutY(300);
			Label budget2 = new Label("預計花費 " + "                                           " +" 個魔源石");

			budget2.setTextFill(Color.AQUA);
			budget2.setStyle("-fx-font-size: 16px;"
					       +"-fx-font-weight: bold;");
			budget2.setLayoutX(20);
			budget2.setLayoutY(320);
			Label budNum2 = new Label("0");

			budNum2.setStyle("-fx-font-size: 16px;"
					       +"-fx-font-weight: bold;");
			budNum2.setPrefSize(150, 20);
			budNum2.setAlignment(Pos.CENTER);
			budNum2.setLayoutX(100);
			budNum2.setLayoutY(320);
			Button confirm = new Button("確定購買");
			confirm.setLayoutX(10);
			confirm.setLayoutY(380);
			Button reset = new Button("清空選擇");
			reset.setLayoutX(190);
			reset.setLayoutY(380);
			
			confirm.setPrefSize(150,30);
			confirm.setOnAction(e->{
				if(Integer.valueOf(budNum.getText())<=player.getMoney()&&Integer.valueOf(budNum2.getText())<=player.getDiamond()) {
					for(int i = 0 ; i < buying.size() ; i ++) {
						if(buying.get(i).isDiamond()) {
							player.getProps().add(buying.get(i));
							player.setDiamond(player.getDiamond()-buying.get(i).getBuyPrice()*buying.get(i).getAmount());
						}else {
							player.getProps().add(buying.get(i));
							player.setMoney(player.getMoney()-buying.get(i).getBuyPrice()*buying.get(i).getAmount());
						}
					}
					buying.clear();
					selling.clear();
					amountUpdate(player);
					GUI.manuBarUpdata(GUI.getPane2());
					toBuy();
				}else {
					System.out.println("金錢或魔源石不足");
					noMoney.setVisible(true);
				}
				
				
			});
			reset.setPrefSize(150, 30);
			reset.setOnAction(e->{
				buying.clear();
				selling.clear();
				toBuy();
			});
			ap.getChildren().addAll(title,vb,budget,budNum,budget2,budNum2,confirm,reset);
			
			Pagination page = new Pagination();
			page.setLayoutX(20);
			page.setLayoutY(20);
			page.setPrefSize(700, 425);
			page.setPageFactory(new Callback<Integer, Node>(){//背包面板
				AnchorPane inside;
				int index = 0;
				int count = 0;
				
				@Override
				public Node call(Integer param) {
					buying.clear();
					selling.clear();

					updateAllList(vb);
					index = 0;
					count = 0;
					inside = new AnchorPane();
					index+=8*(param);//一頁有8個
				
					for(int i = index ; i < stuff.length&&count<8 ; i ++) {
						Objects temp = stuff[i];
						Button max = new Button("最大");
						max.setFont(new Font(9));
						Button plus = new Button("+");//增加
						Button minus = new Button("-");//減少
						GridPane gp = new GridPane();
						String priceNum = String.valueOf(stuff[i].getBuyPrice());
						Label price;
						int ID = stuff[i].getID();
						boolean isDm = stuff[i].isDiamond();
						if(stuff[i].isDiamond()==true) {
							price = new Label("售價 " + String.valueOf(stuff[i].getBuyPrice()) + " 個魔源石");
							price.setTextFill(Color.AQUA);
							
						}else {
							price = new Label("售價 " + String.valueOf(stuff[i].getBuyPrice()) + " 枚金幣");
							price.setTextFill(Color.YELLOW);
						}

						Label totalStuff = new Label("庫存: ");
						Label totalStuff2 = new Label(stuff[i].getProAmt());
						Label nowNum = new Label("0");//現在的物品有幾個
						
						Label name = new Label(stuff[i].getName());
						Label graph = new Label();
						plus.setPrefSize(25, 25);
						minus.setPrefSize(25, 25);
						nowNum.setPrefSize(64, 25);
						nowNum.setAlignment(Pos.CENTER);
						
						nowNum.setStyle("-fx-background-color: lightgray;"
									   +"-fx-font-weight: bold;");
						totalStuff2.setStyle("-fx-font-weight: bold;");
						totalStuff.setStyle("-fx-font-weight: bold;");
						name.setStyle("-fx-font-weight: bold;");
						name.setTextFill(Color.LIGHTGREEN);
						graph.setPrefSize(64, 64);
						graph.setBackground(stuff[i].getImage());
						max.setOnAction(e->{
							
							if(ID>=10000) {
								nowNum.setText("1");
								updateList(vb, true);
								return;
							}
							if(totalStuff2.getText().equals("無限")) {	
								if(isDm==true) {
									nowNum.setText(String.valueOf((int)(player.getDiamond()/Double.valueOf(priceNum))));		
								}else {
									nowNum.setText(String.valueOf((int)(player.getMoney()/Double.valueOf(priceNum))));			
								}
							}else {
								int number = (int)(player.getDiamond()/Double.valueOf(priceNum));
								if(number>Integer.valueOf(totalStuff2.getText())) {
									number = Integer.valueOf(totalStuff2.getText());
								}
								nowNum.setText(String.valueOf(number));
							}
							if(nowNum.getText().equals("0")) {
								return;
							}
							int index = findStuffExist(name.getText(), true);
							if(index!=-1&&ID<10000) {
								buying.get(index).setAmount(Integer.valueOf(nowNum.getText()));
								budgetRefresh(budNum, budNum2, true);
								updateList(vb, true);
							}else {
								temp.setAmount(Integer.valueOf(nowNum.getText()));
								buying.add(temp);
								budgetRefresh(budNum, budNum2, true);
								updateList(vb, true);
							}
						});
						plus.setOnMousePressed(e->{
							if(ID>=10000&&Integer.valueOf(nowNum.getText())==1) {
								updateList(vb, true);
								return;
							}
							if(totalStuff2.getText().equals("無限")) {
								if(e.getClickCount()>=10) {
									nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+(e.getClickCount()/2)));
								}else {
									nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+1));		
								}
							}else {
									if(e.getClickCount()>=10) {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+(e.getClickCount()/2)));
									}else {
										nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())+1));		
									}
									if(Integer.valueOf(nowNum.getText())>Integer.valueOf(totalStuff2.getText())) {
										nowNum.setText(totalStuff2.getText());
									}
							}
							int index = findStuffExist(name.getText(), true);
							if(index!=-1&&ID<10000) {
								buying.get(index).setAmount(Integer.valueOf(nowNum.getText()));
								budgetRefresh(budNum, budNum2, true);
								updateList(vb, true);
							}else {
								temp.setAmount(Integer.valueOf(nowNum.getText()));
								buying.add(temp);
								budgetRefresh(budNum, budNum2, true);
								updateList(vb, true);
							}
						});
						minus.setOnMousePressed(e->{
							if(Integer.valueOf(nowNum.getText())==0) {
								return;
							}
							if(temp.getID()>=10000&&Integer.valueOf(nowNum.getText())==1) {
								selling.remove(temp);
								nowNum.setText("0");
								updateList(vb, true);
								return;
							}
							
							if(Integer.valueOf(nowNum.getText())>0) {
								if(e.getClickCount()>=10) {
									nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())-(e.getClickCount()/2)));
								}else {
									nowNum.setText(String.valueOf(Integer.valueOf(nowNum.getText())-1));		
								}
								if(Integer.valueOf(nowNum.getText())<=0) {
									nowNum.setText("0");
								}
								temp.setAmount(Integer.valueOf(nowNum.getText()));
								budgetRefresh(budNum, budNum2, true);
							}
							if(temp.getAmount()<=0) {
								buying.remove(temp);
							}
							updateList(vb, true);				
						});
//						gp.getChildren().addAll(totalStuff,graph,name,price,minus,nowNum,plus);
						gp.add(totalStuff, 0, 0);
						gp.add(totalStuff2, 1,0);
						gp.add(graph, 1, 1);
						gp.add(name, 1, 2);
						gp.add(price, 1, 3);
						gp.add(minus, 0, 4);
						gp.add(max, 2, 3);
						gp.add(nowNum, 1, 4);
						gp.add(plus, 2, 4);
						totalStuff.setAlignment(Pos.CENTER);
						totalStuff2.setAlignment(Pos.CENTER);
						gp.setLayoutX(((i%8)%4)*167+5);
						gp.setLayoutY(((i%8)/4)*180+15);
						gp.setStyle("-fx-background-color: darksalmon;"
								   +"-fx-border-color:black;"
								   +"-fx-border-width:1mm;");
						
						inside.getChildren().add(gp);
						
						count++;
						}
					return inside;
				}
			});
			page.setStyle("-fx-background-color: darkgray;"
						 +"-fx-border-color: gray;"
					     +"-fx-border-width: 1mm;");
			page.setMaxPageIndicatorCount(5);
//			page.setPageCount(5);
			st.getChildren().addAll(page,ap,noMoney);
		}
	});
}
			
	public void propsSort() {
		int times = player.getProps().size();
		int flag= 1;
		for(int j = 0 ; j<times&&flag==1 ; j ++) {
			flag = 0;
			for(int i = 0 ; i < player.getProps().size() ; i ++) {
				if(player.getProps().get(i).getAmount()==0){
					player.getProps().remove(i);
					flag = 1;
				}
			}
		}
		for(int i = 0 ; i < player.getProps().size() ; i ++) {
			player.getProps().sort(new propsSort());
		}
}
	public void amountUpdate(Players player) {
		player.getProps().sort(new propsSort());
		for(int i = 0 ; i < player.getProps().size() ; i ++) {
			for(int j = i+1 ; j < player.getProps().size() ; j ++) {
				if(player.getProps().get(i).getID()<10000&&player.getProps().get(i).getID()==player.getProps().get(j).getID()) {
					player.getProps().get(i).setAmount(player.getProps().get(i).getAmount()+player.getProps().get(j).getAmount());//把相同ID東西的數量加起來
					player.getProps().remove(j);	
				}
			}
		}
		int times = player.getProps().size();
		int flag1=0;
		for(int j = 0 ; j < times&&flag1==0 ; j ++) {
			flag1=1;
			for(int i = 0 ; i < player.getProps().size() ; i ++) {
				if(player.getProps().get(i).getAmount()<=0) {
					player.getProps().remove(i);
					flag1=0;
				}
			}
		}
		int times2 = player.getProps().size();
		int flag2 = 0;
		for(int j = 0 ; j < times2&&flag2==0 ; j ++) {
			flag2 =1;
			for(int i = 0 ; i < player.getProps().size() ; i ++) {
				if(player.getProps().get(i).getID()==9999) {
					player.setDiamond(player.getDiamond()+player.getProps().get(i).getAmount());
					player.getProps().remove(i);
					flag2=0;
				}
			}
		}
		
	}
}
class propsSort implements Comparator<Objects>{

	@Override
	public int compare(Objects o1, Objects o2) {
		return o1.getID() - o2.getID();
	}
	
}
