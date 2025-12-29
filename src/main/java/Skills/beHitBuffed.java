package Skills;

import Objects.Objects;

public class beHitBuffed extends skillStatus{//灼燒
	public beHitBuffed() {
		ID=7;
		buffBG = Objects.makeBG("/Images/增命中圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加命中";//名稱
		note = "增加目標命中率";//效果敘述
	}
}
