package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class helmet01 extends Objects{
	public helmet01(Players player) {
		super(player);
		ID = 40004;
		QUALITY = "粗劣";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="HELMET";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "粗製皮帽";
		Note = "做工粗劣的皮帽";
		Image = makeBG("/Images/頭盔01.png");
		strength = 0;//強化等級
		Armor=8;//護甲值
		LV_ACQUIRED = 3;//等級限制
		AGI_ACQUIRED =2;
	    INT_ACQUIRED =4;
	    STR_ACQUIRED =3;
	    LUK_ACQUIRED =1;
	    
	    escape = 1;//閃避綠
		boom =1;//報及綠
		BoomAttackRate=0.01;//抱傷
		Hit = 2; //命中
		
		HP+=17;//生命
		MP+=12;//魔力
		STR+=2;//力量
		INT+=1;//智慧
		LUK+=2;//幸運
		AGI+=3;//敏捷
		sellPrice =100;
		buyPrice =500;
		dropChance=10;
	}

}
