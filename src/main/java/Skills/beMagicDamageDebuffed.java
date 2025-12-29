package Skills;

import Objects.Objects;

public class beMagicDamageDebuffed extends skillStatus{//灼燒
	public beMagicDamageDebuffed() {
		ID=4;
		buffBG = Objects.makeBG("/Images/減魔傷圖標.png");
		rate = 0.5;
		nowCount = 0;
		needCount = 5;
		name = "減少魔傷";//名稱
		note = "減少目標魔法傷害";//效果敘述
	}
}
