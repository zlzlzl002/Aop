package com.gura.step02.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dto.MemberDto;
import com.gura.step02.member.service.MemberService;

// 컨트롤러를 Bean 으로 만들기 
@Controller
public class MemberController {
	
	//의존 객체 주입 받기 
	@Autowired
	private MemberService service;
	
	/*
	 *  컨트롤러에서 폼 전송되는 파라미터를 추출하는 방법 3가지 
	 */
	//@RequestMapping("/member/insert")
	public ModelAndView insert1(HttpServletRequest request){
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//MemberDto 에 담기
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//MemberService 객체를 이용해서 저장
		ModelAndView mView=service.insert(dto);
		mView.setViewName("member/alert");
		return mView;
	}
	// @RequestParam 을 이용해서 파라미터 추출된 값 전달 받기
	@RequestMapping("/member/insert")
	public ModelAndView insert2(@RequestParam String name, 
				@RequestParam String addr){
		//MemberDto 에 담기
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//MemberService 객체를 이용해서 저장
		ModelAndView mView=service.insert(dto);
		mView.setViewName("member/alert");
		return mView;
	}
	// @ModelAttribute 을 이용해서 추출된 파라미터가 들어간 dto 전달받기
	// @RequestMapping("/member/insert")
	public ModelAndView insert3(@ModelAttribute MemberDto dto){
		
		ModelAndView mView=service.insert(dto);
		/* 
		 *  Redirect 이동 
		 *  
		 *  redirect: /요청경로
		 */
		//mView.setViewName("redirect:/member/list.do");
		
		// forward 이동 
		mView.setViewName("member/alert");
		return mView;
	}
	
	
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm(){
		/*
		 *  String type 을 리턴하면 view 페이지의 정보를 의미한다.
		 *  
		 *  /WEB-INF/views/member/insertform.jsp
		 */
		return "member/insertform";
	}
	
	//회원 목록 요청 처리 
	@RequestMapping("/member/list")
	public ModelAndView list(){
		
		//MemberService 객체를 이용해서 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView=service.getList();
		
		// 서비스 객체가 리턴해준 ModelAndView 객체에 view 페이지 정보
		// 담기
		mView.setViewName("member/list"); // forward 이동 
		
		// 모델과 view 페이지의 정보를 함께 담고 있는 ModelAndView
		// 객체를 리턴해 준다. 
		return mView;
	}
	
	//회원정보 삭제 요청 처리
	@RequestMapping(value="/member/delete")
	public String delete(@RequestParam int num){
		//int num=Integer.parseInt(request.getParameter("num"));
		
		service.delete(num);
		
		/*
		 *  redirect 응답 
		 *  
		 *  1. String type 을 리턴하는 경우
		 *  
		 *  return "redirect:/요청명" 
		 *  
		 *  2. ModelAndView type 을 리턴하는 경우
		 *  
		 *  ModelAndView mView=new ModelAndView();
		 *  mView.setViewName("redirect:/요청명");
		 *  return mView;
		 */
		return "redirect:/member/list.do";
	}
	
	//회원정보 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateForm(@RequestParam int num){
		
		//수정할 회원의 정보가 담긴 ModelAndView 객체를 리턴 받는다.
		ModelAndView mView=service.getData(num);
		// view 페이지 정보를 담고 
		mView.setViewName("member/updateform");
		
		// ModelAndView 객체를 리턴해 준다. 
		return mView;
		
	}
	
	//회원정보 수정 반영 요청 처리
	@RequestMapping("/member/update")
	public ModelAndView update(@ModelAttribute MemberDto dto){
		ModelAndView mView=service.update(dto);
		mView.setViewName("member/alert");
		return mView;
	}
}






















