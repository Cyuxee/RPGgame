package Skills;

import Objects.Objects;

public class beDamageBuffed extends skillStatus{//灼燒
	public beDamageBuffed() {
		ID=5;
		buffBG = Objects.makeBG("/Images/增傷圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "增加物理傷害";//名稱
		note = "增加目標的物理傷害";//效果敘述
	}
}
