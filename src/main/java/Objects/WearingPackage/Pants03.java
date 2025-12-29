package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Pants03 extends Objects{
	public Pants03(Players player) {
		super(player);
		ID = 40014;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="PANTS";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔靈長褲";
		Note = "傳說被魔源之靈所寄宿過的褲子";
		Image = makeBG("/Images/脛甲03.png");
		strength = 0;//強化等級
		Armor=49;//護甲值
		LV_ACQUIRED = 25;//等級限制
		AGI_ACQUIRED =18;
	    INT_ACQUIRED =22;
	    STR_ACQUIRED =24;
	    LUK_ACQUIRED =18;
	    
	    escape = 3;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.06;//抱傷
		Hit = 6; //命中
		
		HP+=123;//生命
		MP+=85;//魔力
		STR+=8;//力量
		INT+=7;//智慧
		LUK+=7;//幸運
		AGI+=9;//敏捷
		
		sellPrice =1000;
		buyPrice =5000;
		dropChance=10;
	}

}
