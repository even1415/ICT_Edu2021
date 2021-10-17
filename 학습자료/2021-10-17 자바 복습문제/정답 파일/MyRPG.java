import java.util.Scanner;

class GameRun {
	private int select;
	private Character character;
	private Equipment[] equipment;
	private Map selectMap;

	public GameRun() {
		this.select = 0;
		
		equipment = new Equipment[4];
		equipment[0] = new Equipment(101, "기본 검", 0, 10, 25, 0);
		equipment[1] = new Equipment(201, "기본 스태프", 0, 25, 15, 0);
		equipment[2] = new Equipment(301, "기본 활", 5, 5, 40, 0);
		equipment[3] = new Equipment(401, "기본 갑옷", 50, 10, 5, 30);
	}

	public void Start() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println(" * 직업 목록 : 1. 전사 / 2. 마법사 / 3. 궁수");
			System.out.print(" * 당신의 직업을 선택하세요(1~3) : ");
			select = scanner.nextInt();
			
			if(select >= 1 && select <= 3) break;
			else System.out.println("[ALERT]1~3 숫자로만 선택해주세요.");
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
		System.out.println(" * 직업이 선택되었습니다.");
	}
	
	public void setEquipment() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			while(true) {
				System.out.println(" * 1.기본 검 / 2. 기본 스태프 / 3. 기본 활 / 4. 기본 갑옷");
				System.out.print(" * 착용하실 장비를 선택해주세요. : ");
				select = scanner.nextInt();
			
				if(select >= 1 && select <= 4) break;
				else System.out.println("[ALERT]1~4 숫자로만 선택해주세요.");
			}
			if(character.PutEquip(equipment[select-1])) break;
		}
	}
	
	public void selectMenu() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			while(true) {
				System.out.println(" * 1.파밍하기 / 2. 던전가기 / 3. 캐릭정보 조회 / 4. 게임 종료");
				System.out.print(" * 실행하실 메뉴를 선택해주세요 : ");
				select = scanner.nextInt();
			
				if(select >= 1 && select <= 4) break;
				else System.out.println("[ALERT]1~4 숫자로만 선택해주세요.");
			}
			
			switch(select) {
			case 1 :
				selectMap = new Grassland("초원지대");
				((Grassland) selectMap).GrasslandRun(character);
				break;
			case 2 :
				selectMap = new Dungeon("보스던전");
				((Dungeon) selectMap).DungeonRun(character);
				break;
			case 3 :
				getCharInfo();
				break;
			case 4 :
				System.out.println(" * 게임을 종료합니다.");
				break;
			default :
				break;
			}
			if(select == 4) break;
		}
	}
	
	public void getCharInfo() {
		System.out.println("-----캐릭터정보-----");
		System.out.println("닉네임 : " + character.getNickName());
		System.out.println("레벨(경험치) : " + character.getLevel() + "(" + character.getEXP() + ")");
		System.out.println("HP/MP : " + character.getHP() + "/" + character.getMP());
		System.out.println("공격력/방어력 : " + character.getATK() + "/" + character.getDEF());
		System.out.println("착용한 장비 : " + character.getEquipName());
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
