public class Map {
	private String mapName;
	private int characterHP, mobHP;
	
	public Map(String mapName) {
		this.mapName = mapName;
		this.characterHP = 0;
		this.mobHP = 0;
	}
	
	public void insertMap() {
		System.out.println("[SYSTEM]" + mapName + " �ʿ� �����Ͽ����ϴ�.");
	}
	
	public void Battle(Character c, Monster m) {
		characterHP = c.getHP();
		mobHP = m.getHP();
		
		while(true) {
			mobHP -= (c.getATK()-m.getDEF());
			if(mobHP < 0) mobHP = 0;
			System.out.println("[SYSTEM]" + c.getNickName() + "�� ����! " + m.getMobName() + "�� HP : " + mobHP + " / " + m.getHP());
			characterHP -= (m.getATK() - c.getDEF());
			if(characterHP < 0) characterHP = 0;
			System.out.println("[SYSTEM]" + m.getMobName() + "�� ����! " + c.getNickName() + "�� HP : " + characterHP + " / " + c.getHP());
			
			
			if(characterHP==0 || mobHP==0) break;
		}
		
		if(characterHP>0 && mobHP==0) {
			System.out.println("[SYSTEM]�������� �¸��Ͽ����ϴ�!");
			System.out.println("[SYSTEM]����ġ " + m.getMobEXP() + "��(��) " + m.getMobGold() + "��带 �����߽��ϴ�.");
			GetReward(c, m);
		}
		else if(mobHP>0 && characterHP==0) {
			System.out.println("[SYSTEM]�������� �й��Ͽ����ϴ�. ��������ġ�� 10%�� �ҽ��ϴ�.");
			LoseEXP(c);
		}
		else {
			System.out.println("[SYSTEM]���º�! ���͵� �������� �ƹ��� �ҵ���� �������ϴ�.");
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
		monster[0] = new Monster("������", 1, 1, 50, 10, 5, 0);
		monster[1] = new Monster("���", 2, 2, 75, 0, 10, 1);
		monster[2] = new Monster("���浥��", 4, 3, 100, 10, 15, 5);
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
		
		bossMonster = new Monster("��������", 5, 10, 500, 100, 50, 25);
	}
	
	public void DungeonRun(Character c) {
		super.insertMap();
		super.Battle(c, bossMonster);
	}
	
}
