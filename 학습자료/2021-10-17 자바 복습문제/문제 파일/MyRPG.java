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
		/*
		★구현 필요★
		저장된 select 변수의 값에 따라 character 의 직업 선택 및 닉네임 입력
		*/

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
			
			/*
			★구현 필요★
			캐릭터 및 장비셋팅이 끝난 후, select 변수에
                                   	파밍하기(Grassland)/던전가기(Dungeon)/캐릭정보 조회/게임종료 기능을 Scanner로 받아서 실행
			*/

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
