package Objects.WearingPackage;

import Entities.Players;
import Objects.Objects;
 
public class Shoes03 extends Objects{
	public Shoes03(Players player) {
		super(player);
		ID = 40015;
		QUALITY = "普通";//粗劣 普通 良好 稀有 史詩 傳說 不滅
					 //灰色 白色 綠色 藍色 紫色 橘色 黑色
		WEARING_TYPE="SHOES";//HELMET ARMOR PANTS SHOES WEAPON
		Name = "魔靈短靴";
		Note = "傳說被魔源之靈所寄宿過的靴子";
		Image = makeBG("/Images/長靴03.png");
		strength = 0;//強化等級
		Armor=39;//護甲值
		LV_ACQUIRED = 24;//等級限制
		AGI_ACQUIRED =18;
	    INT_ACQUIRED =15;
	    STR_ACQUIRED =21;
	    LUK_ACQUIRED =19;
	    
	    escape = 2;//閃避綠
		boom =3;//報及綠
		BoomAttackRate=0.04;//抱傷
		Hit = 3; //命中
		
		HP+=117;//生命
		MP+=88;//魔力
		STR+=8;//力量
		INT+=9;//智慧
		LUK+=8;//幸運
		AGI+=10;//敏捷
		
		sellPrice =1000;
		buyPrice =5000;
		dropChance=10;
	}

}
