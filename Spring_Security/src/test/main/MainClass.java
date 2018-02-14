package test.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass {
	public static void main(String[] args) {
		// 비밀번호라고 가정
		String pwd="1234";
		String pwd2="1";
		String pwd3="2";
		
		// 비밀번호 인코더 객체 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		// 비밀번호를 인코딩 하기
		String hash1=encoder.encode(pwd);
		String hash2=encoder.encode(pwd2);
		String hash3=encoder.encode(pwd3);
		// 인코딩된 문자열 출력하기
		System.out.println(hash1);
		System.out.println("---------");
		System.out.println(hash2);
		System.out.println("---------");
		System.out.println(hash3);
	}
}
