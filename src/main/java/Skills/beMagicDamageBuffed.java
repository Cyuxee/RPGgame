package Skills;

import Objects.Objects;

public class beMagicDamageBuffed extends skillStatus{//灼燒
	public beMagicDamageBuffed() {
		ID=3;
		buffBG = Objects.makeBG("/Images/增魔傷圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加魔傷";//名稱
		note = "增加目標魔法傷害";//效果敘述
	}
}
