package test.service;

import org.springframework.stereotype.Service;

// 어노테이션을 붙이고 component scan 을 이용해서 bean 으로 등록.
@Service
public class BoardServiceImpl implements BoardService{

	@Override
	public void insert() {
		System.out.println("게시글 정보를 저장합니다.");
	}

	@Override
	public void select() {
		System.out.println("게시글 목록을 불러옵니다.");
		
	}

}
