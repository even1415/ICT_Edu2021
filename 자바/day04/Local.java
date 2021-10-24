package day04;
//Local Inner class : 메소드 내부에 클래스를 정의한 경우
// [1] 이름 있는 로컬 이너 클래스
// [2] 이름 없는 로컬 이너 클래스 (Anonymous class)
public class Local {
	
	String str="멤버변수~~";
	
	public void sub() {
		int num=100;//지역변수(local변수)
		System.out.println("str: "+str);
		System.out.println("num: "+num);
		class LocalInner{
			String lstr="로컬이너 멤버변수##";
			void demo() {
				System.out.println("---demo()--------");
				//str
				System.out.println("str: "+str);
				//lstr
				System.out.println("lstr: "+lstr);
				//num
				System.out.println("num: "+num);
				//로컬이너 클래스에서는 final이 아닌 지역변수는 접근 불가능 (java7버전 이전)
			}
		}//LocalInner//////////
		LocalInner li=new LocalInner();
		li.demo();
	}//sub()----------------------
	
	public void test() {
		class LocalInner{
			
		}
	}
	
	public static void main(String[] args) {
		//sub()메소드 호출하세요
		Local lc=new Local();
		lc.sub();
		//로컬이너 클래스는 자기가 속한 메소드 안에서만 객체 생성을 해야 함
		//또한 클래스가 구성된 이후에 객체 생성이 가능하다.
		//LocalInner li=new LocalInner();//[x]
	}//main()-------------------------
}///////////////////////////////////
