package day01;

public class Inheritance {

	public static void main(String[] args) {
		//1. Human객체 2개 생성해서 이름, 키값 부여하고
		//   printInfo()호출하기
		//Human h1=new Human();
		//h1.printInfo();
		
		Human h2=new Human("홍길동",180);
		h2.printInfo();
		
		//2. Superman객체 2개 생성해서 이름,키,초능력 주고
		// printInfo()호출해보기
		Superman s1=new Superman();
		s1.printInfo();
		
		Superman s2=new Superman("김슈퍼",177,300);
		s2.printInfo();
		
		s1.printInfo("##슈퍼맨 정보##");
		s2.printInfo("##슈퍼맨 정보##");
		
		//s2의 초능력을 충전해보기
		String str2=s2.printInfo("@@슈퍼맨 정보@@", 200);
		System.out.println(str2);
		
		//아쿠아맨 객체 1개 생성해서 printInfo()호출하기
		Aquaman a1=new Aquaman("인어공주",160, 88);
		a1.printInfo("##아쿠아맨 정보##");
		System.out.println("---------------------");
		//다형성 
		//부모타입 변수 선언 = new 자식객체생성()
		Human hs=new Superman("최슈퍼", 168, 700);
		//부모			자식
		// hs변수로
		//1. 이름출력
		System.out.println("이름: "+hs.getName());
		//2. 키
		System.out.println("키 : "+hs.getHeight());
		//3. 초능력 출력
		//System.out.println("초능력: "+hs.power); //[x]
		hs.printInfo();
		
		/* 부모타입으로 변수 선언하고 자식의 객체를 생성할 경우 
		 * 접근할 수 있는 변수나 메소드는 제한이 있다.
		 * [1] 부모로부터 상속받은 변수나 메소드 => 접근 가능
		 * [2] 자식이 가지고 있는 고유한 변수나 메소드는 => 접근 불가
		 * [3] 그러나 오버라이드한 메소드를 가지고 있을 경우는 => 접근 가능하면
		 * 		이때 호출되는 메소드는 오버라이드한 메소드가 자동으로 호출된다.
		 * */
		//부모 자식의 상속관계일 경우 형변환이 가능하다.
		System.out.println(((Superman)hs).power);
		
		Superman sm=(Superman)hs;
		System.out.println(sm.power);
		
		//hs로 printInfo(title)호출하되 @@슈퍼맨 정보@@ 도 같이 출력되게
		((Superman)hs).printInfo("@@슈퍼맨 정보@@");
		
		/*1. Human타입의 변수 선언 Aquaman 객체 생성하기
		 * 2. 이름,키, 스피드
		 * 3. printInfo()호출하기
		 * 4. printInfo(title)호출하기
		 * */
		Human aqaHuman = new Aquaman();
		System.out.println(aqaHuman.getName());
		System.out.println(aqaHuman.getHeight());
		System.out.println(((Aquaman)aqaHuman).speed);
		aqaHuman.printInfo();
		((Aquaman)aqaHuman).printInfo("[아쿠아맨 정보]");
		
		Human hs1 = new Aquaman("아쿠아맨", 160, 100);
		System.out.println("이름: "+hs1.getName());
		System.out.println("키 :"+hs1.getHeight());
		System.out.println(((Aquaman)hs1).speed);
		((Aquaman)hs1).printInfo("@@아쿠아맨 정보@@");
		
		/* h2, s1, a1, hs, aqaHuman, hs1 객체들을 저장할 배열을 선언하고
		 * 크기를 할당한 뒤 위 객체들을 배열에 저장하세요
		 * 그런뒤 for루프 이용해서 배열에 저장된 객체들의 printInfo()를 호출하세요
		 * */
		Human[] arr= {h2, s1, a1, hs, aqaHuman, hs1};
		//instanceof 연산자
		/* 참조변수 instanceof 클래스명
		 * : 참조변수가 클래스의 객체인지 여부를 묻는 연산자
		 *  해당 클래스의 객체이면 true를 반환하고,
		 *  그렇지 않으면 false를 반환한다.
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
