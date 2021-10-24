package day02;
/*-Handle하는 방법
 * 발생된 예외를 try~catch절로 처리해보자
 * */
public class ExceptionTest {

	public static void main(String[] args) {
		String [] fruits= {"사과","배","포도"};
		try {
			for(int i=0;i<4;i++) {
				System.out.println(fruits[i]);
				
			}//for---
		}catch(ArrayIndexOutOfBoundsException e) {
			//예외 처리 코드
			System.out.println("배열 인덱스 범위가 초과됨. 수정하세요~");
		}
		System.out.println("##반드시 실행되어야 할 코드#####");

	}

}
