public class Monster {
	private String mobName;
	private int gradeMob;
	private int Level, HP, MP, ATK, DEF;
	private int mobEXP, mobGold;
	
	public Monster(String mobName, int Level, int gradeMob, int HP, int MP, int ATK, int DEF) {
		this.mobName = mobName;
		this.Level = Level;
		this.gradeMob = gradeMob;
		this.HP = HP;
		this.MP = MP;
		this.ATK = ATK;
		this.DEF = DEF;
		
		setEXP();
		setGold();
	}

	public void setMobName(String mobName) {
		this.mobName = mobName;
	}
	public String getMobName() {
		return mobName;
	}

	public void setGradeMob(int gradeMob) {
		this.gradeMob = gradeMob;
	}
	public int getGradeMob() {
		return gradeMob;
	}

	public void setLevel(int level) {
		Level = level;
	}
	public int getLevel() {
		return Level;
	}

	public void setHP(int hP) {
		HP = hP;
	}
	public int getHP() {
		return HP;
	}

	public void setMP(int mP) {
		MP = mP;
	}
	public int getMP() {
		return MP;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}
	public int getATK() {
		return ATK;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}
	public int getDEF() {
		return DEF;
	}

	public void setMobEXP(int mobEXP) {
		this.mobEXP = mobEXP;
	}
	public int getMobEXP() {
		return mobEXP;
	}

	public void setMobGold(int mobGold) {
		this.mobGold = mobGold;
	}
	public int getMobGold() {
		return mobGold;
	}

	public void setEXP() {
		this.mobEXP = (this.Level * 20) + ((int)(Math.random() * 5) -5);
	}
	public void setGold() {
		this.mobGold = (this.Level * 100) + ((int)(Math.random() * 50) +1);
	}
}
