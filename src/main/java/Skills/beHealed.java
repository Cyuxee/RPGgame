package Skills;

import Objects.Objects;

public class beHealed extends skillStatus{
	public beHealed() {
		ID=2;
		buffBG = Objects.makeBG("/Images/治療圖標.png");
		rate = 0.5;
		nowCount = 0;
		needCount = 4;
		name = "治療";//名稱
		note = "持續治療";//效果敘述
	}
}
