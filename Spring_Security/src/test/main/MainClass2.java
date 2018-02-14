package test.main;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass2 {
	public static void main(String[] args) {
		// 가입할때 입력한 비밀번호라고 가정
		String pwd="1234";
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		// DB 에 저장된 암호화된 비밀번호라고 가정
		String hash1=encoder.encode(pwd);
		
		// 로그인 할때 입력한 비밀번호라고 가정
		String inputPwd="1234";
		
		// 입력한 비밀번호와 암호화된 비밀번호가 일치하는지 여부
		boolean isValid=BCrypt.checkpw(inputPwd, hash1);
		
		System.out.println("isValid:"+isValid);
		
		String inputPwd2="2345";
		
		boolean isValid2=BCrypt.checkpw(inputPwd2, hash1);
		
		System.out.println("isValid2:"+isValid2);
		
		
	}
}
