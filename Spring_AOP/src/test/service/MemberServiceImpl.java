package test.service;

public class MemberServiceImpl implements MemberService {
	
	
	@Override
	public void insert() {
		
		System.out.println("회원정보를 저장합니다.");
	}

	@Override
	public void select() {
		
		System.out.println("회원정보를 select 합니다.");
	}

}
