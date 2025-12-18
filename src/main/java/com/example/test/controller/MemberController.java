package com.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.dto.Member;
import com.example.test.service.MemberService;
import com.example.test.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/usr/member/join")
	public String join() {
		return "/usr/member/join";
	}
	
	@PostMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name) {
		Member member = this.memberService.getLoginMemberId(loginId);
		if(member != null) {
			return Util.jsReplace(String.format("%s는 현재 사용중인 아이디 입니다.", loginId), "hb");
		}
		
		this.memberService.joinMember(loginId, loginPw, name);
		
		return Util.jsReplace(String.format("%s님 가입이 완료되었습니다.", loginId), "/");
	}
	
	@GetMapping("/usr/member/login")
	public String login() {
		return "/usr/member/login";
	}
	
	@PostMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpSession session, String loginId, String loginPw) {
		Member member = this.memberService.getLoginMemberId(loginId);
		if(member == null) {
			return Util.jsReplace("없는 아이디 입니다.", "hb");
		}
		
		if(!loginPw.equals(member.getLoginPw())) {
			return Util.jsReplace("비밀번호가 일치하지 않습니다.", "hb");
		}
		session.setAttribute("loginedMemberId", member.getId());
		
		return Util.jsReplace(String.format("%s님 환영합니다.", loginId), "/");
	}
	
	@GetMapping("/usr/member/modify")
	public String modify(HttpSession session, Model model) {
		
		Member member = this.memberService.getMember((int)session.getAttribute("loginedMemberId"));
		
	
		model.addAttribute("member", member);
		
		return "/usr/member/modify";
	}

	
	@PostMapping("/usr/member/doModify")
	@ResponseBody
	public String doModify(HttpSession session, String loginId, String loginPw, String name) {
		
		this.memberService.modifyMember((int)session.getAttribute("loginedMemberId"), loginPw, name);
		return Util.jsReplace(String.format("%s님의 프로필 수정이 완료되었습니다.", loginId), "/");
	}
	
	@GetMapping("/usr/member/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return Util.jsReplace("정상적으로 로그아웃 되었습니다.", "/");
	}
}

