public class FindNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(int i=1; i<=10000; i++) {
			for(int j=i; j>0; j/=10) {
				if(j%10==7) count++;
			}
		}
		
		System.out.println("1부터 10000까지 숫자 7은 " + count + "개 포함");
	}
}

/*
 * <개념도>
 * 10000에는 7이 없으니 제외. 즉, 1~4자리 숫자들만 생각
 * 7XXX → 000 ~ 999까지 1천개
 * X7XX → 000 ~ 999까지 1천개
 * XX7X → 000 ~ 999까지 1천개
 * XXX7 → 000 ~ 999까지 1천개
 *  = 합계 총 4천개
*/