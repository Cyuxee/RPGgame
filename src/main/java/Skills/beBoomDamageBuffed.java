package Skills;

import Objects.Objects;

public class beBoomDamageBuffed extends skillStatus{//灼燒
	public beBoomDamageBuffed() {
		ID=13;
		buffBG = Objects.makeBG("/Images/暴傷增圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加暴擊傷害";//名稱
		note = "增加目標暴擊傷害";//效果敘述
	}
}
