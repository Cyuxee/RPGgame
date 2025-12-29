package Skills;

import Entities.Mobs;
import Entities.Players;
import Skills.SkillPackage.ArmorDownBreak;
import Skills.SkillPackage.BigIce;
import Skills.SkillPackage.CircleSlade;
import Skills.SkillPackage.Decay;
import Skills.SkillPackage.DefendBody;
import Skills.SkillPackage.DoubleHit;
import Skills.SkillPackage.DragonFireBall;
import Skills.SkillPackage.Excited;
import Skills.SkillPackage.Explosive;
import Skills.SkillPackage.FireBall;
import Skills.SkillPackage.FireBreak;
import Skills.SkillPackage.FusionSlade;
import Skills.SkillPackage.GodBody;
import Skills.SkillPackage.HealthBreak;
import Skills.SkillPackage.MagicBoom;
import Skills.SkillPackage.MagicOperate;
import Skills.SkillPackage.MagicQuake;
import Skills.SkillPackage.MagicSlade;
import Skills.SkillPackage.MaxLow;
import Skills.SkillPackage.NormalAttack;
import Skills.SkillPackage.RuneOprate;
import Skills.SkillPackage.Scare;
import Skills.SkillPackage.Shout;
import Skills.SkillPackage.SwordGod;



public class Skills {
	protected int ID;
	protected int MpCost;
	protected String Name;
	protected double skillHit=70;
	protected String Note;
	protected boolean canBeApply = true;
	protected int nowCooldown=-1;
	protected int Cooldown;
	protected double Damage;
	protected int count =0;
	protected boolean isMyself = false;
	protected boolean isMagic = true;
	protected boolean isPhysic = false;
	protected Players player;
	protected String type;//屬性
	public Skills(Players player) {
		this.player = player;
		ID = 0;
		Name = "預設名稱";
		Note = "預設內容";
		Cooldown = 10;
		type = "none";
		
	}
	public Skills create() {
		Skills skill = new Skills(this.player);
		skill.setName("預設攻擊");
		skill.setNote("預設攻擊");
		skill.setDamage(1);
		skill.setMpCost(0);
		skill.setCool(0);
		return skill;
	}
	public boolean isPhysic() {
		return isPhysic;
	}
	public void setIsPhysic(boolean isPhysic) {
		this.isPhysic = isPhysic;
	}
	public boolean isMagic() {
		return isMagic;
	}
	public void setIsMagic(boolean isMagic) {
		this.isMagic = isMagic;
	}
	public boolean isCanBeApply() {
		return canBeApply;
	}
	public void setCanBeApply(boolean canBeApply) {
		this.canBeApply = canBeApply;
	}
	public int getNowCooldown() {
		return nowCooldown;
	}
	public void setNowCooldown(int nowCooldown) {
		this.nowCooldown = nowCooldown;
	}
	public void setName(String name) {
		this.Name = name;
		return;
	}
	public String getName() {
		return this.Name;
	}
	public void setNote(String note) {
		this.Note = note;
		return;
	}
	public String getNote() {
		return this.Note;
	}
	public void setCool(int cool) {
		this.Cooldown = cool;
		return;
	}
	public int getCool() {
		return this.Cooldown;
	}
	public void setDamage(int damage) {
		this.Damage = damage;
		return;
	}
	public double getDamage() {
		return this.Damage;
	}
	public void setMpCost(int cost) {
		this.MpCost = cost;
		return;
	}
	public int getMpCost() {
		return this.MpCost;
	}
	public double getSkillHit() {
		return this.skillHit;
	}
	public void setSkillHit(double skillHit) {
		this.skillHit = skillHit;
	}
	public int getID() {
		return this.ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public void setMyself(boolean myself) {
		this.isMyself = myself;
	}
	public boolean getMyself() {
		return this.isMyself;
	}
	public static Skills getDataSkillsCreate(Players player,int id) {
		Skills result = new NormalAttack(player); 
		if(id==0) {
			result = new NormalAttack(player);
		}else if(id==1) {
			result = new FireBall(player);
		}else if(id==2) {
			result = new DragonFireBall(player);
		}else if(id==3) {
			result = new Excited(player);
		}else if(id==4) {
			result = new BigIce(player);
		}else if(id==5) {
			result = new GodBody(player);
		}else if(id==6) {
			result = new MagicBoom(player);
		}else if(id==7) {
			result = new MaxLow(player);
		}else if(id==8) {
			result = new FireBreak(player);
		}else if(id==9) {
			result = new DoubleHit(player);
		}else if(id==10) {
			result = new Explosive(player);
		}else if(id==11) {
			result = new Shout(player);
		}else if(id==12) {
			result = new MagicQuake(player);
		}else if(id==13) {
			result = new ArmorDownBreak(player);
		}else if(id==14) {
			result = new HealthBreak(player);
		}else if(id==15) {
			result = new FusionSlade(player);
		}else if(id==16) {
			result = new Scare(player);
		}else if(id==17) {
			result = new MagicOperate(player);
		}else if(id==18) {
			result = new SwordGod(player);
		}else if(id==19) {
			result = new RuneOprate(player);
		}else if(id==20) {
			result = new DefendBody(player);
		}else if(id==21) {
			result = new MagicSlade(player);
		}else if(id==22) {
			result = new Decay(player);
		}else if(id==23) {
			result = new CircleSlade(player);
		}
		return result;
	}
	public void getEffect(Mobs mob) {}
	public void getEffect(Players player) {}

}
