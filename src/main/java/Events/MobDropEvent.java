package Events;

import java.util.ArrayList;

import Entities.Mobs;
import Entities.Players;
import GUI.GUI;
import Objects.Objects;
import Objects.MobDrops.*;
import Objects.PropsPackage.*;
import Objects.WearingPackage.*;

public class MobDropEvent {
	
	
	private Players player = GUI.getPlayer();

	private int areaNumber;
	private ArrayList<Objects> drops = new ArrayList<>();
	public MobDropEvent(int areaNumber,boolean isKing) {
		this.areaNumber = areaNumber;
		if(isKing==true) {
			kingDrops();
		}else {
			drops();
		}
	}
	
	public ArrayList<Objects> getDrop(){
		return drops;
	}

	public void drops() {
		if(areaNumber==1) {//1-10lv
			drops.add(new tooth1(player));
			drops.add(new healer(player));
			drops.add(new mpHealer(player));
			drops.add(new Weapons01(player));
			drops.add(new Weapons001(player));

			drops.add(new Armor01(player));
			drops.add(new helmet01(player));
			drops.add(new Pants01(player));
			drops.add(new Shoes01(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}
		if(areaNumber==2) {//11-20lv
			drops.add(new tooth1(player));
			drops.add(new healer(player));
			drops.add(new mpHealer(player));
			drops.add(new Weapons02(player));
			drops.add(new Weapons002(player));

			drops.add(new Armor02(player));
			drops.add(new helmet02(player));
			drops.add(new Pants02(player));
			drops.add(new Shoes02(player));
			
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}
		if(areaNumber==3) {//21-30lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons03(player));
			drops.add(new Weapons003(player));

			drops.add(new Armor03(player));
			drops.add(new helmet03(player));
			drops.add(new Pants03(player));
			drops.add(new Shoes03(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==4) {//31-40lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons04(player));
			drops.add(new Weapons004(player));

			drops.add(new Armor04(player));
			drops.add(new helmet04(player));
			drops.add(new Pants04(player));
			drops.add(new Shoes04(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==5) {//41-50lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons05(player));
			drops.add(new Weapons005(player));

			drops.add(new Armor05(player));
			drops.add(new helmet05(player));
			drops.add(new Pants05(player));
			drops.add(new Shoes05(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==6) {//51-60lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons06(player));
			drops.add(new Weapons006(player));

			drops.add(new Armor06(player));
			drops.add(new helmet06(player));
			drops.add(new Pants06(player));
			drops.add(new Shoes06(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==7) {//61-70lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons07(player));
			drops.add(new Weapons007(player));

			drops.add(new Armor07(player));
			drops.add(new helmet07(player));
			drops.add(new Pants07(player));
			drops.add(new Shoes07(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==8) {//71-80lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons08(player));
			drops.add(new Weapons008(player));

			drops.add(new Armor08(player));
			drops.add(new helmet08(player));
			drops.add(new Pants08(player));
			drops.add(new Shoes08(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}if(areaNumber==9) {//71-80lv
			drops.add(new tooth4(player));
			drops.add(new healer10(player));
			drops.add(new mpHealer10(player));
			drops.add(new Weapons09(player));
			drops.add(new Weapons009(player));

			drops.add(new Armor09(player));
			drops.add(new helmet09(player));
			drops.add(new Pants09(player));
			drops.add(new Shoes09(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				System.out.println("增加成功 !! " + drops.get(i).getName());
			}
		}
	}
	public void kingDrops() {
		if(areaNumber==1) {//1-10lv
			drops.add(new tooth1(player));
			drops.add(new healer(player));
			drops.add(new mpHealer(player));
			drops.add(new Weapons01(player));
			drops.add(new Weapons001(player));

			drops.add(new Armor01(player));
			drops.add(new helmet01(player));
			drops.add(new Pants01(player));
			drops.add(new Shoes01(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}
		if(areaNumber==2) {//11-20lv
			drops.add(new tooth1(player));
			drops.add(new healer(player));
			drops.add(new mpHealer(player));
			drops.add(new Weapons02(player));
			drops.add(new Weapons002(player));

			drops.add(new Armor02(player));
			drops.add(new helmet02(player));
			drops.add(new Pants02(player));
			drops.add(new Shoes02(player));
			
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}
		if(areaNumber==3) {//21-30lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons03(player));
			drops.add(new Weapons003(player));

			drops.add(new Armor03(player));
			drops.add(new helmet03(player));
			drops.add(new Pants03(player));
			drops.add(new Shoes03(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==4) {//31-40lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons04(player));
			drops.add(new Weapons004(player));

			drops.add(new Armor04(player));
			drops.add(new helmet04(player));
			drops.add(new Pants04(player));
			drops.add(new Shoes04(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==5) {//41-50lv
			drops.add(new tooth2(player));
			drops.add(new healer2(player));
			drops.add(new mpHealer2(player));
			drops.add(new Weapons05(player));
			drops.add(new Weapons005(player));

			drops.add(new Armor05(player));
			drops.add(new helmet05(player));
			drops.add(new Pants05(player));
			drops.add(new Shoes05(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==6) {//51-60lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons06(player));
			drops.add(new Weapons006(player));

			drops.add(new Armor06(player));
			drops.add(new helmet06(player));
			drops.add(new Pants06(player));
			drops.add(new Shoes06(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==7) {//61-70lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons07(player));
			drops.add(new Weapons007(player));

			drops.add(new Armor07(player));
			drops.add(new helmet07(player));
			drops.add(new Pants07(player));
			drops.add(new Shoes07(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==8) {//71-80lv
			drops.add(new tooth3(player));
			drops.add(new healer3(player));
			drops.add(new mpHealer3(player));
			drops.add(new Weapons08(player));
			drops.add(new Weapons008(player));

			drops.add(new Armor08(player));
			drops.add(new helmet08(player));
			drops.add(new Pants08(player));
			drops.add(new Shoes08(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}if(areaNumber==9) {//71-80lv
			drops.add(new tooth4(player));
			drops.add(new healer10(player));
			drops.add(new mpHealer10(player));
			drops.add(new Weapons09(player));
			drops.add(new Weapons009(player));

			drops.add(new Armor09(player));
			drops.add(new helmet09(player));
			drops.add(new Pants09(player));
			drops.add(new Shoes09(player));
			for(int i = 0 ; i < drops.size() ; i ++) {
				if(drops.get(i).getID()<10000) {
					drops.get(i).setAmount(drops.get(i).getAmount()*2);
				}
			}
		}
	}
	public boolean dropExist(String drop) {
		for(int i = 0 ; i < drops.size() ; i ++) {
			if(drops.get(i).getName().equals(drop)) {
				return true;
			}
		}
		return false;
	}
}
