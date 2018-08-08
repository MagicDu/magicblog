package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.Article;
import cn.magicdu.blog.service.ArticleService;
import cn.magicdu.blog.service.CategoryService;
import cn.magicdu.blog.util.MagicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private Msg msg;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return MagicUtil.commonView("articles");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public  ModelAndView edit(){
        return MagicUtil.commonView("articles",categoryService.getUserCategory("test"));
    }

    @RequestMapping(value ="/savearticle",method = RequestMethod.POST)
    public  Msg savearticle(Article article){
        msg=Msg.getInstance();
        articleService.addArticle(article,msg);
        return msg;
    }
}
