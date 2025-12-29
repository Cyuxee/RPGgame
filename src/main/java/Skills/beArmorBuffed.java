package Skills;

import Objects.Objects;

public class beArmorBuffed extends skillStatus{//灼燒
	public beArmorBuffed() {
		ID=11;
		buffBG = Objects.makeBG("/Images/增護甲圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加護甲值";//名稱
		note = "增加目標護甲值";//效果敘述
	}
}
