import java.util.Scanner;

class GameRun {
	private int select;
	private Character character;
	private Equipment[] equipment;
	private Map selectMap;

	public GameRun() {
		this.select = 0;
		
		equipment = new Equipment[4];
		equipment[0] = new Equipment(101, "�⺻ ��", 0, 10, 25, 0);
		equipment[1] = new Equipment(201, "�⺻ ������", 0, 25, 15, 0);
		equipment[2] = new Equipment(301, "�⺻ Ȱ", 5, 5, 40, 0);
		equipment[3] = new Equipment(401, "�⺻ ����", 50, 10, 5, 30);
	}

	public void Start() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(" * ���� ��� : 1. ���� / 2. ������ / 3. �ü�");
			System.out.print(" * ����� ������ �����ϼ���(1~3) : ");
			select = scanner.nextInt();
			
			if(select >= 1 && select <= 3) break;
			else System.out.println("[ALERT]1~3 ���ڷθ� �������ּ���.");
		}
	}
	
	public void setCharacter() {
		switch(select) {
		case 1 :
			character = new Warrior();
			character.setNickName();
			break;
		case 2 :
			character = new Magician();
			character.setNickName();
			break;
		case 3 :
			character = new Archer();
			character.setNickName();
			break;
		default :
			break;
		}
		System.out.println(" * ������ ���õǾ����ϴ�.");
	}
	
	public void setEquipment() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			while(true) {
				System.out.println(" * 1.�⺻ �� / 2. �⺻ ������ / 3. �⺻ Ȱ / 4. �⺻ ����");
				System.out.print(" * �����Ͻ� ��� �������ּ���. : ");
				select = scanner.nextInt();
			
				if(select >= 1 && select <= 4) break;
				else System.out.println("[ALERT]1~4 ���ڷθ� �������ּ���.");
			}
			if(character.PutEquip(equipment[select-1])) break;
		}
	}
	
	public void selectMenu() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			while(true) {
				System.out.println(" * 1.�Ĺ��ϱ� / 2. �������� / 3. ĳ������ ��ȸ / 4. ���� ����");
				System.out.print(" * �����Ͻ� �޴��� �������ּ��� : ");
				select = scanner.nextInt();
			
				if(select >= 1 && select <= 4) break;
				else System.out.println("[ALERT]1~4 ���ڷθ� �������ּ���.");
			}
			
			switch(select) {
			case 1 :
				selectMap = new Grassland("�ʿ�����");
				((Grassland) selectMap).GrasslandRun(character);
				break;
			case 2 :
				selectMap = new Dungeon("��������");
				((Dungeon) selectMap).DungeonRun(character);
				break;
			case 3 :
				getCharInfo();
				break;
			case 4 :
				System.out.println(" * ������ �����մϴ�.");
				break;
			default :
				break;
			}
			if(select == 4) break;
		}
	}
	
	public void getCharInfo() {
		System.out.println("-----ĳ��������-----");
		System.out.println("�г��� : " + character.getNickName());
		System.out.println("����(����ġ) : " + character.getLevel() + "(" + character.getEXP() + ")");
		System.out.println("HP/MP : " + character.getHP() + "/" + character.getMP());
		System.out.println("���ݷ�/���� : " + character.getATK() + "/" + character.getDEF());
		System.out.println("������ ��� : " + character.getEquipName());
	}
	
	public void Run() {
		Start();
		setCharacter();
		setEquipment();
		selectMenu();
	}
	
}


public class MyRPG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameRun gameRun = new GameRun();
		gameRun.Run();
	}
	
	

}
