
public class Hello {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = 'A';
		System.out.println("Hello World");
		
		/*----------------------------------------*/
		int Native = 80;
		int Math = 60;
		int English = 70;
		int total = 0;
		double avg = 0;
		
		total = Native + Math + English;
		avg = total/3.0;
		
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);
		
		/*----------------------------------------*/
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 < num2);
		System.out.println(num1 > num2);
		
		/*----------------------------------------*/
		int a = 3;
		int b = 4;
		double result;
		
		//double result = a / b;
		//1. a/b 연산 : 몫계산 후 int형인 정수값만 출력 0
		//2. result에 대입(저장) : 0.0으로 자동 형변환 후 저장
		//3. double result = (double)a/b;
		//안되는 이유 : a/b 연산이 끝날 시점에 int형 값이라서 정수값인 0만 남음.
		//double로 소수점 이하를 남기려면 연산 끝난 직후에 double이어야 함
		
		//a,b 모두 명시적 형변환으로 double로 변환
		result = (double)a / (double)b;
		System.out.println(result);
		
		//a가 double, b가 int여서 연산 시에 b가 double로 묵시적 형변환
		result = (double)a / b;
		System.out.println(result);
		/*----------------------------------------*/
		int num3 = 7;
		int num4 = 3;
		
		System.out.println("num3 + num4 = " + (num3 + num4));
		System.out.println("num3 - num4 = " + (num3 - num4));
		System.out.println("num3 * num4 = " + (num3 * num4));
		System.out.println("num3 / num4 = " + (num3 / num4));
		System.out.println("num3 % num4 = " + (num3 % num4));
		
		short num = 10;
		num = (short)(num + 77L);
		int rate = 3;
		rate = (int)(rate * 3.5);
		System.out.println(num);
		System.out.println(rate);
		
		num = 10;
		rate = 3;
		num += 77L; //형변환 필요없음
		rate *= 3.5;
		System.out.println(num);
		System.out.println(rate);
		/*----------------------------------------*/
		int num5 = 11;
		int num6 = 22;
		boolean resultbool;
		
		resultbool = (num5>1) && (num5<100);
		System.out.println("1 초과 100 미만인가?" + resultbool);
		
		resultbool = (num6 % 2 == 0) || (num6 % 3 == 0);
		System.out.println("2 혹은 3의 배수인가?" + resultbool);
		
		resultbool = !(num1 != 0);
		System.out.println("0인가?" + resultbool);
		/*----------------------------------------*/
		int num7 = 0;
		int num8 = 0;
		boolean resultnum;
		
		resultnum = ((num7 += 10) < 0) && ((num8 += 10) > 0);
		System.out.println("result = " + resultnum);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8 + '\n');
		
		resultnum = ((num7 += 10) > 0) || ((num8 += 10) > 0);
		System.out.println("result = " + resultnum);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8);
	}

}
