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
		System.out.print("입력 : ");
		extension = scanner.next();
	}
	
	private void FindExtension() {
		int i=0;
		
		while(extension.charAt(i)!='.') {
			fileName += extension.charAt(i);
			
			i++;
		}
		i++; //'.' 넘기는 용도
		while(i<extension.length()) {
			fileExtension += extension.charAt(i);
			
			i++;
		}
	}
	
	private void print() {
		System.out.println("출력 : 파일이름은 " + fileName + " 이며 확장자는 "
				+ fileExtension + " 입니다.");
	}
	
	public void run() {
		input();
		FindExtension();
		print();
	}
}
