package day01;

public class ShapeTest {

	public static void main(String[] args) {
		//1. Rectangle��ü �����ؼ� ����, ���� ũ�� ���ؼ� area()ȣ���غ���
		Rectangle rt=new Rectangle();
		rt.area(7, 12);
		
		//2. Triangle��ü �����ؼ� ����, ���� ũ�� ���ؼ� area()ȣ���غ���
		Triangle tr=new Triangle();
		tr.area(7, 12);
		//3. Circle�����غ���.
		//Circle cr=new Circle(); [x]
		//�߻�Ŭ������ Ÿ�� ������ �����ϳ�, ��ü������ �� �� ����.
		Circle cr= new SubCircle();
		cr.area(7, 12);
		((SubCircle)cr).area(12);
		
		//4. SubCircle�����ؼ� �������� ���ؼ� area()ȣ���غ���
		SubCircle sc=new SubCircle();
		sc.area(7);
		
		Shape sp=new Rectangle();
		sp.area(44, 11);
		
		//������ ������ ��ü���� ������ �迭�� �����ϰ� �� ��ü���� �����ϱ�
		Shape [] shape=new  Shape[5];
		shape[0]=rt;
		shape[1]=tr;
		shape[2]=cr;
		shape[3]=sc;
		shape[4]=sp;
		
		//for���� �̿��ؼ� �� ��ü���� ������ ���ϼ���. �簢��,���ﰢ�� 20, 30, ��:20
		//instanceofȰ���ϱ�
		System.out.println("-----------------");
		for(Shape sap:shape) {
			if(sap instanceof SubCircle) {
				((SubCircle)sap).area(20);
			}else {
				sap.area(20, 30);
			}
			System.out.println("**********");
		}
		


	}

}
