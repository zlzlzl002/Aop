package com.gura.step02.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dao.MemberDao;
import com.gura.step02.member.dto.MemberDto;

//1.
@Service
public class MemberServiceImpl implements MemberService{
	
	//2. 의존 객체인 Dao 를 주입 받기 위해 
	@Autowired
	private MemberDao dao;
	
	@Override
	public ModelAndView insert(MemberDto dto) {
		//회원정보 저장 
		dao.insert(dto);
		
		//ModelAndView 객체를 생성해서 
		ModelAndView mView=new ModelAndView();
		
		//msg 라는 키값으로 String type 을 담는다.
		mView.addObject("msg","저장했습니다.");
		
		//리턴해준다. 
		return mView;
	}

	@Override
	public ModelAndView update(MemberDto dto) {
		dao.update(dto);
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("msg","회원정보를 수정했습니다.");
		
		return mView;
	}

	@Override
	public void delete(int num) {
		//Dao 를 이용해서 삭제한다.
		dao.delete(num);
	}

	@Override
	public ModelAndView getData(int num) {
		
		//수정할 회원의 정보를 얻어와서 
		MemberDto dto=dao.getData(num);
		//ModelAndView 객체에 담고 
		ModelAndView mView=new ModelAndView();
		mView.addObject("dto", dto);
		//리턴해 준다.
		return mView;
	}

	@Override
	public ModelAndView getList() {
		// Dao 를 이용해서 회원목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		
		ModelAndView mView=new ModelAndView();
		// Model 을 list 라는 키값으로 담는다. 
		mView.addObject("list", list);
		
		// Model 이 담긴 ModelAndView 객체를 리턴해 준다. 
		return mView;
	}

}









