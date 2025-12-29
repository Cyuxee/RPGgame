package Maps;
//The mobs in area1 must be level 1 ~ 10
//The mobs in area2 must be level 11 ~ 20
//The mobs in area3 must be level 21 ~ 30

public class Area {
	private static String[] names = {"哥布林","草原狼","史萊姆","領風鴞","巨食哥布林","厚皮野豬","精靈怨念",
									 "樹妖","狂暴蜈蚣","食屍鬼","爬行者","幽谷守衛","海盜","浮空水母",
									 "無回獅虎","魔族衛兵","賞金獵人","魔源幼獸","魔源幼龍","魔族隊長","魔源巨獸",
									 "魔王近衛","魔源巨龍","魔王分身","魔王"};
	public static int level(int areaNumber) {
		int result;
		do{
			result = (int)((Math.random()*10)+10*(areaNumber-1));
		}while(result==0);
		return result;
	}
	public static String name(int areaNumber) {
		return names[(int)((Math.random()*3)+3*(areaNumber-1))];
	}
}
