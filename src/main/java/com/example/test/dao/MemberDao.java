package com.example.test.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.test.dto.Member;

@Mapper
public interface MemberDao {
	
	@Select("""
			select *
				from member
				where loginId = #{loginId}
			""")
	Member getLoginMemberId(String loginId);
	
	@Insert("""
			insert into member
				set regDate = now()
					, updateDate = now()
					, loginId = #{loginId}
					, loginPw = #{loginPw}
					, name = #{name}
			""")
	void joinMember(String loginId, String loginPw, String name);
	
	@Select("""
			select *
				from member
				where id = #{memberId}
			""")
	Member getMember(int memberId);
	
	@Update("""
			update member
				set updateDate = now()
					, loginPw = #{loginPw}
					, name = #{name}
				where id = #{memberId}
			""")
	void modifyMember(int memberId, String loginPw, String name);

}
