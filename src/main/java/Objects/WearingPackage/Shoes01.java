package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes01 extends Objects{
	public Shoes01(Players player) {
		super(player);
		ID = 40007;
		QUALITY = "粗劣";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "粗製皮鞋";
		Note = "做工粗劣的皮鞋";
		Image = makeBG("/Images/長靴01.png");
		strength = 0;//強化等級
		Armor=7;//護甲值
		LV_ACQUIRED = 4;//等級限制
		AGI_ACQUIRED =5;
	    INT_ACQUIRED =3;
	    STR_ACQUIRED =7;
	    LUK_ACQUIRED =2;
	    
	    escape = 1;//閃避綠
		boom =2;//報及綠
		BoomAttackRate=0.02;//抱傷
		Hit = 1; //命中
		
		HP+=17;//生命
		MP+=8;//魔力
		STR+=1;//力量
		INT+=3;//智慧
		LUK+=3;//幸運
		AGI+=3;//敏捷
		
		sellPrice =100;
		buyPrice =500;
		dropChance=10;
	}

}
