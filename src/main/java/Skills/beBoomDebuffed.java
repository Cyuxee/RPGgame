package Skills;

import Objects.Objects;

public class beBoomDebuffed extends skillStatus{//灼燒
	public beBoomDebuffed() {
		ID=10;
		buffBG = Objects.makeBG("/Images/減暴擊圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "降低暴擊率";//名稱
		note = "降低目標暴擊率";//效果敘述
	}
}
