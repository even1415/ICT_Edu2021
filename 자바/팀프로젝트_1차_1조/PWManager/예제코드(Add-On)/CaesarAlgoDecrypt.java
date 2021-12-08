import java.io.*;
import java.util.*;

public class CaesarAlgoDecrypt {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("암호 입력 : ");
		String s = sc.next();
		char[] st = s.toCharArray();
		char[] ch = new char[st.length];

		String word = "";
		for (int i = 0; i < st.length; i++) {
			int num = (int) st[i];

			if (65 <= num && num <= 90) {
				if (num - 3 < 65)
					num += 26;

			} else if (97 <= num && num <= 122) {
				if (num - 3 < 97)
					num += 26;

			} else if (48 <= num && num <= 57) {
				if (num - 3 < 48)
					num += 10;

			} else {
				if(65 <= (num-3) && (num-3) <= 90)
					num -= 26;
				if(97 <= (num-3) && (num-3) <= 122)
					num -= 26;
				if(48 <= (num-3) && (num-3) <= 57)
					num -= 10;
				if((num-3) < 33)
					num += 94;
			}
			num -= 3;
			ch[i] = (char) num;
			word += String.valueOf(ch[i]);
		}
		System.out.println("복호화 -> " + word);
	}
}