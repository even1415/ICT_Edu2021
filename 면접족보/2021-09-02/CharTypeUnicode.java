
public class CharTypeUnicode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char ch1 = '헐';
//		char ch2 = '확';
//		char ch3 = 54736;
//		char ch4 = 54869;
//		char ch5 = 0xD5D0;
//		char ch6 = 0xD655;
		
		char ch[] = {'헐', '확', 54736, 54869, 0xD5D0, 0xD655};
		
		for(int i=0; i<6; i+=2) {
			System.out.println(ch[i] + " " + ch[i+1]);
		}
		
//		System.out.println(ch1 + " " + ch2);
//		System.out.println(ch3 + " " + ch4);
//		System.out.println(ch5 + " " + ch6);
		
		final int MAX_SIZE = 100;
		final char CONST_CHAR = '상';
		final int CONST_ASSIGNED;
		
		CONST_ASSIGNED = 12;
		
		System.out.println("상수1 : " + MAX_SIZE);
		System.out.println("상수2 : " + CONST_CHAR);
		System.out.println("상수3 : " + CONST_ASSIGNED);
		
		System.out.println("AB" + '\b' + 'C');
		System.out.println("AB" + '\t' + 'C');
		System.out.println("AB" + '\n' + 'C');
		System.out.println("AB" + '\r' + 'C');
	}

}
