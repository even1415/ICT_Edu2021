
public class Equipment {
	private int equipCode;
	private String equipName;
	private int equipHP;
	private int equipMP;
	private int equipATK;
	private int equipDEF;
	
	public Equipment() {}
	
	public Equipment(/*전달인자*/) {
		/*
		★구현 필요★
		모든 변수의 내용을 인자로 받아서 채워넣음(ALT+SHIFT+S,O 단축키 활용)
		*/
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
