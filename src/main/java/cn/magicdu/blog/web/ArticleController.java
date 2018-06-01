package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.util.MagicUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private Msg msg;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return MagicUtil.commonView("articles");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public  ModelAndView edit(){
        return MagicUtil.commonView("articles");
    }
}
