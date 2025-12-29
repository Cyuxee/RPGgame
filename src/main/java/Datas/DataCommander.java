package Datas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import Entities.Players;
import Events.judgeWearingEvent;
import Objects.Objects;
import Skills.Skills;
import javafx.scene.control.Label;

public class DataCommander {
	private int i = 0;
	private int index;
	public DataCommander() {
		
	}
	public void dataIndexSave(Datas data) {
		data.setIndex(getDataCount()-1);
	}
	public void dataCreate(String username, String password) {
		try {
			Players playerTemp = new Players();
			
			FileWriter writer = new FileWriter("Datas/Player" + (getDataCount()+1) +".txt");
			writer.write("帳號: \n");
			writer.write(username);
			writer.write("\n");
			writer.write("密碼: \n");
			writer.write(password);
			writer.write("\n");
			writer.write("名稱: \n");//寫入
			writer.write(playerTemp.getPlayer());//寫入
			writer.write("\n");
			writer.write("等級: \n");
			writer.write(String.valueOf(playerTemp.getLevel()));//寫入
			writer.write("\n");
			writer.write("目前血量: \n");
			writer.write(String.valueOf((int)playerTemp.getHealth()));//寫入
			writer.write("\n");
			writer.write("目前魔力: \n");
			writer.write(String.valueOf((int)playerTemp.getMana()));//寫入
			writer.write("\n");
			writer.write("經驗值: \n");
			writer.write(String.valueOf((int)playerTemp.getExp()));//寫入
			writer.write("\n");
			writer.write("金錢: \n");
			writer.write(String.valueOf((int)playerTemp.getMoney()));//寫入
			writer.write("\n"); 
			writer.write("魔源石: \n");
			writer.write(String.valueOf((int)playerTemp.getDiamond()));//寫入
			writer.write("\n"); 
			writer.write("屬性: \n");
			writer.write(String.valueOf((int)playerTemp.getSTR()) +","+ String.valueOf((int)playerTemp.getINT()) +","+ String.valueOf((int)playerTemp.getAGI()) +","+ String.valueOf((int)playerTemp.getLUK()));//寫入
			writer.write("\n");
			writer.write(String.valueOf(playerTemp.getStatusPoint()));
			writer.write("\n");
			writer.write("道具: \n");
			for(int i = 0 ; i < playerTemp.getProps().size() ; i ++) {
				if(i==playerTemp.getProps().size()-1) {
					writer.write(String.valueOf((int)playerTemp.getProps().get(i).getID()));//寫入
				}else if(i!=playerTemp.getProps().size()-1) {
					writer.write(String.valueOf((int)playerTemp.getProps().get(i).getID()+","));//寫入
				}	
			}
			writer.write("\n");
			writer.write("道具數量: \n");
			for(int i = 0 ; i < playerTemp.getProps().size() ; i ++) {
				if(i==playerTemp.getProps().size()-1) {
					writer.write(String.valueOf((int)playerTemp.getProps().get(i).getAmount()));//寫入
				}else if(i!=playerTemp.getProps().size()-1) {
					writer.write(String.valueOf((int)playerTemp.getProps().get(i).getAmount()+","));//寫入
				}	
			}
			writer.write("\n");

			writer.write("技能: \n");//需要寫一個對應表
			if(playerTemp.getSkills().size()==0) {
				writer.write("0");
				playerTemp.getSkills().add(((Skills.getDataSkillsCreate(playerTemp, 0))));
			}
			for(int i = 0 ; i < playerTemp.getSkills().size() ; i ++) {
				if(i==playerTemp.getSkills().size()-1) {
					
					writer.write(String.valueOf((int)playerTemp.getSkills().get(i).getID()));//寫入
				}else if(i!=playerTemp.getSkills().size()-1) {
					writer.write(String.valueOf((int)playerTemp.getSkills().get(i).getID() + ","));//寫入
				}
			}
			writer.write("\n");
			writer.write("裝備: \n");
			writer.write("武器: \n");
			writer.write("無\n");
			writer.write("頭盔: \n");
			writer.write("無\n");
			writer.write("衣服: \n");
			writer.write("無\n");
			writer.write("褲子: \n");
			writer.write("無\n");
			writer.write("鞋子: \n");
			writer.write("無\n");
			writer.write("通關: \n");
			writer.write("false\n");
			
			writer.close();//關閉
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void dataSave(Players player,Datas data) {//noFirst yes = 1 ,no = 0;
		try {
			//System.out.println(data.getUsername());
			//System.out.println(data.getPassword());檢查是否讀入正確帳號密碼
			FileWriter writer = new FileWriter("Datas/Player" + data.getIndex() +".txt");
			amountUpdate(player);
			writer.write("帳號: \n");
			writer.write(data.getUsername());
			writer.write("\n");
			writer.write("密碼: \n");
			writer.write(data.getPassword());
			writer.write("\n");
			writer.write("名稱: \n");//寫入
			writer.write(player.getPlayer());//寫入
			writer.write("\n");
			writer.write("等級: \n");
			writer.write(String.valueOf(player.getLevel()));//寫入
			writer.write("\n");
			writer.write("目前血量: \n");
			writer.write(String.valueOf((int)player.getHealth()));//寫入
			writer.write("\n");
			writer.write("目前魔力: \n");
			writer.write(String.valueOf((int)player.getMana()));//寫入
			writer.write("\n");
			writer.write("經驗值: \n");
			writer.write(String.valueOf((int)player.getExp()));//寫入
			writer.write("\n");
			writer.write("金錢: \n");
			writer.write(String.valueOf((int)player.getMoney()));//寫入
			writer.write("\n");
			writer.write("魔源石: \n");
			writer.write(String.valueOf((int)player.getDiamond()));//寫入
			writer.write("\n");
			writer.write("屬性: \n");
			writer.write(String.valueOf((int)player.getSTR()) +","+ String.valueOf((int)player.getINT()) +","+ String.valueOf((int)player.getAGI()) +","+ String.valueOf((int)player.getLUK()));//寫入
			writer.write("\n");
			writer.write(String.valueOf(player.getStatusPoint()));
			writer.write("\n");
			writer.write("道具: \n");
			if(player.getProps().size()==0) {
				writer.write("無");
			}else {
				for(int i = 0 ; i < player.getProps().size() ; i ++) {
					if(i==player.getProps().size()-1) {
						writer.write(String.valueOf((int)player.getProps().get(i).getID()));//寫入
					}else if(i!=player.getProps().size()-1) {
						writer.write(String.valueOf((int)player.getProps().get(i).getID()+","));//寫入
					}	
				}
			}
			writer.write("\n");
			writer.write("道具數量: \n");
			if(player.getProps().size()==0) {
				writer.write("無");
			}else {
				for(int i = 0 ; i < player.getProps().size() ; i ++) {
					if(i==player.getProps().size()-1) {
						writer.write(String.valueOf((int)player.getProps().get(i).getAmount()));//寫入
					}else if(i!=player.getProps().size()-1) {
						writer.write(String.valueOf((int)player.getProps().get(i).getAmount()+","));//寫入
					}	
				}
			}
			writer.write("\n");

			writer.write("技能: \n");//需要寫一個對應表
			if(player.getSkills().size()==0) {
				writer.write("0");
				player.getSkills().add(((Skills.getDataSkillsCreate(player, 0))));
			}else {
				for(int i = 0 ; i < player.getSkills().size() ; i ++) {
					if(i==player.getSkills().size()-1) {
						writer.write(String.valueOf((int)player.getSkills().get(i).getID()));//寫入
					}else if(i!=player.getSkills().size()-1) {
						writer.write(String.valueOf((int)player.getSkills().get(i).getID() + ","));//寫入
					}
				}
			}
			writer.write("\n");
			writer.write("裝備: \n");
			writer.write("武器: \n");
			if(player.getWearingByPart("WEAPON")==null) {
				writer.write("無\n");
			}else {
				writer.write("ID: \n");
				writer.write(String.valueOf(player.getWearingByPart("WEAPON").getID()));
				writer.write("\n");
				writer.write("強化等級: \n");
				writer.write(String.valueOf(player.getWearingByPart("WEAPON").getStrength()));
				writer.write("\n");
			}
			writer.write("頭盔: \n");
			if(player.getWearingByPart("HELMET")==null) {
				writer.write("無\n");
			}else {
				writer.write("ID: \n");
				writer.write(String.valueOf(player.getWearingByPart("HELMET").getID()));
				writer.write("\n");
				writer.write("強化等級: \n");
				writer.write(String.valueOf(player.getWearingByPart("HELMET").getStrength()));
				writer.write("\n");
			}
			writer.write("衣服: \n");
			if(player.getWearingByPart("ARMOR")==null) {
				writer.write("無\n");
			}else {
				writer.write("ID: \n");
				writer.write(String.valueOf(player.getWearingByPart("ARMOR").getID()));
				writer.write("\n");
				writer.write("強化等級: \n");
				writer.write(String.valueOf(player.getWearingByPart("ARMOR").getStrength()));
				writer.write("\n");
			}
			writer.write("褲子: \n");
			if(player.getWearingByPart("PANTS")==null) {
				writer.write("無\n");
			}else {
				writer.write("ID: \n");
				writer.write(String.valueOf(player.getWearingByPart("PANTS").getID()));
				writer.write("\n");
				writer.write("強化等級: \n");
				writer.write(String.valueOf(player.getWearingByPart("PANTS").getStrength()));
				writer.write("\n");
			}
			writer.write("鞋子: \n");
			if(player.getWearingByPart("SHOES")==null) {
				writer.write("無\n");
			}else {
				writer.write("ID: \n");
				writer.write(String.valueOf(player.getWearingByPart("SHOES").getID()));
				writer.write("\n");
				writer.write("強化等級: \n");
				writer.write(String.valueOf(player.getWearingByPart("SHOES").getStrength()));
				writer.write("\n");
			}

			writer.write("通關: \n");
			writer.write(String.valueOf(player.isEnd()));//寫入
			writer.write("\n");

			writer.close();//關閉
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public int dataChecker(String User,int index) {//確認檔案內有沒有這個東西
		try {
			File reader = new File("Datas/Player" + index + ".txt");
			Scanner scan = new Scanner(reader);
			if(!reader.exists()) {
				return 0;//case 0 = 沒有東西
			}else {
				String userTitle = scan.nextLine();
				//System.out.println("userti" + userTitle);這是在確認有沒有相同的帳號
				
				String user = scan.nextLine();
				//System.out.println("user" + user);

				if(userTitle.equals("帳號: ")) {
					if(user.equals(User)) {
						return 1;//case 1 = 有人註冊過
					}
				}
				return 2;//case 2 = 可以註冊
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 3;
	}
	public int getDataCount() {//給到目前檔案最大的那個index
		int count=0;
		File reader = new File("Datas/Player" + count + ".txt");//至少要有一個檔案..懶得寫判斷
		
		while(reader.exists()) {
			count++;
			reader = new File("Datas/Player" + count + ".txt");//至少要有一個檔案..懶得寫判斷
		}
		return count-1;
	}
	public boolean userChecker(String User,String Pass,int index) {//從零開始找到有帳號的那個檔案，然後把index值帶回去
		try {
			File reader = new File("Datas/Player" + index + ".txt");
			Scanner scan = new Scanner(reader);
			if(!reader.exists()) {
				System.out.println("帳號密碼錯誤!");//case 0 = 沒有東西
				return false;
			}else {
				String userTitle = scan.nextLine();
				String user = scan.nextLine();
				String passTitle = scan.nextLine();
				String pass = scan.nextLine();
				if(userTitle.equals("帳號: ")) {
					if(user.equals(User)&&pass.equals(Pass)) {
						return true;
					}else {
						return false;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("讀取錯誤!");
		return false;
	}
	public void dataLoad(Players player,Datas data) {				
			try {
			File reader = new File("Datas/Player" + data.getIndex() + ".txt");
			Scanner scan = new Scanner(reader);
			
			String[] propRecord = null;
			String[] propAmountRecord = null;
			String[] skillRecord = null;
			String[] wearingRecord = null;
			String wearing = null;
			
			String usertitle = scan.nextLine();
			String username = null;
			String passtitle = null;
			String password = null;
			
			String moneyTitle = null;
			String diamondTitle = null;
			String propTitle = null;
			String skillTitle = null;
			
			String mptitle = null;
			String nametitle = null;
			String propAmountTitle = null;
			String leveltitle = null;
			String hptitle = null;
			String exptitle = null;
			String name = null;
			
			String weaponTitle = null;
			String helmetTitle = null;
			String armorTitle = null;
			String pantsTitle = null;
			String shoesTitle = null;
			
			String weapon = null;
			String weaponStr = null;
			
			String helmet = null;
			String helmetStr = null;

			String armor = null;
			String armorStr = null;
		
			String pants = null;
			String pantsStr = null;
			
			String shoes = null;
			String shoesStr = null;
			
			String propAmount=null;
			String level=null;
			String maxhp=null;
			String minhp=null;
			String mp=null;
			String hp=null;
			String exp=null;
			String money=null;
			String diamond=null;
			String prop=null;
			String skill=null;
			String statusTitle = null;
			String status = null;
			String statusPoint = null;
			String[] statusNowPoint = null;
			String wearingTitle = null;
			String endTitle = null;
			String end = null;
				//System.out.println(scan.nextLine());
				if(usertitle.equals("帳號: ")) {
			        username = scan.nextLine();
					data.setUsername(username);
			        passtitle = scan.nextLine();
				}if(passtitle.equals("密碼: ")) {
			        password = scan.nextLine();
					data.setPassword(password);
			        nametitle = scan.nextLine();
				}if(nametitle.equals("名稱: ")) {
			        name = scan.nextLine();
					player.setPlayer(name);
			        leveltitle = scan.nextLine();
				}if(leveltitle.equals("等級: ")) {
					level = scan.nextLine();
					player.setLevel(Integer.parseInt(level));
					hptitle = scan.nextLine();
				}if(hptitle.equals("目前血量: ")) {
					hp=scan.nextLine();
					player.setHealth(Integer.parseInt(hp));
					mptitle=scan.nextLine();
				}if(mptitle.equals("目前魔力: ")) {
					mp=scan.nextLine();
					player.setMana(Integer.parseInt(mp));
					exptitle=scan.nextLine();
				}if(exptitle.equals("經驗值: ")) {
					exp=scan.nextLine();
					player.setExp(Double.parseDouble(exp));
					moneyTitle = scan.nextLine();
				}if(moneyTitle.equals("金錢: ")) {
					money = scan.nextLine();
					player.setMoney(Integer.parseInt(money));
					diamondTitle=scan.nextLine();
				}if(diamondTitle.equals("魔源石: ")) {
					diamond = scan.nextLine();
					player.setDiamond(Integer.parseInt(diamond));
					statusTitle = scan.nextLine();
				}if(statusTitle.equals("屬性: ")) {
					status = scan.nextLine();//屬性格
					statusNowPoint = status.split(",");//屬性目前點數 STR INT AGI LUK
					statusPoint = scan.nextLine();//剩餘點數
					propTitle = scan.nextLine();
				}if(propTitle.equals("道具: ")) {
					prop = scan.nextLine();
					propRecord = prop.split(",");
					propAmountTitle = scan.nextLine();	
				}if(propAmountTitle.equals("道具數量: ")) {
					propAmount = scan.nextLine();
					propAmountRecord = propAmount.split(",");
					skillTitle = scan.nextLine();
				}if(skillTitle.equals("技能: ")) {
					skill=scan.nextLine();
					skillRecord = skill.split(",");
					wearingTitle = scan.nextLine();
				}if(wearingTitle.equals("裝備: ")) {
					weaponTitle = scan.nextLine();
				}if(weaponTitle.equals("武器: ")) {
					weapon = scan.nextLine();
						if(weapon.equals("ID: ")) {
							String ID = scan.nextLine();
							String nowStr = scan.nextLine();
							if(nowStr.equals("強化等級: ")) {
								String str = scan.nextLine();
								if(!(Integer.parseInt(ID)==1000||Integer.parseInt(ID)==4000||Integer.parseInt(ID)==4001||Integer.parseInt(ID)==4002||Integer.parseInt(ID)==4003)) {
									player.setWearings("WEAPON", Objects.getDataWearingsCreate(player,Integer.parseInt(ID),Integer.parseInt(str)));
								}
							}
						}
					helmetTitle = scan.nextLine();
				}if(helmetTitle.equals("頭盔: ")) {
					helmet = scan.nextLine();
					if(!helmet.equals("無")) {
						if(helmet.equals("ID: ")) {
							String ID = scan.nextLine();
							String nowStr = scan.nextLine();
							if(nowStr.equals("強化等級: ")) {
								String str = scan.nextLine();
								if(!(Integer.parseInt(ID)==1000||Integer.parseInt(ID)==4000||Integer.parseInt(ID)==4001||Integer.parseInt(ID)==4002||Integer.parseInt(ID)==4003)) {
									player.setWearings("HELMET", Objects.getDataWearingsCreate(player,Integer.parseInt(ID),Integer.parseInt(str)));
								}
							}
					
						}
					}
					armorTitle = scan.nextLine();
					
				}if(armorTitle.equals("衣服: ")) {
					armor = scan.nextLine();
					if(!armor.equals("無")) {
						if(armor.equals("ID: ")) {
							String ID = scan.nextLine();
							String nowStr = scan.nextLine();
							if(nowStr.equals("強化等級: ")) {
								String str = scan.nextLine();
								if(!(Integer.parseInt(ID)==1000||Integer.parseInt(ID)==4000||Integer.parseInt(ID)==4001||Integer.parseInt(ID)==4002||Integer.parseInt(ID)==4003)) {
									player.setWearings("ARMOR", Objects.getDataWearingsCreate(player,Integer.parseInt(ID),Integer.parseInt(str)));
								}
							}
					
						}
					}
					pantsTitle = scan.nextLine();
				}if(pantsTitle.equals("褲子: ")) {
					pants = scan.nextLine();
					if(!pants.equals("無")) {
						if(pants.equals("ID: ")) {
							String ID = scan.nextLine();
							String nowStr = scan.nextLine();
							if(nowStr.equals("強化等級: ")) {
								String str = scan.nextLine();
								if(!(Integer.parseInt(ID)==1000||Integer.parseInt(ID)==4000||Integer.parseInt(ID)==4001||Integer.parseInt(ID)==4002||Integer.parseInt(ID)==4003)) {
									player.setWearings("PANTS", Objects.getDataWearingsCreate(player,Integer.parseInt(ID),Integer.parseInt(str)));
								}
							}
					
						}
					}
					shoesTitle = scan.nextLine();
				}if(shoesTitle.equals("鞋子: ")) {
					shoes = scan.nextLine();
					if(!shoes.equals("無")) {
						if(shoes.equals("ID: ")) {
							String ID = scan.nextLine();
							String nowStr = scan.nextLine();
							if(nowStr.equals("強化等級: ")) {
								String str = scan.nextLine();
								if(!(Integer.parseInt(ID)==1000||Integer.parseInt(ID)==4000||Integer.parseInt(ID)==4001||Integer.parseInt(ID)==4002||Integer.parseInt(ID)==4003)) {
									player.setWearings("SHOES", Objects.getDataWearingsCreate(player,Integer.parseInt(ID),Integer.parseInt(str)));
								}
							}
					
						}
					}
					endTitle = scan.nextLine();
				}if(endTitle.equals("通關: ")) {
					end = scan.nextLine();
					player.setIsEnd(Boolean.valueOf(end));
				}
				Label wtemp = new Label();
				judgeWearingEvent.areaLabel(wtemp,player.getWearingByPart("WEAPON"));
				player.getArea().put(0,wtemp);
				Label htemp = new Label();
				judgeWearingEvent.areaLabel(htemp,player.getWearingByPart("HELMET"));
				player.getArea().put(1,htemp);
				Label atemp = new Label();
				judgeWearingEvent.areaLabel(atemp,player.getWearingByPart("ARMOR"));
				player.getArea().put(2,atemp);
				Label ptemp = new Label();
				judgeWearingEvent.areaLabel(ptemp,player.getWearingByPart("PANTS"));
				player.getArea().put(3,ptemp);
				Label stemp = new Label();
				judgeWearingEvent.areaLabel(stemp,player.getWearingByPart("SHOES"));
				player.getArea().put(4,stemp);
				
				
				if(!prop.equals("無")&&!propAmount.equals("無")) {
					for(int i = 0 ; i < propRecord.length ; i ++) {
//						System.out.println(i+"." +player.getPlayer()+" "+propRecord[i] + " 個別數量: " + propAmountRecord[i] + " 數量總共: " + propRecord.length);
						player.getProps().add(Objects.getDataPropsCreate(player, Integer.parseInt(propRecord[i]),Integer.parseInt(propAmountRecord[i])));
					}	
				}
				if(!skill.equals("無")) {
					for(int i = 0 ; i < skillRecord.length ; i ++) {
						player.getSkills().add(Skills.getDataSkillsCreate(player,Integer.parseInt(skillRecord[i])));
					}
				}
				player.setStatusPoint(Integer.parseInt(statusPoint));
				for(int i = 0 ; i < 4 ; i ++) {
					player.setStatus(i,Integer.parseInt(statusNowPoint[i]));
				}
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}
//	public void dataOutput(Players player,String URL) {//這是後來學到的2021.4.27
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(URL));
//			oos.writeObject(player);
//			oos.close();
//		
//		
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	public void dataInput(Players player,String URL) {
//		try {
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL));
//			try {
//				player = (Players)ois.readObject();
//				
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}		
//		
//		
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	public boolean dataExist(int index) {
		try {
			File reader = new File("Datas/Player" + index + ".txt");
			Scanner scan = new Scanner(reader);
			if(reader.exists()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public void amountUpdate(Players player) {
		player.getProps().sort(new propsUpSort());
		for(int i = 0 ; i < player.getProps().size() ; i ++) {
			for(int j = i+1 ; j < player.getProps().size() ; j ++) {
				if(player.getProps().get(i).getID()<10000&&player.getProps().get(i).getID()==player.getProps().get(j).getID()) {
						player.getProps().get(i).setAmount(player.getProps().get(i).getAmount()+player.getProps().get(j).getAmount());//把相同ID東西的數量加起來
						player.getProps().remove(j);
				}
			}
		}
	}
}
class propsUpSort implements Comparator<Objects> 
{ 
	//以props的ID升序排列
	public int compare(Objects a, Objects b) 
	{ 
		return a.getID() - b.getID(); 
	} 
} 