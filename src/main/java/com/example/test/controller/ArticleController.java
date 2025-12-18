package com.example.test.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.dto.Article;
import com.example.test.service.ArticleService;
import com.example.test.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@GetMapping("/usr/article/write")
	public String write() {
		return "/usr/article/write";
	}
	
	@PostMapping("/usr/article/doWrite")
	@ResponseBody
	public String doWrite(HttpSession session, String title, String content) {
		
		this.articleService.writeArticle((int) session.getAttribute("loginedMemberId"), title, content);
		
		
		int id = this.articleService.getLastArticleById();
		
		return Util.jsReplace(String.format("%d번 게시글이 작성되었습니다.", id), "list");
	}
	
	@GetMapping("/usr/article/list")
	public String list(Model model) {
		List<Article> articles = this.articleService.getListArticle();
		
		model.addAttribute("articles", articles);
		
		return "/usr/article/list";
	}
	
	@GetMapping("/usr/article/detail")
	public String detail(Model model, int id) {
		Article article = this.articleService.getArticle(id);
		
		model.addAttribute("article", article);
		return "/usr/article/detail";
	}
}

