package Skills;

import Objects.Objects;

public class beArmorDebuffed extends skillStatus{//灼燒
	public beArmorDebuffed() {
		ID=12;
		buffBG = Objects.makeBG("/Images/減護甲圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "減少護甲值";//名稱
		note = "減少目標護甲值";//效果敘述
	}
}
