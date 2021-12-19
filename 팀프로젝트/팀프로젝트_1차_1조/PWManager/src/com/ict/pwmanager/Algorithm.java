package com.ict.pwmanager;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//암호화 알고리즘들 정의&분기 목적의 클래스(라이브러리)
public class Algorithm {
	String s = new String();
	public String alg;
    private String key = new String(); //(AES-128)16자리 키
    private String iv = new String(); // 16byte
    SingletonData singletonData = SingletonData.getSingletonSiteData();
	
	//알고리즘 분기점 메소드(암호화) : GuardLevel에 따라서 분기
	public String EncryptAlgorithm(SiteVO siteVO, int GuardLevel) {
		
		switch(GuardLevel) {
		case 1 :
			s = CaesarAlgoEncrypt(siteVO.getSitePW());
			break;
		case 2 :
			try {
				alg = "AES/CBC/PKCS5Padding";
				key = Integer.toString(siteVO.getSitekey()) + Integer.toString(singletonData.getKey()) 
					+ Integer.toString(siteVO.getSitekey()) + Integer.toString(singletonData.getKey()/100);
				iv = key.substring(0, 16);
				s = AESAlgoEncrypt(siteVO.getSitePW());
				} catch (Exception e) {
					System.out.println("AES Algorithm's Encrypt Exception");
				}
			break;
		default :
			break;
		}
		
		return s;
	}
	
	//알고리즘 분기점 메소드(복호화) : GuardLevel에 따라서 분기
	public String DecryptAlgorithm(SiteVO siteVO, int GuardLevel) {
		switch(GuardLevel) {
		case 1 :
			s = CaesarAlgoDecrypt(siteVO.getSitePW());
			break;
		case 2 :
			try {
				alg = "AES/CBC/PKCS5Padding";
				key = Integer.toString(siteVO.getSitekey()) + Integer.toString(siteVO.getKey()) 
					+ Integer.toString(siteVO.getSitekey()) + Integer.toString(siteVO.getKey()/100);
				iv = key.substring(0, 16);
				s = AESAlgoDecrypt(siteVO.getSitePW());
			} catch (Exception e) {
				System.out.println("AES Algorithm's Encrypt Exception");
			}
			break;
		default :
			break;
		}
		
		return s;
	}
	
	//카이사르(시저) 알고리즘 : 암호화
	public String CaesarAlgoEncrypt(String s) {
		char[] st = s.toCharArray();
		char[] ch = new char[st.length];

		String word = "";
		for (int i = 0; i < st.length; i++) {
			int num = (int) st[i];

			if (65 <= num && num <= 90) {
				if (num + 3 > 90)
					num -= 26;

			} else if (97 <= num && num <= 122) {
				if (num + 3 > 122)
					num -= 26;

			} else if (48 <= num && num <= 57) {
				if (num + 3 > 57)
					num -= 10;

			} else {
				if (65 <= (num + 3) && (num + 3) <= 90)
					num += 26;
				if (97 <= (num + 3) && (num + 3) <= 122)
					num += 26;
				if (48 <= (num + 3) && (num + 3) <= 57)
					num += 10;
				if ((num + 3) > 126)
					num -= 94;
			}
			num += 3;
			ch[i] = (char) num;
			word += String.valueOf(ch[i]);
		}
		
		return word;
	}
	
	//카이사르(시저) 알고리즘 : 복호화
	public String CaesarAlgoDecrypt(String sitePW) {
		String myPW = "";
		char[] st;
		st = sitePW.toCharArray();
		char[] ch = new char[st.length];
		
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
				if (65 <= (num - 3) && (num - 3) <= 90)
					num -= 26;
				if (97 <= (num - 3) && (num - 3) <= 122)
					num -= 26;
				if (48 <= (num - 3) && (num - 3) <= 57)
					num -= 10;
				if ((num - 3) < 33)
					num += 94;
			}
			num -= 3;
			ch[i] = (char) num;
			myPW += String.valueOf(ch[i]);
		}
		return myPW;
	}
	
	//AES 알고리즘 : 암호화
	public String AESAlgoEncrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(iv.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }
	
	//AES 알고리즘 : 복호화
	public String AESAlgoDecrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(iv.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
}
