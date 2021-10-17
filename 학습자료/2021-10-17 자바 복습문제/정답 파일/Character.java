import java.util.Scanner;

public class Character {
	private String nickName;
	private int Level, EXP;
	private int HP, MP, ATK, DEF;
	private int myGold;
	private String equipName;
	private int equipCode;
	
	public Character() {
		Level = 1;
		HP = 50;
		MP = 10;
		ATK = 10;
		DEF = 1;
		EXP = 0;
		myGold = 0;
		equipName = "없음";
		equipCode = 0;
	}
	
	public void setNickName() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(" * 닉네임을 입력해주세요. : ");
		nickName = scanner.next();
	}
	public String getNickName() {
		return nickName;
	}

	public void setLevel(int level) {
		this.Level = level;
	}
	public int getLevel() {
		return Level;
	}

	public void setEXP(double penelty) {
		this.EXP *= penelty;
	}
	public int getEXP() {
		return EXP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}
	public int getHP() {
		return HP;
	}

	public void setMP(int MP) {
		this.MP = MP;
	}
	public int getMP() {
		return MP;
	}

	public void setATK(int ATK) {
		this.ATK = ATK;
	}
	public int getATK() {
		return ATK;
	}

	public void setDEF(int DEF) {
		this.DEF = DEF;
	}
	public int getDEF() {
		return DEF;
	}

	public void setMyGold(int myGold) {
		this.myGold = myGold;
	}
	public int getMyGold() {
		return myGold;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getEquipName() {
		return equipName;
	}

	public boolean PutEquip(Equipment e) {
		this.equipName = e.getEquipName();
		this.equipCode = e.getEquipCode();
		this.HP += e.getEquipHP();
		this.MP += e.getEquipMP();
		this.ATK += e.getEquipATK();
		this.DEF += e.getEquipDEF();
		
		System.out.println(" * 장비 장착 완료.");
		
		return true;
	}
	
	public void gainEXP(int mobEXP) {
		this.EXP += mobEXP;
		LevelUp();
	}
	
	public void gainGold(int mobGold) {
		this.myGold += mobGold;
	}
	
	public void LevelUp() {
		if(this.EXP >= 100) {
			this.EXP -= 100;
			this.Level++;
			System.out.println("[SYSTEM]레벨 업! [" + this.Level + "]레벨이 되었습니다.");
			
			this.HP += 50;
			this.ATK += 10;
			this.DEF += 2;
		}
	}
}

class Warrior extends Character {
	@Override
	public boolean PutEquip(Equipment e) {
		if((e.getEquipCode()/100==1) || (e.getEquipCode()/100==4)) {
			super.PutEquip(e);
			return true;
		}
		else {
			System.out.println("[SYSTEM]직업군이 달라 장비를 착용할 수 없습니다.");
			return false;
		}
	}
}

class Magician extends Character {
	@Override
	public boolean PutEquip(Equipment e) {
		if((e.getEquipCode()/100==2) || (e.getEquipCode()/100==4)) {
			super.PutEquip(e);
			return true;
		}
		else {
			System.out.println("[SYSTEM]직업군이 달라 장비를 착용할 수 없습니다.");
			return false;
		}
	}
}

class Archer extends Character {
	@Override
	public boolean PutEquip(Equipment e) {
		if((e.getEquipCode()/100==3) || (e.getEquipCode()/100==4)) {
			super.PutEquip(e);
			return true;
		}
		else {
			System.out.println("[SYSTEM]직업군이 달라 장비를 착용할 수 없습니다.");
			return false;
		}
	}
}
