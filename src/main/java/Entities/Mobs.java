package Entities;


import java.util.ArrayList;

import Events.MobDropEvent;
import GUI.GUI;
import Maps.Area;
import Objects.Objects;
import Objects.PropsPackage.healer10;
import Objects.PropsPackage.mpHealer10;
import Skills.beIced;
import Skills.skillStatus;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class Mobs extends CombatEntity {
	
	private static Label mobCount;//血量計數
	private static Label mobStatus;//怪物屬性等級 名稱
	private static ProgressBar pbar;//怪物血量顯示
	
	private static boolean isIced = false;
	
	private int ID;
	private String NAME;
	private int Money;
	private int Diamond;
	
	private double Exp;
	private	static int count = 0;
	private ArrayList<Objects> drop = new ArrayList<>();
	public Mobs(int areaLevel,int areaName) {
		super();
		if(areaLevel==9&&areaName==9) {
			NAME = "魔王";
		}
		double rand = Math.random()*100;
		if(rand<10&&areaLevel!=9&&areaName!=9) {
			MobDropEvent mde = new MobDropEvent(areaLevel,true);
			drop = mde.getDrop();
			System.err.println("!!小王掉落物尚未調整!!");
			NAME = Area.name(areaName)+" (王級)";
	
			level = Area.level(areaLevel);
			maxHealth = (int)(6.26*Math.pow(level,2)+12.2*level+163.4*Math.random())*3;
			
			health = maxHealth;
		
			damage = (int)(8.2*level+1.5+20*Math.random())*3;
			armor =(int)(1.32*Math.pow(level,2)+5.2*level+120*Math.random())*3;
			Money = (int)(1.56*Math.pow(level,2)+3.2*level+63.4*Math.random())*10;
			Diamond = (int)(100+level*2.3);
//			escape = (int)(level*0.3)*2;
			Exp = (int)Math.pow((level*30.26+Math.getExponent(level*Math.random()*(areaLevel+100))),1.06)*5;
			ID = count++;			
			skillStatus.setLabel(this);
		}else if(rand>=10&&areaLevel!=9&&areaName!=9){
			
			MobDropEvent mde = new MobDropEvent(areaLevel,false);
			drop = mde.getDrop();
			NAME = Area.name(areaName);

			level = Area.level(areaLevel);
			maxHealth = (int)(6.26*Math.pow(level,2)+12.2*level+163.4*Math.random());
			health = maxHealth;

			damage = (int)(8.2*level+1.5+20*Math.random());
			armor =(int)(1.32*Math.pow(level,2)+5.2*level+120*Math.random());
			Money = (int)(1.56*Math.pow(level,2)+3.2*level+63.4*Math.random());
			Diamond = 0;
			escape = (int)(level*0.3);
			Exp = (int)Math.pow((level*30.26+Math.getExponent(level*Math.random()*(areaLevel+100))),1.06);
			ID = count++;
			skillStatus.setLabel(this);
		}
		Background eb = null;
		if(NAME.equals("哥布林")||NAME.equals("哥布林" + " (王級)")) {//可個別加上掉落物以及換上個別圖片400x400
			eb = GUI.backgroundCreate("/Images/哥布林.png");
		}else if(NAME.equals("史萊姆")||NAME.equals("史萊姆" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/史萊姆.png");
		}else if(NAME.equals("草原狼")||NAME.equals("草原狼" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/草原狼.png");	
		}else if(NAME.equals("領風鴞")||NAME.equals("領風鴞" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/領風鴞.png");
		}else if(NAME.equals("巨食哥布林")||NAME.equals("巨食哥布林" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/巨食哥布林.png");
		}else if(NAME.equals("厚皮野豬")||NAME.equals("厚皮野豬" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/厚皮野豬.png");
		}else if(NAME.equals("精靈怨念")||NAME.equals("精靈怨念" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/精靈怨念.png");
		}else if(NAME.equals("樹妖")||NAME.equals("樹妖" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/樹妖.png");
		}else if(NAME.equals("狂暴蜈蚣")||NAME.equals("狂暴蜈蚣" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/狂暴蜈蚣.png");
		}else if(NAME.equals("食屍鬼")||NAME.equals("食屍鬼" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/食屍鬼.png");
		}else if(NAME.equals("爬行者")||NAME.equals("爬行者" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/爬行者.png");
		}else if(NAME.equals("幽谷守衛")||NAME.equals("幽谷守衛" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/幽谷守衛.png");
		}else if(NAME.equals("海盜")||NAME.equals("海盜" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/海盜.png");
		}else if(NAME.equals("浮空水母")||NAME.equals("浮空水母" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/浮空水母.png");
		}else if(NAME.equals("無回獅虎")||NAME.equals("無回獅虎" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/無回獅虎.png");
		}else if(NAME.equals("魔族衛兵")||NAME.equals("魔族衛兵" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔族衛兵.png");
		}else if(NAME.equals("賞金獵人")||NAME.equals("賞金獵人" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/賞金獵人.png");
		}else if(NAME.equals("魔源幼獸")||NAME.equals("魔源幼獸" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔源幼獸.png");
		}else if(NAME.equals("魔源幼龍")||NAME.equals("魔源幼龍" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔源幼龍.png");
		}else if(NAME.equals("魔族隊長")||NAME.equals("魔族族長" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔族隊長.png");
		}else if(NAME.equals("魔源巨獸")||NAME.equals("魔源巨獸" + " (王級)")) {
			eb = GUI.backgroundCreate("/Images/魔源巨獸.png");
		}else if(NAME.equals("魔王近衛")||NAME.equals("魔王近衛" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔王近衛.png");
		}else if(NAME.equals("魔源巨龍")||NAME.equals("魔源巨龍" + " (王級)")){
			eb = GUI.backgroundCreate("/Images/魔源巨龍.png");
		}else if(NAME.equals("魔王分身")||NAME.equals("魔王分身" + " (王級)")){

			eb = GUI.backgroundCreate("/Images/魔王分身.png");
		}else if(NAME.equals("魔王")){
			eb = GUI.backgroundCreate("/Images/魔王.png");
			level = 90;
			maxHealth = (int)(6.26*Math.pow(level,2)+12.2*level+163.4*Math.random())+999999;
			health = maxHealth;

			damage = (int)(12.2*level+1.5+20*Math.random())+9999;
			armor =(int)(1.32*Math.pow(level,2)+5.2*level+120*Math.random())+9999;
			Money = (int)(1.56*Math.pow(level,2)+3.2*level+63.4*Math.random())+999999;
			Diamond = 10000;
			escape = (int)200;
			Exp = (int)Math.pow((level*8.26+Math.getExponent(level*Math.random()*(areaLevel+100))),1.06)+109999;
			ID = count++;
			skillStatus.setLabel(this);
		}
		GUI.getEnimy().setBackground(eb);

	}
	public Mobs() {
	}
	public Mobs mobTest(String test) {
		Mobs testmob = new Mobs(1,1);
		if(test.equals("測試怪物")){
			testmob.setName("***測試怪物***");
			testmob.setDiamond(100);
			testmob.setHealth(99999999);
			testmob.setExp(999999);
			testmob.setMaxHealth(99999999);
			testmob.setLevel(999);
			testmob.setDamage(0);
			Objects drop1 = new mpHealer10(GUI.getPlayer());
			drop1.setDropChance(100);
			drop1.setAmount(100);
			Objects drop2 = new healer10(GUI.getPlayer());
			drop2.setAmount(100);
			drop2.setDropChance(100);
			testmob.getDrops().add(drop1);
			testmob.getDrops().add(drop2);
			testmob.setArmor(150000);
			
//			testmob.getBuffs().add(new beFired());
			testmob.getBuffs().add(new beIced());
//			testmob.getBuffs().add(new beHealed());
//			testmob.getBuffs().add(new beMagicDamageBuffed());
//			testmob.getBuffs().add(new beMagicDamageDebuffed());		
			skillStatus.setLabel(testmob);

			skillStatus.skillStatusSort(testmob);
			return testmob;
		}
		return testmob;
	}
	public void setIsIced(boolean isIced) {
		this.isIced = isIced;
	}
	public boolean getIsIced() {
		return this.isIced;
	}
	public ArrayList<Objects> getDrops(){
		return drop;
	}
	public void setArmor(int armor) {
		this.armor=armor;
	}
	public int getArmor() {
		return this.armor;
	}
	public void setDrops(ArrayList<Objects> drop) {
		this.drop = drop;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int Money) {
		this.Money = Money;
	}
	public void setDiamond(int Diamond) {
		this.Diamond = Diamond;
	}
	public int getDiamond() {
		return Diamond;
	}
	public void setName(String name) {
		this.NAME = name;
		return;
	}
	public String getName() {
		return this.NAME;
	}
	
	@Override
	public void setMaxHealth(int health) {
		this.maxHealth = health;
		this.health = health;
	}
	
	public void setExp(int exp) {
		this.Exp = exp;
		return;
	}
	public double getExp() {
		return this.Exp;
	}
	public void setMobStatus(String mobStatus) {
		this.mobStatus.setFont(new Font((int)(18-mobStatus.length()*0.3)));
		this.mobStatus.setText(mobStatus);
	}
	public Label getMobStatus() {
		return this.mobStatus;
	}
	public void setMobCount(int health,int maxHealth) {
		mobCount.setText(String.valueOf(health) + " / " +  String.valueOf(maxHealth));
	}
	public Label getMobCount() {
		return mobCount;
	}
	public void setPBar(ProgressBar pbar) {
		pbar.setProgress((double)health/(double)maxHealth);
	}
	public ProgressBar getPBar() {
		return pbar;
	} 
	@Override
	public void run() {
		// Intentionally empty - Runnable interface required but not used
	}
	
}
