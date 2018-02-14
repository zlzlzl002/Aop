package com.gura.step02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step02.member.dto.MemberDto;

//1. MemberDaoImpl 객체가 Spring Bean Container 에 등록 되도록 
@Repository
public class MemberDaoImpl implements MemberDao{
	
	//2. Spring Bean Container 에서 주입 받을수 있도록  
	@Autowired
	private SqlSession session;  //핵심 의존 객체 
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

}






