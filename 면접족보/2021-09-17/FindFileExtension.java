import java.util.Scanner;

public class FindFileExtension {
	private String extension;
	private String fileName;
	private String fileExtension;
	
	
	
	public FindFileExtension() {
		this.extension = "";
		this.fileName = "";
		this.fileExtension = "";
	}

	private void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է� : ");
		extension = scanner.next();
	}
	
	private void FindExtension() {
		int i=0;
		
		while(extension.charAt(i)!='.') {
			fileName += extension.charAt(i);
			
			i++;
		}
		i++; //'.' �ѱ�� �뵵
		while(i<extension.length()) {
			fileExtension += extension.charAt(i);
			
			i++;
		}
	}
	
	private void print() {
		System.out.println("��� : �����̸��� " + fileName + " �̸� Ȯ���ڴ� "
				+ fileExtension + " �Դϴ�.");
	}
	
	public void run() {
		input();
		FindExtension();
		print();
	}
}
