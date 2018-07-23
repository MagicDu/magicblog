package cn.magicdu.blog.service.impl;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.SystemParam;
import cn.magicdu.blog.dao.ArticleMapper;
import cn.magicdu.blog.pojo.Article;
import cn.magicdu.blog.service.ArticleService;
import cn.magicdu.blog.util.MagicUtil;
import cn.magicdu.core.DateUtil;
import cn.magicdu.core.date.DatePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void addArticle(Article article, Msg msg) {
        article.setArticleid(MagicUtil.createUUID());
        article.setPostdate(DateUtil.now(DatePattern.NORM_DATETIME_PATTERN));
        article.setCreatedate(DateUtil.now(DatePattern.NORM_DATETIME_PATTERN));
        article.setUserid("test");
        if(article.getCategoryid()==null) {
            article.setCategoryid("test");
        }
        articleMapper.addArticle(article);
        msg.setKey(SystemParam.OK);
        msg.setValue("article saved success");
    }
}
