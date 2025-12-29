package Skills;

import Objects.Objects;

public class beEscapeDebuffed extends skillStatus{//灼燒
	public beEscapeDebuffed() {
		ID=16;
		buffBG = Objects.makeBG("/Images/減閃躲圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "減少閃躲值";//名稱
		note = "減少目標閃躲值";//效果敘述
	}
}