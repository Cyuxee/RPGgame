package Skills;

import Objects.Objects;

public class beBoomBuffed extends skillStatus{//灼燒
	public beBoomBuffed() {
		ID=9;
		buffBG = Objects.makeBG("/Images/增暴擊圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加暴擊率";//名稱
		note = "增加目標暴擊率";//效果敘述
	}
}
