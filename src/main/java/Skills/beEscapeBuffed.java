package Skills;

import Objects.Objects;

public class beEscapeBuffed extends skillStatus{//灼燒
	public beEscapeBuffed() {
		ID=15;
		buffBG = Objects.makeBG("/Images/增閃躲圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加閃躲值";//名稱
		note = "增加目標閃躲值";//效果敘述
	}
}