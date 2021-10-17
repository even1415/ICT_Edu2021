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

	public boolean PutEquip(/*전달인자*/) {
		/*
		★구현 필요★
		전달인자로 장비의 정보를 받아서,
		장비아이템을 착용하는 메소드(장비의 능력치를 캐릭터에게 더해줌)
   		 - equipName과 equipCode는 착용한 장비의 정보가 나오도록 함
    		 - 이외 스테이터스 4종은 캐릭터의 스테이터스에 더해줌
		*/
		
		System.out.println(" * 장비 장착 완료.");
		
		return true;
	}
	
	public void gainEXP(int mobEXP) {
		//★구현 필요★ 몬스터 처치했을 때 경험치를 얻는 메소드, LevelUp 메소드를 실행한다.
	}
	
	public void gainGold(int mobGold) {
		//★구현 필요★ 몬스터 처치했을 때 골드(소지금액)를 얻는 메소드
	}
	
	public void LevelUp() {
		/*
		★구현 필요★
		경험치가 100이 되면 레벨업 하는 메소드.
		레벨업 시 캐릭터 스텟이 소폭 오른다. (체력+50, 공격력+10, 방어력+2)
		*/
	}
}

class Warrior extends Character {
	/*
	★구현 필요★
	장비를 장착하는 메소드 필요.
	Warrior 는 검과 갑옷만 착용이 가능하다.
	*/
}

class Magician extends Character {
	/*
	★구현 필요★
	장비를 장착하는 메소드 필요.
	Magician 은 스태프와 갑옷만 착용이 가능하다.
	*/
}

class Archer extends Character {
	/*
	★구현 필요★
	장비를 장착하는 메소드 필요.
	Archer 는 활과 갑옷만 착용이 가능하다.
	*/
}
