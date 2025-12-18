package com.example.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.test.dto.Article;

@Mapper
public interface ArticleDao {
	
	@Insert("""
			insert into article
				set regDate = now()
					, updateDate = now()
					, title = #{title}
					, content = #{content}
					, memberId = #{memberId}
			""")
	void writeArticle(int memberId, String title, String content);
	
	@Select("""
			select last_insert_id()
			""")
	int getLastArticleById();
	
	@Select("""
			select a.*, m.loginId as writerName
				from article as a 
				inner join member as m
				on m.id = a.memberId
				order by id desc
			""")
	List<Article> getListArticle();
	
	@Select("""
			select a.*, m.loginId as writerName
				from article as a 
				inner join member as m
				on m.id = a.memberId
				where a.id = #{id}
			""")
	Article getArticle(int id);
	
	@Select ("""
			select count(*)
				from article
			""") 
	int getListCountArticle();

}
