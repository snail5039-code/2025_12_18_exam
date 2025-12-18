package com.example.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.test.dao.ArticleDao;
import com.example.test.dto.Article;

@Service
public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public void writeArticle(int memberId, String title, String content) {
		this.articleDao.writeArticle(memberId, title, content);
	}

	public int getLastArticleById() {
		return this.articleDao.getLastArticleById();
	}

	public List<Article> getListArticle() {
		return this.articleDao.getListArticle();
	}

	public Article getArticle(int id) {
		return this.articleDao.getArticle(id);
	}

	public int getListCountArticle() {
		return this.articleDao.getListCountArticle();
	}



}
