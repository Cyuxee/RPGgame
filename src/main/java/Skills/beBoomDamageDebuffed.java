package Skills;

import Objects.Objects;

public class beBoomDamageDebuffed extends skillStatus{//灼燒
	public beBoomDamageDebuffed() {
		ID=14;
		buffBG = Objects.makeBG("/Images/暴傷減圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "減少暴擊傷害";//名稱
		note = "減少目標暴擊傷害";//效果敘述
	}
}
