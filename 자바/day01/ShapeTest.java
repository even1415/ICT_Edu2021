package day01;

public class ShapeTest {

	public static void main(String[] args) {
		//1. Rectangle객체 생성해서 가로, 세로 크기 정해서 area()호출해보기
		Rectangle rt=new Rectangle();
		rt.area(7, 12);
		
		//2. Triangle객체 생성해서 가로, 세로 크기 정해서 area()호출해보기
		Triangle tr=new Triangle();
		tr.area(7, 12);
		//3. Circle생성해보기.
		//Circle cr=new Circle(); [x]
		//추상클래스는 타입 선언은 가능하나, 객체생성은 할 수 없다.
		Circle cr= new SubCircle();
		cr.area(7, 12);
		((SubCircle)cr).area(12);
		
		//4. SubCircle생성해서 반지름값 정해서 area()호출해보기
		SubCircle sc=new SubCircle();
		sc.area(7);
		
		Shape sp=new Rectangle();
		sp.area(44, 11);
		
		//위에서 생성한 객체들을 저장할 배열을 선언하고 위 객체들을 저장하기
		Shape [] shape=new  Shape[5];
		shape[0]=rt;
		shape[1]=tr;
		shape[2]=cr;
		shape[3]=sc;
		shape[4]=sp;
		
		//for루프 이용해서 각 객체들의 면적을 구하세요. 사각형,직삼각형 20, 30, 원:20
		//instanceof활용하기
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
