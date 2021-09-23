public class CharInsertAlpabet {
	private char alpabet[];

	public CharInsertAlpabet() {
		this.alpabet = new char[26];
	}
	
	private void input() {
		for(int i=0; i<alpabet.length; i++) {
			alpabet[i] = (char)(65+i);
		}
	}
	
	private void print() {
		for(int i=0; i<alpabet.length; i++) {
			System.out.print(alpabet[i] + " ");
			if(i==9 || i==19) System.out.println(); //10개마다 줄바꿈
		}
	}
	
	public void run() {
		input();
		print();
	}
}
