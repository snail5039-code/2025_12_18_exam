package com.example.test.service;

import org.springframework.stereotype.Service;

import com.example.test.dao.MemberDao;
import com.example.test.dto.Member;

@Service
public class MemberService {
	private MemberDao memberDao;
	
	public MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Member getLoginMemberId(String loginId) {
		return this.memberDao.getLoginMemberId(loginId);
	}

	public void joinMember(String loginId, String loginPw, String name) {
		this.memberDao.joinMember(loginId, loginPw, name);
	}

	public Member getMember(int memberId) {
		return this.memberDao.getMember(memberId);
	}

	public void modifyMember(int memberId, String loginPw, String name) {
		this.memberDao.modifyMember(memberId, loginPw, name);
	}
}
