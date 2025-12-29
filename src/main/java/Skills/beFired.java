package Skills;

import Objects.Objects;

public class beFired extends skillStatus{//灼燒
	public beFired() {
		ID=0;
		buffBG = Objects.makeBG("/Images/灼燒圖標.png");
		rate = 0.5;
		nowCount = 0;
		needCount = 3;
		name = "灼燒";//名稱
		note = "將持續對目標造成傷害";//效果敘述
	}
}
