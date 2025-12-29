package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants04 extends Objects{
	public Pants04(Players player) {
		super(player);
		ID = 40018;
		QUALITY = "良好";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "幽谷長褲";
		Note = "微微的靈氣從表面浮出，\n是被谷地源氣所孕育出來的褲子";
		Image = makeBG("/Images/脛甲04.png");
		strength = 0;//強化等級
		Armor=65;//護甲值
		LV_ACQUIRED = 35;//等級限制
		AGI_ACQUIRED =25;
	    INT_ACQUIRED =29;
	    STR_ACQUIRED =34;
	    LUK_ACQUIRED =27;
	    
	    escape = 4;//閃避綠
		boom =4;//報及綠
		BoomAttackRate=0.07;//抱傷
		Hit = 7; //命中
		
		HP+=183;//生命
		MP+=125;//魔力
		STR+=16;//力量
		INT+=16;//智慧
		LUK+=14;//幸運
		AGI+=13;//敏捷
		
		sellPrice =5000;
		buyPrice =25000;
		dropChance=10;
	}

}
