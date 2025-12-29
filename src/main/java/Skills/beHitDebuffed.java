package Skills;

import Objects.Objects;

public class beHitDebuffed extends skillStatus{//灼燒
	public beHitDebuffed() {
		ID=8;
		buffBG = Objects.makeBG("/Images/減命中圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "降低命中";//名稱
		note = "降低目標命中率";//效果敘述
	}
}