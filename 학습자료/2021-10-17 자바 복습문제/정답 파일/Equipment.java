
public class Equipment {
	private int equipCode;
	private String equipName;
	private int equipHP;
	private int equipMP;
	private int equipATK;
	private int equipDEF;
	
	public Equipment() {}
	
	public Equipment(int equipCode, String equipName, 
			int equipHP, int equipMP, int equipATK, int equipDEF) {
		this.equipCode = equipCode;
		this.equipName = equipName;
		this.equipHP = equipHP;
		this.equipMP = equipMP;
		this.equipATK = equipATK;
		this.equipDEF = equipDEF;
	}
	
	public void setEquipCode(int equipCode) {
		this.equipCode = equipCode;
	}
	public int getEquipCode() {
		return equipCode;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getEquipName() {
		return equipName;
	}

	public void setEquipHP(int equipHP) {
		this.equipHP = equipHP;
	}
	public int getEquipHP() {
		return equipHP;
	}

	public void setEquipMP(int equipMP) {
		this.equipMP = equipMP;
	}
	public int getEquipMP() {
		return equipMP;
	}

	public void setEquipATK(int equipATK) {
		this.equipATK = equipATK;
	}
	public int getEquipATK() {
		return equipATK;
	}

	public void setEquipDEF(int equipDEF) {
		this.equipDEF = equipDEF;
	}
	public int getEquipDEF() {
		return equipDEF;
	}
}
