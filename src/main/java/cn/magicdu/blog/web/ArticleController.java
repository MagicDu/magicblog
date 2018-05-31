package cn.magicdu.blog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("articles");
    }
}