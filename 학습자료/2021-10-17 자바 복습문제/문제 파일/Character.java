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
		equipName = "����";
		equipCode = 0;
	}
	
	public void setNickName() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(" * �г����� �Է����ּ���. : ");
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

	public boolean PutEquip(/*��������*/) {
		/*
		�ڱ��� �ʿ��
		�������ڷ� ����� ������ �޾Ƽ�,
		���������� �����ϴ� �޼ҵ�(����� �ɷ�ġ�� ĳ���Ϳ��� ������)
   		 - equipName�� equipCode�� ������ ����� ������ �������� ��
    		 - �̿� �������ͽ� 4���� ĳ������ �������ͽ��� ������
		*/
		
		System.out.println(" * ��� ���� �Ϸ�.");
		
		return true;
	}
	
	public void gainEXP(int mobEXP) {
		//�ڱ��� �ʿ�� ���� óġ���� �� ����ġ�� ��� �޼ҵ�, LevelUp �޼ҵ带 �����Ѵ�.
	}
	
	public void gainGold(int mobGold) {
		//�ڱ��� �ʿ�� ���� óġ���� �� ���(�����ݾ�)�� ��� �޼ҵ�
	}
	
	public void LevelUp() {
		/*
		�ڱ��� �ʿ��
		����ġ�� 100�� �Ǹ� ������ �ϴ� �޼ҵ�.
		������ �� ĳ���� ������ ���� ������. (ü��+50, ���ݷ�+10, ����+2)
		*/
	}
}

class Warrior extends Character {
	/*
	�ڱ��� �ʿ��
	��� �����ϴ� �޼ҵ� �ʿ�.
	Warrior �� �˰� ���ʸ� ������ �����ϴ�.
	*/
}

class Magician extends Character {
	/*
	�ڱ��� �ʿ��
	��� �����ϴ� �޼ҵ� �ʿ�.
	Magician �� �������� ���ʸ� ������ �����ϴ�.
	*/
}

class Archer extends Character {
	/*
	�ڱ��� �ʿ��
	��� �����ϴ� �޼ҵ� �ʿ�.
	Archer �� Ȱ�� ���ʸ� ������ �����ϴ�.
	*/
}
