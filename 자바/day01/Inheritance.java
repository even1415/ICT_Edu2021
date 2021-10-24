package day01;

public class Inheritance {

	public static void main(String[] args) {
		//1. Human��ü 2�� �����ؼ� �̸�, Ű�� �ο��ϰ�
		//   printInfo()ȣ���ϱ�
		//Human h1=new Human();
		//h1.printInfo();
		
		Human h2=new Human("ȫ�浿",180);
		h2.printInfo();
		
		//2. Superman��ü 2�� �����ؼ� �̸�,Ű,�ʴɷ� �ְ�
		// printInfo()ȣ���غ���
		Superman s1=new Superman();
		s1.printInfo();
		
		Superman s2=new Superman("�轴��",177,300);
		s2.printInfo();
		
		s1.printInfo("##���۸� ����##");
		s2.printInfo("##���۸� ����##");
		
		//s2�� �ʴɷ��� �����غ���
		String str2=s2.printInfo("@@���۸� ����@@", 200);
		System.out.println(str2);
		
		//����Ƹ� ��ü 1�� �����ؼ� printInfo()ȣ���ϱ�
		Aquaman a1=new Aquaman("�ξ����",160, 88);
		a1.printInfo("##����Ƹ� ����##");
		System.out.println("---------------------");
		//������ 
		//�θ�Ÿ�� ���� ���� = new �ڽİ�ü����()
		Human hs=new Superman("�ֽ���", 168, 700);
		//�θ�			�ڽ�
		// hs������
		//1. �̸����
		System.out.println("�̸�: "+hs.getName());
		//2. Ű
		System.out.println("Ű : "+hs.getHeight());
		//3. �ʴɷ� ���
		//System.out.println("�ʴɷ�: "+hs.power); //[x]
		hs.printInfo();
		
		/* �θ�Ÿ������ ���� �����ϰ� �ڽ��� ��ü�� ������ ��� 
		 * ������ �� �ִ� ������ �޼ҵ�� ������ �ִ�.
		 * [1] �θ�κ��� ��ӹ��� ������ �޼ҵ� => ���� ����
		 * [2] �ڽ��� ������ �ִ� ������ ������ �޼ҵ�� => ���� �Ұ�
		 * [3] �׷��� �������̵��� �޼ҵ带 ������ ���� ���� => ���� �����ϸ�
		 * 		�̶� ȣ��Ǵ� �޼ҵ�� �������̵��� �޼ҵ尡 �ڵ����� ȣ��ȴ�.
		 * */
		//�θ� �ڽ��� ��Ӱ����� ��� ����ȯ�� �����ϴ�.
		System.out.println(((Superman)hs).power);
		
		Superman sm=(Superman)hs;
		System.out.println(sm.power);
		
		//hs�� printInfo(title)ȣ���ϵ� @@���۸� ����@@ �� ���� ��µǰ�
		((Superman)hs).printInfo("@@���۸� ����@@");
		
		/*1. HumanŸ���� ���� ���� Aquaman ��ü �����ϱ�
		 * 2. �̸�,Ű, ���ǵ�
		 * 3. printInfo()ȣ���ϱ�
		 * 4. printInfo(title)ȣ���ϱ�
		 * */
		Human aqaHuman = new Aquaman();
		System.out.println(aqaHuman.getName());
		System.out.println(aqaHuman.getHeight());
		System.out.println(((Aquaman)aqaHuman).speed);
		aqaHuman.printInfo();
		((Aquaman)aqaHuman).printInfo("[����Ƹ� ����]");
		
		Human hs1 = new Aquaman("����Ƹ�", 160, 100);
		System.out.println("�̸�: "+hs1.getName());
		System.out.println("Ű :"+hs1.getHeight());
		System.out.println(((Aquaman)hs1).speed);
		((Aquaman)hs1).printInfo("@@����Ƹ� ����@@");
		
		/* h2, s1, a1, hs, aqaHuman, hs1 ��ü���� ������ �迭�� �����ϰ�
		 * ũ�⸦ �Ҵ��� �� �� ��ü���� �迭�� �����ϼ���
		 * �׷��� for���� �̿��ؼ� �迭�� ����� ��ü���� printInfo()�� ȣ���ϼ���
		 * */
		Human[] arr= {h2, s1, a1, hs, aqaHuman, hs1};
		//instanceof ������
		/* �������� instanceof Ŭ������
		 * : ���������� Ŭ������ ��ü���� ���θ� ���� ������
		 *  �ش� Ŭ������ ��ü�̸� true�� ��ȯ�ϰ�,
		 *  �׷��� ������ false�� ��ȯ�Ѵ�.
		 * */
		for(int i=0;i<arr.length;i++) {
			//System.out.println(arr[i]);
			if(arr[i] instanceof Superman) {
				((Superman)arr[i]).printInfo("****SuperMan Info****");
			}else if(arr[i] instanceof Aquaman) {
				((Aquaman)arr[i]).printInfo("****AquaMan Info****");
			}else {
				System.out.println("***Human Info****");
				arr[i].printInfo();
			}
			//arr[i].printInfo("****Man Info****");
			//System.out.println("******");
		}

	}
}
