package Skills;

import Objects.Objects;

public class beDamageDebuffed extends skillStatus{//灼燒
	public beDamageDebuffed() {
		ID=6;
		buffBG = Objects.makeBG("/Images/降傷圖標.png");
		rate = 1.2;
		nowCount = 0;
		needCount = 3;
		name = "降低物理傷害";//名稱
		note = "降低目標的物理傷害";//效果敘述
	}
}
