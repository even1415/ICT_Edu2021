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
		
		while(true) {
			mobHP -= (c.getATK()-m.getDEF());
			if(mobHP < 0) mobHP = 0;
			System.out.println("[SYSTEM]" + c.getNickName() + "의 공격! " + m.getMobName() + "의 HP : " + mobHP + " / " + m.getHP());
			characterHP -= (m.getATK() - c.getDEF());
			if(characterHP < 0) characterHP = 0;
			System.out.println("[SYSTEM]" + m.getMobName() + "의 공격! " + c.getNickName() + "의 HP : " + characterHP + " / " + c.getHP());
			
			
			if(characterHP==0 || mobHP==0) break;
		}
		
		if(characterHP>0 && mobHP==0) {
			System.out.println("[SYSTEM]전투에서 승리하였습니다!");
			System.out.println("[SYSTEM]경험치 " + m.getMobEXP() + "와(과) " + m.getMobGold() + "골드를 습득했습니다.");
			GetReward(c, m);
		}
		else if(mobHP>0 && characterHP==0) {
			System.out.println("[SYSTEM]전투에서 패배하였습니다. 보유경험치의 10%를 잃습니다.");
			LoseEXP(c);
		}
		else {
			System.out.println("[SYSTEM]무승부! 몬스터도 도망가고 아무런 소득없이 물러납니다.");
		}
	}
	
	public void GetReward(Character c, Monster m) {
		c.gainEXP(m.getMobEXP());
		c.gainGold(m.getMobGold());
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
		create = (int)(Math.random() * 3);
		return monster[create];
	}
	
	public void GrasslandRun(Character c) {
		super.insertMap();
		RandomCreate();
		super.Battle(c, monster[create]);
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
