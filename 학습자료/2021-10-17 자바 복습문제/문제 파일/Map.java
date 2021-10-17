public class Map {
	private String mapName;
	private int characterHP, mobHP;
	
	public Map(String mapName) {
		this.mapName = mapName;
		this.characterHP = 0;
		this.mobHP = 0;
	}
	
	public void insertMap() {
		System.out.println("[SYSTEM]" + mapName + " 맵에 진입하였습니다.");
	}
	
	public void Battle(Character c, Monster m) {
		characterHP = c.getHP();
		mobHP = m.getHP();
		
		/*
		★구현 필요★
		몬스터 조우 및 전투 메소드.
		└매 번 전투마다 체력은 초기화되며, 한 턴 안에 1회씩 공격을 주고받는다.
    		└어느 한 쪽 혹은 양쪽 모두 체력이 0이 될때까지 전투하며,
		   전투가 끝나면 결과에 따라 보상과 패널티가 주어진다.
		   ※공격방식 : 자신의 공격력 - 상대의 방어력 = 자신이 상대에게 주는 데미지가 된다
    		└보상 : 몬스터가 보유한 경험치와 골드(소지금액) 을 캐릭터에게 지급(GetReward 메소드 실행)
    		└패널티 : 캐릭터가 현재 보유한 경험치의 10%를 소실(소수점버림) (LoseEXP 메소드 실행)
		└무승부 : 아무런 일이 일어나지 않는다(무승부 메세지만 출력).
		*/
		
	}
	
	public void GetReward(Character c, Monster m) {
		/*
		★구현 필요★
		전투 승리 시 보상 획득 메소드
		*/
	}
	
	public void LoseEXP(Character c) {
		c.setEXP(0.9);
	}
}

class Grassland extends Map {
	Monster[] monster = new Monster[3];
	int create;

	public Grassland(String mapName) {
		super(mapName);
		create = 0;
		monster[0] = new Monster("슬라임", 1, 1, 50, 10, 5, 0);
		monster[1] = new Monster("고블린", 2, 2, 75, 0, 10, 1);
		monster[2] = new Monster("네펜데스", 4, 3, 100, 10, 15, 5);
	}
	
	public Monster RandomCreate() {
		/*
		★구현 필요★
		0~2 숫자 중 랜덤 1개 뽑아서 create 에 저장 후, create 값에 맞는 몬스터를 리턴(몬스터 생성)
		*/
	}
	
	public void GrasslandRun(Character c) {
		/*
		★구현 필요★
		맵 진입 후 전투하는 부분까지 실행하는 메소드 (힌트 : 아래 Dungeon 클래스 참고)
		*/
	}
	
}

class Dungeon extends Map {
	Monster bossMonster;

	public Dungeon(String mapName) {
		super(mapName);
		
		bossMonster = new Monster("보스몬스터", 5, 10, 500, 100, 50, 25);
	}
	
	public void DungeonRun(Character c) {
		super.insertMap();
		super.Battle(c, bossMonster);
	}
	
}
