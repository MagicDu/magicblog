package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.dao.ArticleMapper;
import cn.magicdu.blog.pojo.Article;
import cn.magicdu.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }
}
