package Skills;

import Objects.Objects;

public class beIced extends skillStatus{//冰凍
	public beIced() {
		ID=1;
		buffBG = Objects.makeBG("/Images/冰凍圖標.png");
		rate = 0.5;
		nowCount = 0;
		needCount = 4;
		name = "冰凍";//名稱
		note = "讓對方停止動作";//效果敘述
	}
}