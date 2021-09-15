class Marine {
	String name;
	public int hp;
	public int attack;
	public int defence;
	
	public Marine(String name, int hp, int attack, int defence) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		this.defence = defence;
	}
	
	public void Upgrade() {
		attack++;
		defence++;
	}
}

class BattleField {
	static int winner = 0;
	
	public static void Battle(Marine ally, Marine enemy) {
		while(true) {
			ally.hp -= (enemy.attack-ally.defence);
			enemy.hp -= (ally.attack-enemy.defence);
			
			if(ally.hp<=0 || enemy.hp<=0) break;
		}
		
		if(ally.hp>0 && enemy.hp<=0) winner = 1;
		else if(enemy.hp>0 && ally.hp<=0) winner = 2;
		else winner = 3;
	}
	
	public static void printWinner(Marine ally, Marine enemy) {
		if(winner==1)
			System.out.println(ally.name + "ÀÇ ½Â¸®!");
		else if(winner==2)
			System.out.println(enemy.name + "ÀÇ ½Â¸®!");
		else System.out.println("¹«½ÂºÎ!");
	}
}


public class RaiseMarine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine marine1 = new Marine("Áü ·¹ÀÌ³Ê", 850, 12, 3);
		Marine marine2 = new Marine("Å¸ÀÌÄ¿½º ÇÉµé·¹ÀÌ", 600, 18, 1);
		
		for(int i=1; i<=3; i++) {
			marine1.Upgrade();
			marine2.Upgrade();
		}
		
		BattleField.Battle(marine1, marine2);
		BattleField.printWinner(marine1, marine2);
	}

}
