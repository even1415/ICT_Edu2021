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
		
		/*
		�ڱ��� �ʿ��
		���� ���� �� ���� �޼ҵ�.
		���� �� �������� ü���� �ʱ�ȭ�Ǹ�, �� �� �ȿ� 1ȸ�� ������ �ְ�޴´�.
    		����� �� �� Ȥ�� ���� ��� ü���� 0�� �ɶ����� �����ϸ�,
		   ������ ������ ����� ���� ����� �г�Ƽ�� �־�����.
		   �ذ��ݹ�� : �ڽ��� ���ݷ� - ����� ���� = �ڽ��� ��뿡�� �ִ� �������� �ȴ�
    		������ : ���Ͱ� ������ ����ġ�� ���(�����ݾ�) �� ĳ���Ϳ��� ����(GetReward �޼ҵ� ����)
    		���г�Ƽ : ĳ���Ͱ� ���� ������ ����ġ�� 10%�� �ҽ�(�Ҽ�������) (LoseEXP �޼ҵ� ����)
		�����º� : �ƹ��� ���� �Ͼ�� �ʴ´�(���º� �޼����� ���).
		*/
		
	}
	
	public void GetReward(Character c, Monster m) {
		/*
		�ڱ��� �ʿ��
		���� �¸� �� ���� ȹ�� �޼ҵ�
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
		monster[0] = new Monster("������", 1, 1, 50, 10, 5, 0);
		monster[1] = new Monster("���", 2, 2, 75, 0, 10, 1);
		monster[2] = new Monster("���浥��", 4, 3, 100, 10, 15, 5);
	}
	
	public Monster RandomCreate() {
		/*
		�ڱ��� �ʿ��
		0~2 ���� �� ���� 1�� �̾Ƽ� create �� ���� ��, create ���� �´� ���͸� ����(���� ����)
		*/
	}
	
	public void GrasslandRun(Character c) {
		/*
		�ڱ��� �ʿ��
		�� ���� �� �����ϴ� �κб��� �����ϴ� �޼ҵ� (��Ʈ : �Ʒ� Dungeon Ŭ���� ����)
		*/
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
