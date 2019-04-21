package cn.magicdu.blog.web;

import cn.magicdu.blog.Msg;
import cn.magicdu.blog.pojo.User;
import cn.magicdu.blog.service.UserService;
import cn.magicdu.blog.util.MagicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;
    private Msg msg;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        return MagicUtil.commonView("index");
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public  User getUser(){
        User user=new User();
        user.setUsername("magicdu");
        user.setPassword("hello");
        return  user;
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public  Msg login(String username,String password){
            msg=Msg.getInstance();
            service.validateUser(username,password,msg);
            return msg;
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public  Msg register(User user){
        System.err.println("add user");
        msg=Msg.getInstance();
        service.addUser(user,msg);
        return msg;
    }
}
